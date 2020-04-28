/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author faisal7899
 */
public class Hotel {
     private Connection connect() throws SQLException{
        Connection cont = null;
        String url = "jdbc:sqlite:/home/faisal7899/NetBeansProjects/Project/src/Database/sqlite/HotelManagment.db";
        cont = DriverManager.getConnection(url);
        System.out.println("Connection to SQLite has been established.");
        return cont;
    }
    
    
   public void registerUser(String txtFname , String txtLname , String txtEmail , String txtUsername , String txtPassword ) throws SQLException
    {
        String sql = "INSERT INTO Users(FirstName,LastName,Email,Username,Password) VALUES('"+txtFname+"','"+txtLname+"' ,"
                + "'"+txtEmail+"' ,  '"+txtUsername+"' ,  '"+txtPassword+"')";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        //con.commit();
        con.close();
       
    }
    
    public boolean loginUser(String  username, String pass) throws SQLException
    {
        boolean b = false;
        String sql = "SELECT Username, Password FROM Users";
        Connection con = this.connect();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next())
        {
            String n = rs.getString("UserName");
            String p = rs.getString("Password");
            if(username.equals(n) && pass.equals(p))
            {
                b = true;
                break;
            }
            else
            {
                
                b= false;
            }    
        }
         st.close();
         con.close();
        return b;
        
    }
    
    public Connection UserData() throws SQLException{
  
      Connection con = this.connect();
     return con;
   }
}
