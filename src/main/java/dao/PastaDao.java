package dao;

import java.util.List;
import model.Pasta;

/**
 *
 * @author rvsfara
 */
public class PastaDao extends GenericDao<Pasta>{
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
