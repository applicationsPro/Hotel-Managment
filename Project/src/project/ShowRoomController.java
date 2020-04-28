
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author faisal7899
 */
public class ShowRoomController implements Initializable {

    @FXML
    private TableView<TypeRoom> RoomTable;
    @FXML
    private TableColumn<TypeRoom, String> RoomNo;
    @FXML
    private TableColumn<TypeRoom, String> RoomType;
    @FXML
    private TableColumn<TypeRoom, String> priceDay;
    @FXML
    private TableColumn<TypeRoom, String> NoBeds;
    @FXML
    private TableColumn<TypeRoom, String> Availability;
    
    ObservableList<TypeRoom> oblist = FXCollections.observableArrayList();
    @FXML
    private Button back;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        Room  r = new Room();
       try {
            Connection con = r.roomData();
            String sql = "SELECT * FROM Rooms";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                
                System.out.println("*****ViewUserController*********");
                System.out.println("RoomNo= " + rs.getString("RoomNo"));
                System.out.println(" RoomType= " + rs.getString("RoomType"));
                System.out.println("PricePerDay= " + rs.getString("PricePerDay"));
                System.out.println("NoOfBeds= " + rs.getString("NoOfBeds"));
                System.out.println(" Availability= " + rs.getString("Availability"));
                
              oblist.add(new TypeRoom(rs.getString("RoomNo"),rs.getString("RoomType"),rs.getString("PricePerDay")
                        ,rs.getString("NoOfBeds"),rs.getString("Availability")));
            }
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(ShowRoomController.class.getName()).log(Level.SEVERE, null, ex);
        }
        RoomTable.setEditable(true);
         
        RoomNo.setCellValueFactory(new PropertyValueFactory<>("RoomNo"));
       RoomType.setCellValueFactory(new PropertyValueFactory<>("RoomType"));
        priceDay.setCellValueFactory(new PropertyValueFactory<>("PricePerDay"));
        NoBeds.setCellValueFactory(new PropertyValueFactory<>("NoOfBeds"));
       Availability.setCellValueFactory(new PropertyValueFactory<>("Availability"));
       
      
        RoomTable.setItems(oblist);
        
        RoomTable.getSelectionModel().cellSelectionEnabledProperty().set(true);
    }    

    @FXML
    private void back(ActionEvent event) throws IOException {
         back.getScene().getWindow().hide();
         Parent root = FXMLLoader.load(getClass().getResource("HotelServices.fxml"));
        
         Stage stage = new Stage();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Services");
         stage.resizableProperty().setValue(false);
        stage.show();
    }
    
}
