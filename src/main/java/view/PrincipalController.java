package view;

import comand.Padrao;
import comand.ValidacaoComand;
import dao.MensagemDao;
import dao.UsuarioDao;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Mensagem;
import model.Pasta;
import model.Usuario;
import proxy.PastaProxy;
import state.Conectado;

/**
 * FXML Controller class
 *
 * @author rvsfara
 */
public class PrincipalController implements Initializable {

    @FXML
    private Label msg;
    @FXML
    private ListView<Usuario> lstUsuarios;
    @FXML
    private ListView<Pasta> lstPastas;
    //@FXML 
    //private ListView<Arquivo> lstArquivos;
    @FXML
    private ListView<Mensagem> lstMensagens;
    Usuario usu = null;
    PastaProxy proxy = null;


    /**
     * Initializes the controller class.
     *
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listarTudo();
        //Stage tela = (Stage) lstUsuarios.getScene().getWindow();
        //ValidacaoComand validar = new Padrao();
        //usu = validar.autenticar(tela.getTitle());
    }

    @FXML
    private void cadUsuario() throws IOException {
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(CadUsuarioController.class.getResource("/fxml/CadUsuario.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Adicionar Usuário");
        stage.show();
    }

    @FXML
    private void listarUsuarios() {
        UsuarioDao uDao = new UsuarioDao();
        try {
            lstUsuarios.setItems(FXCollections.observableList(uDao.allEntries()));
        } catch (Exception ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void listarMensagens() {
        MensagemDao mDao = new MensagemDao();
        try {
            lstMensagens.setItems(FXCollections.observableList(mDao.allEntries()));
        } catch (Exception ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void listarPastas() {
        Pasta pasta = lstUsuarios.getSelectionModel().getSelectedItem().getDiretorio();
        lstPastas.getItems().clear();
        lstPastas.getItems().add(pasta);
    }

    @FXML
    private void efetuarOperacoes() {
        Stage tela = (Stage) lstUsuarios.getScene().getWindow();
        ValidacaoComand vl = new Padrao();
        usu = vl.autenticar(tela.getTitle());
        usu.setEstado(new Conectado());
        Usuario usu2 = lstUsuarios.getSelectionModel().getSelectedItem();
        if (usu.getUsuario().equals(usu2.getUsuario())) {
            proxy = new PastaProxy(usu);
            msg.setText("Mensagem: " + proxy.realizaOperacoes());
        } else {
            if (usu.getAdmin()) {
                usu2.setEstado(new Conectado());
                proxy = new PastaProxy(usu2);
                msg.setText("Mensagem: " + proxy.realizaOperacoes());
            } else {
                Alert alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Informação");
                alert.setHeaderText("Você não é admnistrador");
                alert.setContentText("Somente Admnistrador podem efetuar operações em outros usuários!");
                alert.showAndWait();
            }
        }

    }

    @FXML
    public void listarTudo() {
        listarUsuarios();
        listarMensagens();
    }

    @FXML
    public void Sair() {
        Platform.exit();
    }
}
