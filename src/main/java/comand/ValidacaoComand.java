package comand;

import model.Usuario;

/**
 *
 * @author rvsfara
 */
public interface ValidacaoComand {
    public Usuario autenticar(String chave);
}
