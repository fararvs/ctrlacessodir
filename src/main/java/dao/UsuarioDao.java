package dao;

import javax.persistence.PersistenceException;
import model.Usuario;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author rvsfara
 */
public class UsuarioDao extends GenericDao<Usuario>{
    public Usuario buscarPorLogin(String login) {
        Usuario usu = null;
        try {
            getEntityManager().getTransaction().begin();
            Session session = (Session) getEntityManager().getDelegate();  
            Criteria criteria = session.createCriteria(Usuario.class);
            criteria.add(org.hibernate.criterion.Restrictions.eq("usuario", login));
            //usu = (Usuario) criteria.list().get(0);
            usu = (Usuario) criteria.uniqueResult();
        } catch (PersistenceException e) {
            e.getMessage();
        }
        
        return usu;
    }
//    public Usuario buscarPorLogin(String login) {
//        Usuario usu = null;
//        getEntityManager().getTransaction().begin();
//        try {
//            usu = (Usuario) getEntityManager().createNamedQuery("Usuario.findByLogin")
//                    .setParameter("usuario", login)
//                    .getSingleResult();
//            System.out.println("Buscando usuário por login");
//        } catch (PersistenceException e) {
//            System.err.println(e.toString());
//            getEntityManager().getTransaction().rollback();
//        } 
//        getEntityManager().getTransaction().commit();
//        return usu;
//    }    
}
