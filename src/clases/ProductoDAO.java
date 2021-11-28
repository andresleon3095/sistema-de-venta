package clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ProductoDAO {
    //crear constructor que reciba la conexión

    //crerar metodo para llamar el procedimiento almacenado
    
   
     
    public static void llamarProductos() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
       //conexion con = new conexion();
        conexion conectar = new conexion();
       Connection con = conectar.getConexion();
        CallableStatement stmt = null;
        
        try {
            CallableStatement mostrar = con.prepareCall("CALL productos_mostrar()");

            ResultSet rs = mostrar.executeQuery();

            while (rs.next()) {
                System.out.println(String.format("%s - %s",
                        rs.getInt("productoID")+ " "
                        + rs.getString("nombre") + " "
                        + rs.getString("estado"),
                        rs.getString("precio")));
            }
        } catch (SQLException e) {
            System.out.println("Error"+e);
        }
    }

}
