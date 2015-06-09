package view;

import dao.PastaDao;
import dao.UsuarioDao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Pasta;
import model.Usuario;
import state.Desconectado;

/**
 * FXML Controller class
 *
 * @author rvsfara
 */
public class CadUsuarioController implements Initializable {
    @FXML
    private TextField txtNome;
    @FXML
    private TextField txtUsuario;
    @FXML
    private PasswordField txtSenha;
    @FXML
    private TextField txtPseguranca;
    @FXML
    private TextField txtRseguranca;
    @FXML
    private TextField txtPasta;
    @FXML
    private TextField txtCPasta;
    @FXML
    private CheckBox ckbAdmin;
    @FXML
    public void Salvar(ActionEvent event) throws IOException {
        Usuario usu = new Usuario();
        usu.setNome(txtNome.getText());
        usu.setUsuario(txtUsuario.getText());
        usu.setSenha(txtSenha.getText());
        usu.setPerSeguranca(txtPseguranca.getText());
        usu.setResSeguranca(txtRseguranca.getText());
        Pasta pasta = new Pasta();
        pasta.setPas_nome(txtPasta.getText());
        pasta.setPas_caminho(txtCPasta.getText());
        PastaDao pDao = new PastaDao();
        pDao.salvar(pasta);
        usu.setAdmin(ckbAdmin.isSelected());
        usu.setDiretorio(pasta);
        usu.setEstado(new Desconectado());
        UsuarioDao uDao= new UsuarioDao();
        uDao.salvar(usu);        
    }
    @FXML
    public void Sair(){
        Stage Tela = (Stage) ckbAdmin.getScene().getWindow();
        Tela.close();   
    }
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
