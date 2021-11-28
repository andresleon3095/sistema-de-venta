
package clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class conexion {
    
    String url = "jdbc:mysql://localhost:3306/pruebas";
     String user = "root";
     String password = "1234";
        
    
     Connection conn = null;
     CallableStatement stmt = null;
     
        
    public Connection conexion(String _url , String _user , String _password){
        
        url = _url;
        user = _user;
        password = _password;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
             conn = DriverManager.getConnection(url, user, password);
             System.out.println("conectado");
             

              
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } catch (ClassNotFoundException ex) {
             Logger.getLogger(conexion.class.getName()).log(Level.SEVERE, null, ex);
         }
         return null;
    }

    
    
    
    
    
}



         

    
    

