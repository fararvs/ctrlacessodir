package test;

import util.PastaProxy;
import model.Usuario;
import validacao.EstrategiaValidacao;
import validacao.Padrao;
import validacao.PerguntaSeguranca;

/**
 *
 * @author rvsfara
 */
public class TestComandLine {

    public TestComandLine() {
    }
    public static void main(String[] args) {
        EstrategiaValidacao autentica;
        System.out.println("----------------------------------------------------");
        Usuario usu = new Usuario("root", "123456");
        autentica = new Padrao(usu);
        PastaProxy dirProxy = new PastaProxy(autentica, usu);
        dirProxy.realizaOperacoes();
        System.out.println("----------------------------------------------------");
        Usuario usu1 = new Usuario("root", "senha errada");
        autentica = new Padrao(usu1);
        dirProxy = new PastaProxy(autentica, usu1);
        dirProxy.realizaOperacoes();
        System.out.println("----------------------------------------------------");
        Usuario usu2 = new Usuario(null, null);
        usu2.setPerSeguranca("Qual seu personagem favorito");
        usu2.setResSeguranca("wolverine");
        autentica = new PerguntaSeguranca(usu2);
        dirProxy = new PastaProxy(autentica, usu2);
        dirProxy.realizaOperacoes();
        System.out.println("----------------------------------------------------");
        Usuario usu3 = new Usuario(null, null);
        usu3.setPerSeguranca("Qual seu personagem favorito");
        usu3.setResSeguranca("monica");
        autentica = new PerguntaSeguranca(usu3);
        dirProxy = new PastaProxy(autentica, usu3);
        dirProxy.realizaOperacoes();
    }
}
