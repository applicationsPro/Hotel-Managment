/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author faisal7899
 */
public class LoginController implements Initializable {

   
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    
    @FXML
   private Label lblout;
    @FXML
    private Button login;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
      
    }    

    @FXML
    private void login(ActionEvent event) throws IOException, SQLException {
        Hotel h = new Hotel();
        boolean t = h.loginUser(txtUsername.getText(), txtPassword.getText());
        if(t == true)
        {
          lblout.setText("Welcome");
           login.getScene().getWindow().hide();
          Parent root = FXMLLoader.load(getClass().getResource("HotelServices.fxml"));
        
         Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Services");
         stage.resizableProperty().setValue(false);
        stage.show();
        }
        else
        {
            lblout.setText("wrong user & pass");
        } 
    }

    @FXML
    private void register(ActionEvent event) throws IOException {
       
        Parent root = FXMLLoader.load(getClass().getResource("Register.fxml"));
        Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setTitle("Register");
         stage.resizableProperty().setValue(false);
        stage.setScene(scene);
        stage.show();
        
    }
    
}
