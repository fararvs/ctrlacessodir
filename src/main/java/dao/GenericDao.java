package dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

/**
 *
 * @author rvsfara
 * @param <T>
 */
public abstract class GenericDao<T> {
    private EntityManager entityManager;
    private EntityManagerFactory factory;
 
    public GenericDao() {
    }
    
    public EntityManager getEntityManager(){
        return PersistenceFactory.getEntityManager();
    }
 
    public T getById(Long pk) {
        T object;
        try {
            getEntityManager().getTransaction().begin();
            object = (T) getEntityManager().find(getTypeClass(), pk);
            getEntityManager().getTransaction().commit();
        } catch (Exception e) {
            System.err.println(e.toString());
            getEntityManager().getTransaction().rollback();
            object = null;
        }
        return object;
    }
 
    public <T> boolean salvar(T entidade) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().persist(entidade);
            getEntityManager().getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println(e.toString());
            getEntityManager().getTransaction().rollback();
            return false;
        }
    }
 
    public <T> boolean atualizar(T entidade) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().merge(entidade);
            getEntityManager().getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println(e.toString());
            getEntityManager().getTransaction().rollback();
            return false;
        }
    }
 
    public <T> boolean remover(T entidade) {
        try {
            getEntityManager().getTransaction().begin();
            getEntityManager().remove(entidade);
            getEntityManager().getTransaction().commit();
            return true;
        } catch (Exception e) {
            System.err.println(e.toString());
            getEntityManager().getTransaction().rollback();
            return false;
        }
    }
 
    public List<T> findAll() {
        List<T> all;
        try{
            getEntityManager().getTransaction().begin();
            all= entityManager.createQuery(("FROM " + getTypeClass().getName()))
                .getResultList();
            getEntityManager().getTransaction().commit();
        }catch(Exception e){
            System.err.println(e.toString());
            getEntityManager().getTransaction().rollback();
            all = null;
        }
        return all;
    }
 
    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
}
