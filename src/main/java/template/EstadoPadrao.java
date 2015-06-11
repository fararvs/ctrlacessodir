package template;

import dao.MensagemDao;
import model.Mensagem;
import state.Desconectado;
import state.Estado;

/**
 *
 * @author rvsfara
 */
public class EstadoPadrao {
    public static Estado criarEstadoPadrao(){
        Estado st = new Desconectado(); 
        Mensagem msg = new Mensagem();
        msg.setTexto("Definindo o Estado Default como Desconectado");
        MensagemDao mDao = new MensagemDao();
        mDao.salvar(msg);
        return st;
    }
}
