package clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;


public class ProductoEliminar {

    public static int productoDelete(int id) {
        conexion conectar = new conexion();
        Connection con = conectar.getConexion();
        CallableStatement stmt = null;

        try {
            CallableStatement eliminar = con.prepareCall("CALL productos_eliminar(?)");

            eliminar.setInt(1, id);

            // se ejecuta el procedimiento
            // insertar.executeQuery();
            eliminar.executeQuery();
            System.out.println("producto eliminado");
            con.close();

        } catch (SQLException e) {
            System.out.println("Error" + e);
        }
        return 0;
      

    }

}
