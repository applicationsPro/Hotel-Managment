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
public class ShowUsersController implements Initializable {

     @FXML
    private TableView<Users> UsersTable;
  
    @FXML
    private TableColumn<Users, String> FirstName;
    @FXML
    private TableColumn<Users, String> LastName;
    @FXML
    private TableColumn<Users, String> Email;
    @FXML
    private TableColumn<Users, String> Username;
    @FXML
    private TableColumn<Users, String> Password;
    
   ObservableList<Users> oblist = FXCollections.observableArrayList();
    @FXML
    private Button back;
    /**
     * Initializes the controller class.
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         Hotel h = new Hotel();
       try {
            Connection con = h.UserData();
            String sql = "SELECT * FROM Users";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next())
            {
                System.out.println("*****ViewUserController*********");
                System.out.println("FirstName= " + rs.getString("FirstName"));
                System.out.println(" LastName= " + rs.getString("LastName"));
                System.out.println("Email= " + rs.getString("Email"));
                System.out.println("Username= " + rs.getString("Username"));
                System.out.println(" Password= " + rs.getString("Password"));
                oblist.add(new Users(rs.getString("FirstName"), rs.getString("LastName"),
                        rs.getString("Email"),rs.getString("Username"), rs.getString("Password")));
            }
            // TODO
        } catch (SQLException ex) {
            Logger.getLogger(ShowUsersController.class.getName()).log(Level.SEVERE, null, ex);
        }
        UsersTable.setEditable(true);
         
        FirstName.setCellValueFactory(new PropertyValueFactory<>("FirstName"));
        LastName.setCellValueFactory(new PropertyValueFactory<>("LastName"));
        Email.setCellValueFactory(new PropertyValueFactory<>("Email"));
        Username.setCellValueFactory(new PropertyValueFactory<>("Username"));
        Password.setCellValueFactory(new PropertyValueFactory<>("Password"));
     
        
        UsersTable.setItems(oblist);
        
        UsersTable.getSelectionModel().cellSelectionEnabledProperty().set(true);
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
