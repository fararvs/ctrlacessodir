package proxy;

import model.Pasta;
import model.Usuario;
import state.Conectado;
import state.Estado;
import comand.ValidacaoComand;
import state.Desconectado;

/**
 *
 * @author rvsfara
 */
public class PastaProxy implements IPasta{
    private final Usuario user;
    
    public PastaProxy(Usuario user) {
        this.user = user;
    }
    
    private String realiza(){       
        return user.getDiretorio().realizaOperacoes();
    }
    
    @Override
    public String realizaOperacoes() {
        if(user.getEstado().conectado()){
            return realiza();
        }else{
            return user.getEstado().enviaMensagem();
        }
    }
    
}
