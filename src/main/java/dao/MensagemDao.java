package dao;

import java.util.List;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Mensagem;

/**
 *
 * @author rvsfara
 */
public class MensagemDao extends GenericDao<Mensagem>{
    public List<Mensagem> allEntries() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Mensagem> cq = cb.createQuery(Mensagem.class);
        Root<Mensagem> rootEntry = cq.from(Mensagem.class);
        CriteriaQuery<Mensagem> all = cq.select(rootEntry);
        TypedQuery<Mensagem> allQuery = getEntityManager().createQuery(all);
        return allQuery.getResultList();
    }  
}
