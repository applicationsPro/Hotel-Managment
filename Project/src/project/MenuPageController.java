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
 * @author Dell
 */
public class MenuPageController implements Initializable {
   @FXML
    private TableView<resturant> tvRest;

    @FXML
    private TableColumn<resturant, String> itemC;
    ObservableList<resturant> Rlist = FXCollections.observableArrayList();
    @FXML
    private Button addButt;
    @FXML
    private Button back;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        restMODEL a = new restMODEL();
        
         try {
            Connection con = a.showItemsList();
            String sql = "SELECT * FROM Menu";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
              
               Rlist.add(new resturant(rs.getInt("itemId"), rs.getString("item")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(MenuPageController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
         tvRest.getSelectionModel().cellSelectionEnabledProperty().set(true);

        itemC.setCellValueFactory(new PropertyValueFactory<>("item"));
        
        tvRest.setItems(Rlist);
        tvRest.setEditable(true);
        tvRest.getSelectionModel().cellSelectionEnabledProperty().set(true);
    }    
   
    @FXML
    private void AddNewItemhandler(ActionEvent event) throws IOException {
        addButt.getScene().getWindow().hide();
        Parent root = FXMLLoader.load(getClass().getResource("NewItem.fxml"));

        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
         stage.resizableProperty().setValue(false);
        stage.setTitle("NewItem");
        stage.show();
        
       
    }

    @FXML
    private void Delethandler(ActionEvent event) throws SQLException {
          resturant D=tvRest.getSelectionModel().getSelectedItem();
        Rlist.remove(D);
        restMODEL a = new restMODEL();
        a.dele(D.itemId);
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
