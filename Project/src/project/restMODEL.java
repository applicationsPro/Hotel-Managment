
package project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class restMODEL {
     private Connection connect() throws SQLException {
        Connection conn = null;
        String url = "jdbc:sqlite:/home/faisal7899/NetBeansProjects/Project/src/Database/sqlite/HotelManagment.db";
        conn = DriverManager.getConnection(url);
        System.out.println("Connection to SQLite has been established.");
        return conn;
    }
     
     public void Adding( String c1) throws SQLException {
        String sql = "INSERT INTO Menu(item) VALUES('" + c1 + "')";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();

    }
     
       public void dele(int itemId) throws SQLException {
        String sql ="DELETE FROM Menu  WHERE itemId ="+ itemId +" ";
        Connection con = this.connect();
        Statement st = con.createStatement();
        st.executeUpdate(sql);
        st.close();
        con.close();

    }
       
        public Connection showItemsList() throws SQLException {
        Connection con = this.connect();
        return con;
    }
        
        
        
}
