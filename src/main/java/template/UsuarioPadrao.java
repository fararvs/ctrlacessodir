package template;

import dao.MensagemDao;
import dao.UsuarioDao;
import model.Mensagem;
import model.Usuario;

/**
 *
 * @author rvsfara
 */
public class UsuarioPadrao {

    public UsuarioPadrao() {
    }
    

    public static void criarUsuarioPadrao() {
        
        Usuario usu = new Usuario();
        usu.setNome("Admnistrador do Sistema");
        usu.setAdmin(Boolean.TRUE);
        usu.setEstado(EstadoPadrao.criarEstadoPadrao());
        usu.setPerSeguranca("Qual seu personagem favorito");
        usu.setResSeguranca("wolverine");
        usu.setUsuario("admin");
        usu.setSenha("admin");
        Mensagem msg1 = new Mensagem();
        msg1.setTexto("Novo Usuário: "+usu.getNome());
        
        Usuario usu1 = new Usuario();
        usu1.setNome("Rafael Vieira Dos Santos");
        usu1.setAdmin(Boolean.FALSE);
        usu1.setEstado(EstadoPadrao.criarEstadoPadrao());
        usu1.setPerSeguranca("Qual seu time favorito");
        usu1.setResSeguranca("Corinthians");
        usu1.setUsuario("rvsfara");
        usu1.setSenha("rvsfara");
        Mensagem msg2 = new Mensagem();
        msg2.setTexto("Novo Usuário: "+usu1.getNome());
        
        Usuario usu2 = new Usuario();        
        usu2.setNome("Juliano Rodrigo Lamb");
        usu2.setAdmin(Boolean.FALSE);
        usu2.setEstado(EstadoPadrao.criarEstadoPadrao());
        usu2.setPerSeguranca("Qual seu time favorito");
        usu2.setResSeguranca("Palmeiras");
        usu2.setUsuario("juliano");
        usu2.setSenha("juliano");
        Mensagem msg3 = new Mensagem();
        msg3.setTexto("Novo Usuário: "+usu2.getNome());
        
        UsuarioDao uDao = new UsuarioDao();
        uDao.salvar(usu);
        uDao.salvar(usu1);
        uDao.salvar(usu2);

        MensagemDao mDao = new MensagemDao();
        mDao.salvar(msg1);
        mDao.salvar(msg2);
        mDao.salvar(msg3);
    }
}
