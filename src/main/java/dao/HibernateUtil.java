package dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author rvsfara
 */
@PersistenceContext
public class HibernateUtil {
    private static SessionFactory sessionFactory;
    private static Session session;
    private static EntityManagerFactory emf;
    private static EntityManager em;
    public static SessionFactory getSessionFactory(){
        if(sessionFactory==null){
            try{
                // Create the SessionFactory from hibernate.cfg.xml
                sessionFactory = new Configuration().configure().buildSessionFactory();
            }catch(HibernateException ex){
                System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
            }
        }
        return sessionFactory;
    }
    public static Session getSession() {
        if(session ==null){
            session = getSessionFactory().openSession();
        }
        return session;
    }
    //Singleton para criar factory apenas uma vez
    public static EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("default");
        }
        return emf;
    }
    //Retorna ultimo EM aberto e em execucao ou cria um novo.
    public static EntityManager getEntityManager() {
        if (em != null && em.isOpen()) {
            return em;
        } else {
            em = getEntityManagerFactory().createEntityManager();
            return em;
        }
    }
//    @Override
//    //Ver Com Professor Juliano ou Márcio sobre o método finalize()
//    @SuppressWarnings("FinalizeDeclaration")
//    protected void finalize(){
//        try {
//            super.finalize();
//        } catch (Throwable ex) {
//            Logger.getLogger(PersistenceFactory.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        emf.close();
//        System.out.println("finalize");
//    }
}
