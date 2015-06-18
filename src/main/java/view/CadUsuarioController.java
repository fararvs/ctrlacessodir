package view;

import dao.PastaDao;
import dao.UsuarioDao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.stage.Stage;
import javax.persistence.PersistenceException;
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
    private Label msg;

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
        UsuarioDao uDao = new UsuarioDao();
        try {
            uDao.salvar(usu);
            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Informação");
            alert.setHeaderText("Usuário Salvo com Sucessor");
            alert.setContentText("Nome: "+usu.getNome());
            alert.showAndWait();
            limpar();
        } catch (PersistenceException e) {
            erro(e.getMessage());
        }

    }

    public void limpar() {
        txtNome.setText("");
        txtUsuario.setText("");
        txtSenha.setText("");
        txtPseguranca.setText("");
        txtRseguranca.setText("");
        txtPasta.setText("");
        txtCPasta.setText("");
        ckbAdmin.setSelected(false);
    }

    @FXML
    public void Sair() {
        Stage Tela = (Stage) ckbAdmin.getScene().getWindow();
        Tela.close();
    }

    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        limpar();
    }

    public void erro(String msg) {
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Erro ao Salvar");
        alert.setHeaderText("Ouve um Erro ao salvar");
        alert.setContentText("Descrição do Erro!");
        Label label = new Label("The exception stacktrace was:");
        TextArea textArea = new TextArea(msg);
        textArea.setEditable(false);
        textArea.setWrapText(true);

        textArea.setMaxWidth(Double.MAX_VALUE);
        textArea.setMaxHeight(Double.MAX_VALUE);
        GridPane.setVgrow(textArea, Priority.ALWAYS);
        GridPane.setHgrow(textArea, Priority.ALWAYS);

        GridPane expContent = new GridPane();
        expContent.setMaxWidth(Double.MAX_VALUE);
        expContent.add(label, 0, 0);
        expContent.add(textArea, 0, 1);
        // Set expandable Exception into the dialog pane.
        alert.getDialogPane().setExpandableContent(expContent);
        alert.showAndWait();
    }

}
