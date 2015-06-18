package comand;

import dao.UsuarioDao;
import model.Usuario;

/**
 *
 * @author rvsfara
 */
public class Padrao implements ValidacaoComand{
    String chave;

    public Padrao() {
    }

    @Override
    public Usuario autenticar(String chave) {
        UsuarioDao uDao = new UsuarioDao();
        Usuario usuarioEcontrado = uDao.buscarPorLogin(chave);
        System.out.println("Realizando Autenticação Padrão");
        return usuarioEcontrado;
    }
}
