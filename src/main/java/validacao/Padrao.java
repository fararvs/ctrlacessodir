package validacao;

import model.Usuario;

/**
 *
 * @author rvsfara
 */
public class Padrao implements EstrategiaValidacao{
    private Usuario usu;

    public Padrao(Usuario usu) {
        this.usu = usu;
    }

    public void setUsu(Usuario usu) {
        this.usu = usu;
    }

    @Override
    public Boolean autenticar(Usuario usu) {
        System.out.println("Realizando Autenticação Padrão");
        return usu.getUsuario().equalsIgnoreCase("root") && usu.getSenha().equalsIgnoreCase("123456");
    }
}
