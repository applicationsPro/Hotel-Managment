/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author faisal7899
 */
public class HotelServicesController implements Initializable {


   

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    


    @FXML
    private void restaurant(ActionEvent event) throws IOException {
         Parent root = FXMLLoader.load(getClass().getResource("menuPage.fxml"));
        
        Scene scene = new Scene(root);
        
       
        Stage stage=new Stage();
        stage.setTitle("Restaurnt");
        stage.resizableProperty().setValue(false);
        stage.setScene(scene);
        stage.show();
        
    }
    


    @FXML
    private void showroom(ActionEvent event) throws IOException {
        
         Parent root = FXMLLoader.load(getClass().getResource("ShowRoom.fxml"));
        
         Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Rooms Table");
         stage.resizableProperty().setValue(false);
        stage.show();
    }

    @FXML
    private void showusers(ActionEvent event) throws IOException {
        
         Parent root = FXMLLoader.load(getClass().getResource("ShowUsers.fxml"));
        
         Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Users Table");
         stage.resizableProperty().setValue(false);
        stage.show();
        
    }
    @FXML
    private void addRoomPage(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("AddRoom.fxml"));
         
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Add new room");
         stage.resizableProperty().setValue(false);
        stage.show();
    }

@FXML
    private void exit(ActionEvent event) {
       
      Platform.exit();
        
    }

    
    
}
