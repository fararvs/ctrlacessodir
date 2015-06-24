package comand;

import dao.UsuarioDao;
import model.Usuario;

/**
 *
 * @author rvsfara
 */
public class PerguntaSeguranca implements ValidacaoComand{
    String chave;

    public PerguntaSeguranca() {
    }
    @Override
    public Usuario autenticar(String chave) {
        UsuarioDao uDao = new UsuarioDao();
        Usuario usu = uDao.buscarPorResposta(chave);
        if(usu.getResSeguranca().equals(chave)){
            return usu;
        }
        System.out.println("Realizando Autenticação Com Pergunta de Segurança");
        return null;
    }
}
