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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author faisal7899
 */
public class AddRoomController implements Initializable {

    @FXML
    private TextField txtRoomNo;
    @FXML
    private ComboBox<String> txtRoomType;
    @FXML
    private TextField txtPriceDay;
    @FXML
    private TextField txtNoBeds;
    @FXML
    private ComboBox<String> txtAvailability;
    @FXML
    private Button back;


    /**
     * Initializes the controller class.
     * @param url     
     * @param rb     
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       txtRoomType.getItems().add("Single");
       txtRoomType.getItems().add("Double");
       txtRoomType.getItems().add("Suite");
       
       //Availability
       txtAvailability.getItems().add("Yes");
       txtAvailability.getItems().add("No");
    
    }    

    @FXML
    private void addroom(ActionEvent event) throws SQLException {
        Room r = new Room();
        r.NewRoom(txtRoomNo.getText(), txtRoomType.getValue(), txtPriceDay.getText(), txtNoBeds.getText(), txtAvailability.getValue());
    }

    @FXML
    private void back(ActionEvent event) throws IOException {
         back.getScene().getWindow().hide();
         Parent root = FXMLLoader.load(getClass().getResource("HotelServices.fxml"));
         Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
         stage.resizableProperty().setValue(false);
        stage.setTitle("Services");
        stage.show();
        
    }
    
}
