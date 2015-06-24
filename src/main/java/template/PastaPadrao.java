package template;

import dao.MensagemDao;
import dao.PastaDao;
import model.Mensagem;
import model.Pasta;

/**
 *
 * @author rvsfara
 */
public class PastaPadrao extends Template{
    public static void criarPastaPadrao(){
        
        Pasta p = new Pasta();
        p.setPas_nome("Diretório Raiz");
        p.setPas_caminho("/");
        Mensagem msg = new Mensagem();
        msg.setTexto("Nova Pasta: " + p.getPas_nome());
        
        Pasta p1 = new Pasta();
        p1.setPas_nome("Rvsfara");
        p1.setPas_caminho("/rvsfara");
        Mensagem msg1 = new Mensagem();
        msg1.setTexto("Nova Pasta: " + p1.getPas_nome());
        
        Pasta p2 = new Pasta();
        p2.setPas_nome("Juliano");
        p2.setPas_caminho("/juliano");
        Mensagem msg2 = new Mensagem();
        msg2.setTexto("Nova Pasta: " + p2.getPas_nome());
        
        PastaDao pDao = new PastaDao();
        pDao.salvar(p);
        pDao.salvar(p1);
        pDao.salvar(p2);
        MensagemDao mDao = new MensagemDao();
        mDao.salvar(msg);
        mDao.salvar(msg1);
        mDao.salvar(msg2);
    }
    
}
