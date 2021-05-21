package DataBaseConnection;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {

    Connection conn = null;
    public static final String url = "jdbc:oracle:thin:@alfred.cs.uwec.edu:1521:csdev";
    public static final String user= "******";
    public static final String pass = "*******";
    
    public static Connection java_db() {

        try{
        	
            Class.forName("oracle.jdbc.driver.OracleDriver");
            Connection conn = DriverManager.getConnection(url, user, pass);
            return conn;
            
            
        }catch(Exception e) {
            JOptionPane.showMessageDialog(null,e);
            return null;
        }

    }
}
