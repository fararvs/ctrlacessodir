package view;

import dao.UsuarioDao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Usuario;
import template.Template;

/**
 * FXML Controller class
 *
 * @author rvsfara
 */
public class LoginController extends Application implements Initializable {

    @FXML
    private Button btnEntrar;
    @FXML
    private Button btnSair;
    @FXML
    private TextField txtLogin;
    @FXML
    private PasswordField txtSenha;
    @FXML
    private Label mensagem;

    @FXML
    public void Entrar(ActionEvent event) throws IOException {
        String login = txtLogin.getText();
        String senha = txtSenha.getText();
        //Rotina.criarUsuarioPadrao();
        Template.popularBanco();
        UsuarioDao usuarios = new UsuarioDao();
        Usuario usuarioEcontrado = usuarios.buscarPorLogin(login);
        if (usuarioEcontrado != null) {
            if (usuarioEcontrado.getUsuario().equals(login) & usuarioEcontrado.getSenha().equals(senha)) {
                //Abrir Tela Principal do Sistema
                Stage stage = new Stage();
                Parent root = FXMLLoader.load(PrincipalController.class.getResource("/fxml/Principal.fxml"));
                Scene scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
                Stage Telalogin = (Stage) btnEntrar.getScene().getWindow();
                // do what you have to do
                Telalogin.close();

            } else {
                mensagem.setTextFill(Color.web("red"));
                mensagem.setText("Senha Incorreta");
            }
        }else{
            mensagem.setTextFill(Color.web("red"));
            mensagem.setText("Usuário não Encontrado");
        }
    }

    @FXML
    private void Sair() {
        Platform.exit();
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @Override
    public void start(Stage stage) {
        Parent root;
        try {
            //root = FXMLLoader.load(CtrlDir.class.getResource("src/main/resources/fxml/Login.fxml"));
            root = FXMLLoader.load(getClass().getResource("/fxml/Login.fxml"));
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Entrar em CTRLDIR");
            stage.show();
        } catch (IOException ex) {
            System.out.println("Não Encontrou Login.fxml");
            Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

}
