package template;

import dao.MensagemDao;
import dao.PastaDao;
import dao.UsuarioDao;
import model.Mensagem;
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
        @SuppressWarnings("UnusedAssignment")
        Pasta p1 = new Pasta();
        p1 = pDao.buscarPorNome("Diretório Raiz");
        u1.setDiretorio(p1);
        uDao = new UsuarioDao();
        uDao.atualizar(u1);
        Mensagem msg = new Mensagem();
        msg.setTexto("Definindo a Pasta: "+p1.getPas_nome()+" Com Usuário: "+u1.getNome());
        
        @SuppressWarnings("UnusedAssignment")
        Usuario u2 = new Usuario();
        uDao = new UsuarioDao();
        u2 = uDao.buscarPorLogin("rvsfara");
        @SuppressWarnings("UnusedAssignment")
        Pasta p2 = new Pasta();
        pDao = new PastaDao();
        p2 = pDao.buscarPorNome("Rvsfara");
        u2.setDiretorio(p2);
        uDao = new UsuarioDao();
        uDao.atualizar(u2);
        Mensagem msg1 = new Mensagem();
        msg1.setTexto("Definindo a Pasta: "+p2.getPas_nome()+" Com Usuário: "+u2.getNome());
        
        @SuppressWarnings("UnusedAssignment")
        Usuario u3 = new Usuario();
        uDao = new UsuarioDao();
        u3 = uDao.buscarPorLogin("juliano");
        @SuppressWarnings("UnusedAssignment")
        Pasta p3 = new Pasta();
        pDao = new PastaDao();
        p3 = pDao.buscarPorNome("Juliano");
        u3.setDiretorio(p3);
        uDao = new UsuarioDao();
        uDao.atualizar(u3);
        Mensagem msg2 = new Mensagem();
        msg2.setTexto("Definindo a Pasta: "+p3.getPas_nome()+" Com Usuário: "+u3.getNome());
        
        MensagemDao mDao = new MensagemDao();
        mDao.salvar(msg);
        mDao.salvar(msg1);
        mDao.salvar(msg2);
    }
}
