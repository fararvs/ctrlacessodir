package template;

import dao.PastaDao;
import dao.UsuarioDao;
import model.Pasta;
import model.Usuario;

/**
 *
 * @author rvsfara
 */
public class Template {
    public static void popularBanco() {
        PastaPadrao.criarPastaPadrao();
        UsuarioPadrao.criarUsuarioPadrao();
        ligarPastaAoUsuario();
    }
    public static void ligarPastaAoUsuario(){
        PastaDao pDao = new PastaDao();
        
        @SuppressWarnings("UnusedAssignment")
        Usuario u1 = new Usuario();
        UsuarioDao uDao = new UsuarioDao();
        u1 = uDao.buscarPorLogin("admin");
        Pasta p1 = new Pasta();
        p1 = pDao.buscarPorNome("Diretório Raiz");
        uDao = new UsuarioDao();
        uDao.atualizar(u1);
        
        @SuppressWarnings("UnusedAssignment")
        Usuario u2 = new Usuario();
        uDao = new UsuarioDao();
        u2 = uDao.buscarPorLogin("rvsfara");
        Pasta p2 = new Pasta();
        p2 = pDao.buscarPorNome("Rvsfara");
        uDao = new UsuarioDao();
        uDao.atualizar(u2);
        
        @SuppressWarnings("UnusedAssignment")
        Usuario u3 = new Usuario();
        uDao = new UsuarioDao();
        u3 = uDao.buscarPorLogin("juliano");
        Pasta p3 = new Pasta();
        p3 = pDao.buscarPorNome("Juliano");
        uDao = new UsuarioDao();
        uDao.atualizar(u3);
    }
}
