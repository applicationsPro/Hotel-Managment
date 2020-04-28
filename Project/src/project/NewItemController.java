/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;


/**
 * FXML Controller class
 *
 * @author Dell
 */
public class NewItemController implements Initializable {
 ObservableList<String> Cobserv1 = FXCollections.observableArrayList("chicken meal","shrimp meal","chicken nuggets","chicken nuggets spicy","fish meal","chicken burger","hummos","coleslaw","french fries","bun","cocktail sauce","nuggets sauce","mamoul","apple juice","cocktail juice","strwberry juice","orange juice","pepsi","pepsi diet","7 up","water");
    @FXML
    private ComboBox c1;
    @FXML
    private Label lblout;
    @FXML
    private Button add;
  
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         c1.setItems(Cobserv1);
    }  
    
    

    @FXML
    private void Addinghandler(ActionEvent event) throws SQLException {
        restMODEL a = new restMODEL();
       a.Adding(c1.getValue().toString());
        lblout.setText("done");
       
    }
    
}
