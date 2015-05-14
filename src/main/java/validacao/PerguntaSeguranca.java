package validacao;

import model.Usuario;

/**
 *
 * @author rvsfara
 */
public class PerguntaSeguranca implements EstrategiaValidacao{
    Usuario usu;

    public PerguntaSeguranca(Usuario usu) {
        this.usu = usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }
    @Override
    public Boolean autenticar(Usuario usu) {
        System.out.println("Realizando Autenticação Com Pergunta de Segurança");
        return usu.getResSeguranca().equalsIgnoreCase("wolverine");
    }
}
