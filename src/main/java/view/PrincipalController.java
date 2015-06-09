package view;

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
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import model.Mensagem;
import model.Pasta;
import model.Usuario;

/**
 * FXML Controller class
 *
 * @author rvsfara
 */
public class PrincipalController implements Initializable {
    //@FXML
    //private ListView<String> titleFeed = new ListView<>();
    @FXML 
    private ListView<Usuario> lstUsuarios;
    @FXML 
    private ListView<Pasta> lstPastas;
    //@FXML 
    //private ListView<Arquivo> lstArquivos;
    @FXML 
    private ListView<Mensagem> lstMensagens;

    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        listarTudo();
    }   
    @FXML
    private void cadUsuario() throws IOException{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(CadUsuarioController.class.getResource("/fxml/CadUsuario.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Adicionar Usuário");
        stage.show();
    }
    @FXML
    private void cadPasta() throws IOException{
        Stage stage = new Stage();
        Parent root = FXMLLoader.load(CadPastaController.class.getResource("/fxml/CadPasta.fxml"));
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Adicionar Pasta");
        stage.show();
    }
    
    private void listarUsuarios() {
        UsuarioDao uDao = new UsuarioDao();
        try {
            lstUsuarios.setItems(FXCollections.observableList(uDao.allEntries()));
        } catch (Exception ex) {
            Logger.getLogger(PrincipalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }   
    @FXML
    private void listarMensagens(){
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
    public void listarTudo(){
        listarUsuarios();
        listarMensagens();
    }
    @FXML
    public void Sair(){
        Platform.exit();
    }
}
