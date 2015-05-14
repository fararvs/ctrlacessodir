package util;

import model.Pasta;
import model.Usuario;
import state.Conectado;
import state.Estado;
import validacao.EstrategiaValidacao;

/**
 *
 * @author rvsfara
 */
public class PastaProxy implements IPasta{
    private Pasta dir;
    private final Usuario user;
    private final EstrategiaValidacao valida;
    private String msg;
    
    public PastaProxy(EstrategiaValidacao valida, Usuario user) {
        this.user = user;
        this.valida = valida;
    }
    
    private String realiza(){        
        Estado st = new Conectado();
        user.setEstado(st);
        System.out.println(user.getEstado());//Usuário Conectado
        dir = new Pasta();
        msg = dir.realizaOperacoes();
        System.out.println(msg);//Realizando Operações solicitadas para esse diretório
        return msg;
    }
    
    @Override
    public String realizaOperacoes() {
        if(valida.autenticar(user)){
            return realiza();
        }else{
            System.out.println(user.getEstado());//Usuário Desconectado
            System.out.println("Não é Permitido Acessar o diretório solicitado");
            return msg;
        }
    }
    
}
