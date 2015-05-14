package state;

/**
 *
 * @author rvsfara
 */
public class Desconectado implements Estado{
    private final String mensagem ="Usuário Desconectado";

    @Override
    public String enviaMensagem() {
        return this.mensagem;
    }

    @Override
    public Boolean conectado() {
        return false;
    }
    @Override
    public String toString() {
        return this.mensagem;
    }
    
}
