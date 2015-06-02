package dao;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

/**
 *
 * @author rvsfara
 */
@PersistenceContext
public class PersistenceFactory {
    private static EntityManagerFactory emf;
    private static EntityManager em;
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
    @Override
    //Ver Com Professor Juliano ou Márcio sobre o método finalize()
    @SuppressWarnings("FinalizeDeclaration")
    protected void finalize(){
        try {
            super.finalize();
        } catch (Throwable ex) {
            Logger.getLogger(PersistenceFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        emf.close();
        System.out.println("finalize");
    }
}
