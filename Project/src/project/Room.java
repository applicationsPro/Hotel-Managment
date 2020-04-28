package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author faisal7899
 */
public class Room {
    private Connection connect() throws SQLException{
        Connection cont = null;
        String url = "jdbc:sqlite:/home/faisal7899/NetBeansProjects/Project/src/Database/sqlite/HotelManagment.db";
        cont = DriverManager.getConnection(url);
        System.out.println("Connection to SQLite has been established.");
        return cont;
    }
    
    
    
    public void NewRoom(String txtRoomNo ,String txtRoomType , String txtPriceDay , String txtNoBeds, String txtAvailability ) throws SQLException
    {
        String sql = "INSERT INTO Rooms(RoomNo,RoomType,PricePerDay,NoOfBeds,Availability) VALUES('"+txtRoomNo+"','"+txtRoomType+"' ,"
                + " '"+txtPriceDay+"' , '"+txtNoBeds+"' ,  '"+txtAvailability+"')";
        
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();
    }
    
    
    
    public void showRoom() throws SQLException  {
        String sql = "SELECT * FROM Rooms";
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        
         st.close();
         con.close();        
    }
    
    
    
    public Connection roomData() throws SQLException {
       
      Connection con = this.connect();
      
     return con;
     
   }
    
}
