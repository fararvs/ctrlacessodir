package dao;

import java.util.List;
import javax.persistence.PersistenceException;
import model.Pasta;
import org.hibernate.Criteria;

/**
 *
 * @author rvsfara
 */
public class PastaDao extends GenericDao<Pasta>{
    public Pasta buscarPorNome(String nome) {
        Pasta pas = null;
        try {
            getEntityManager().getTransaction().begin();
            Criteria criteria = getSession().createCriteria(Pasta.class);
            criteria.add(org.hibernate.criterion.Restrictions.eq("pas_nome", nome));
            pas = (Pasta) criteria.uniqueResult();
        } catch (PersistenceException e) {
            e.getMessage();
        }
        getEntityManager().getTransaction().commit();
        return pas;
    }
    public List<Pasta> buscarNome(String pas_nome) {
        List<Pasta> pastas = null;

        getEntityManager().getTransaction().begin();
        
        pas_nome = "%" + pas_nome + "%";

        try {
            pastas = getEntityManager().createNamedQuery("Pasta.findByNome")
                    .setParameter("pas_nome", pas_nome)
                    .getResultList();
            System.out.println("Buscando pasta por nome");
        } catch (Exception e) {
            System.err.println(e.toString());
            getEntityManager().getTransaction().rollback();
        }
        
        getEntityManager().getTransaction().commit();
        return pastas;
    }
}
