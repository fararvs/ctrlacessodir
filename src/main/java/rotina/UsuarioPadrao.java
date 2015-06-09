package rotina;

import dao.MensagemDao;
import dao.PastaDao;
import dao.UsuarioDao;
import java.util.ArrayList;
import java.util.List;
import model.Mensagem;
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
        List<Mensagem> lstMsg = new ArrayList<>();
        //Criando a pasta raiz
        Pasta p = new Pasta();
        Pasta p1 = new Pasta();
        Pasta p2 = new Pasta();
        p.setPas_nome("Diretório Raiz");
        p1.setPas_nome("Rvsfara");
        p2.setPas_nome("Juliano");
        p.setPas_caminho("/");
        p1.setPas_caminho("/rvsfara");
        p2.setPas_caminho("/juliano");
        PastaDao pDao = new PastaDao();
        pDao.salvar(p);
        Mensagem msg = new Mensagem();
        msg.setTexto("Nova Pasta: "+p.getPas_nome());
        lstMsg.add(msg);
        pDao.salvar(p1);
        msg.setTexto("Nova Pasta: "+p1.getPas_nome());
        lstMsg.add(msg);
        pDao.salvar(p2);
        msg.setTexto("Nova Pasta: "+p2.getPas_nome());
        lstMsg.add(msg);
        //Criando o Estado default
        Estado st = new Desconectado();
        EstrategiaValidacao autentica;
        Usuario usu = new Usuario();
        Usuario usu1 = new Usuario();
        Usuario usu2 = new Usuario();
        usu.setNome("Admnistrador do Sistema");
        usu1.setNome("Rafael Vieira Dos Santos");
        usu2.setNome("Juliano Rodrigo Lamb");
        usu.setDiretorio(p);
        usu1.setDiretorio(p1);
        usu2.setDiretorio(p2);
        usu.setAdmin(Boolean.TRUE);
        usu1.setAdmin(Boolean.FALSE);
        usu2.setAdmin(Boolean.FALSE);
        usu.setEstado(st);
        usu1.setEstado(st);
        usu2.setEstado(st);
        usu.setPerSeguranca("Qual seu personagem favorito");
        usu1.setPerSeguranca("Qual seu time favorito");
        usu2.setPerSeguranca("Qual seu time favorito");
        usu.setResSeguranca("wolverine");
        usu1.setResSeguranca("Corinthians");
        usu2.setResSeguranca("Palmeiras");
        usu.setUsuario("admin");
        usu1.setUsuario("rvsfara");
        usu2.setUsuario("juliano");
        usu.setSenha("admin");
        usu1.setSenha("rvsfara");
        usu2.setSenha("juliano");
        UsuarioDao uDao = new UsuarioDao();
        uDao.salvar(usu);
        msg.setTexto("Novo Usuário: "+usu.getNome());
        lstMsg.add(msg);
        uDao.salvar(usu1);
        msg.setTexto("Novo Usuário: "+usu1.getNome());
        lstMsg.add(msg);
        uDao.salvar(usu2);
        msg.setTexto("Novo Usuário: "+usu2.getNome());
        lstMsg.add(msg);
        for (Mensagem teste : lstMsg) {
            System.out.println(teste.getTexto());
            MensagemDao mDao = new MensagemDao();
            mDao.salvar(teste);
        }
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
