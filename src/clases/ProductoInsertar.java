package clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;


public class ProductoInsertar {

  
    public static void InsertarProductos(String nombre, String estado, String precio) {
        conexion conectar = new conexion();
        Connection con = conectar.getConexion();
        CallableStatement stmt = null;

        try {
            CallableStatement insertar = con.prepareCall("CALL productos_insertar(?,?,?)");

            insertar.setString(1, nombre);
            insertar.setString(2, estado);
            insertar.setString(3, precio);
            // se ejecuta el procedimiento
             insertar.executeQuery();
            System.out.println("Producto Enviado");
            
            con.close();

        } catch (SQLException e) {
            System.out.println("Error" + e);
        }
    }

}
