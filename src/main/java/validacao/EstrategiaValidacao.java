package validacao;

import model.Usuario;

/**
 *
 * @author rvsfara
 */
public interface EstrategiaValidacao {
    public Boolean autenticar(Usuario usu);
}
