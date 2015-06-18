package comand;

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
        Usuario usu = null;
        System.out.println("Realizando Autenticação Com Pergunta de Segurança");
        return usu;
    }
}
