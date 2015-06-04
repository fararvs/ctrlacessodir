package rotina;

import dao.PastaDao;
import dao.UsuarioDao;
import model.Pasta;
import model.Usuario;
import state.Desconectado;
import state.Estado;
import validacao.EstrategiaValidacao;

/**
 *
 * @author rvsfara
 */
public class UsuarioPadrao {

    public UsuarioPadrao() {
    }
    

    public static void criarUsuarioPadrao() {
        //Criando a pasta raiz
        Pasta p = new Pasta();
        p.setPas_nome("Diretório Raiz");
        p.setPas_caminho("/");
        PastaDao pDao = new PastaDao();
        pDao.salvar(p);
        System.out.println("----------------------------------------------------");
        //Criando o Estado default
        Estado st = new Desconectado();
        System.out.println("----------------------------------------------------");
        EstrategiaValidacao autentica;
        Usuario usu = new Usuario();
        usu.setNome("Admnistrador do Sistema");
        usu.setDiretorio(p);
        usu.setAdmin(Boolean.TRUE);
        usu.setEstado(st);
        usu.setPerSeguranca("Qual seu personagem favorito");
        usu.setResSeguranca("wolverine");
        usu.setUsuario("admin");
        usu.setSenha("admin");
        UsuarioDao uDao = new UsuarioDao();
        uDao.salvar(usu);
//        autentica = new Padrao(usu);
//        PastaProxy dirProxy = new PastaProxy(autentica, usu);
//        dirProxy.realizaOperacoes();
//        System.out.println("----------------------------------------------------");
//        System.out.println("----------------------------------------------------");
//        Usuario usu1 = new Usuario("root", "senha errada");
//        autentica = new Padrao(usu1);
//        dirProxy = new PastaProxy(autentica, usu1);
//        dirProxy.realizaOperacoes();
//        System.out.println("----------------------------------------------------");
//        Usuario usu2 = new Usuario(null, null);
//        usu2.setPerSeguranca("Qual seu personagem favorito");
//        usu2.setResSeguranca("wolverine");
//        autentica = new PerguntaSeguranca(usu2);
//        dirProxy = new PastaProxy(autentica, usu2);
//        dirProxy.realizaOperacoes();
//        System.out.println("----------------------------------------------------");
//        Usuario usu3 = new Usuario(null, null);
//        usu3.setPerSeguranca("Qual seu personagem favorito");
//        usu3.setResSeguranca("monica");
//        autentica = new PerguntaSeguranca(usu3);
//        dirProxy = new PastaProxy(autentica, usu3);
//        dirProxy.realizaOperacoes();
    }
}
