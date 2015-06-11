package dao;

import java.util.List;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import model.Usuario;
import org.hibernate.Criteria;

/**
 *
 * @author rvsfara
 */
public class UsuarioDao extends GenericDao<Usuario>{
    public Usuario buscarPorLogin(String login) {
        Usuario usu = null;
        try {
            getEntityManager().getTransaction().begin();  
            Criteria criteria = getSession().createCriteria(Usuario.class);
            criteria.add(org.hibernate.criterion.Restrictions.eq("usuario", login));
            //usu = (Usuario) criteria.list().get(0);
            usu = (Usuario) criteria.uniqueResult();
        } catch (PersistenceException e) {
            e.getMessage();
        }
        getEntityManager().getTransaction().commit();
        return usu;
    }
    public List<Usuario> allEntries() {
        CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
        CriteriaQuery<Usuario> cq = cb.createQuery(Usuario.class);
        Root<Usuario> rootEntry = cq.from(Usuario.class);
        CriteriaQuery<Usuario> all = cq.select(rootEntry);
        TypedQuery<Usuario> allQuery = getEntityManager().createQuery(all);
        return allQuery.getResultList();
    }  
}
