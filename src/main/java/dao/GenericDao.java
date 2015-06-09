package dao;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
/**
 *
 * @author rvsfara
 * @param <T>
 */
public abstract class GenericDao<T> {
    private final Session session;
    private final EntityManager em;
    private final Class<T> persistentClass;
    public GenericDao() {
        //this.session = HibernateUtil.getSession();
        this.em = HibernateUtil.getEntityManager();
        this.session = (Session) em.getDelegate();
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }
    public EntityManager getEntityManager(){
        return em;
    }
    public Session getSession(){
        return session;
    }
    public T getById(Long pk) {
        T object;
        try {
            em.getTransaction().begin();
            object = (T) em.find(getTypeClass(), pk);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.toString());
            em.getTransaction().rollback();
            object = null;
        }finally{
            closeEM();
        }
        return object;
    }
    public <T> boolean salvar(T entidade) {
        try {
            em.getTransaction().begin();
            em.persist(entidade);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println(e.toString());
            em.getTransaction().rollback();
            return false;
        }
    }
    public <T> boolean atualizar(T entidade) {
        try {
            em.getTransaction().begin();
            em.merge(entidade);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println(e.toString());
            em.getTransaction().rollback();
            return false;
        }finally{
            closeEM();
        }
    }
    public <T> boolean remover(T entidade) {
        try {
            em.getTransaction().begin();
            em.remove(entidade);
            em.getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println(e.toString());
            em.getTransaction().rollback();
            return false;
        }finally{
            closeEM();
        }
    }
//    public List<T> findAll() {
//        List<T> all;
//        try{
//            getEntityManager().getTransaction().begin();
//            all= entityManager.createQuery(("FROM " + getTypeClass().getName()))
//                .getResultList();
//            getEntityManager().getTransaction().commit();
//        }catch(Exception e){
//            System.err.println(e.toString());
//            getEntityManager().getTransaction().rollback();
//            all = null;
//        }
//        return all;
//    } 
    public List<T> findAll() throws Exception {
        List<T> all;
        try{
            session.beginTransaction();
            all = session.createCriteria(persistentClass).list();
        }catch(Exception e){
            all=null;
            e.getMessage();
        }finally{
            session.close();
        }
        return all;
    }
    private void closeSession() {
        if (session != null && session.isOpen()) {
            session.close();
        }
    }
    private void closeEM(){
        if(em != null && em.isOpen()){
            em.close();
        }
    }
    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
}