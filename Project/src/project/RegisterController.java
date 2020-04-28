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
public class RegisterController implements Initializable {

   
    @FXML
    private Label lblout;
    @FXML
    private TextField txtFname;
    @FXML
    private TextField txtLname;
    @FXML
    private TextField txtEmail;
    @FXML
    private TextField txtUsername;
    @FXML
    private PasswordField txtPassword;
    @FXML
    private Button back;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void register(ActionEvent event) throws SQLException {
        
       Hotel h = new Hotel();
   
     if(txtFname.getText().isEmpty() || txtLname.getText().isEmpty() || txtEmail.getText().isEmpty() ||
                txtUsername.getText().isEmpty() || txtPassword.getText().isEmpty())
            lblout.setText("Require Information");
        else{ 
        h.registerUser(txtFname.getText(), txtLname.getText(), txtEmail.getText(), txtUsername.getText(), txtPassword.getText());
        lblout.setText("Done Register");
        }
        
    }
    

    @FXML
    private void back(ActionEvent event) throws IOException {
        back.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("HomePage.fxml"));
        
        Scene scene = new Scene(root);
      
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Home");
         stage.resizableProperty().setValue(false);
        stage.show();
    }
    
    }
    
    
    

