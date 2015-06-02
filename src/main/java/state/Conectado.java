package state;

/**
 *
 * @author rvsfara
 */
public class Conectado implements Estado{
    private final String mensagem ="Usuário Conectado";
    @Override
    public String enviaMensagem() {
        return this.mensagem;
    }

    @Override
    public Boolean conectado() {
        return true;
    }

    @Override
    public String toString() {
        return this.mensagem;
    }
    
    
}
