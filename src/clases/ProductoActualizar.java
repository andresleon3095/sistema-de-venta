package clases;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

public class ProductoActualizar {

    static int idproducto;
    static String nombre;
    static String estado;
    static String precio;

    public ProductoActualizar(int id, String nombre, String estado, String precio) {
        this.idproducto = id;
        this.nombre = nombre;
        this.estado = estado;
        this.precio = precio;

        conexion conectar = new conexion();
        Connection con = conectar.getConexion();
        CallableStatement stmt = null;

        try {
            CallableStatement actualizar = con.prepareCall("CALL productos_actualizar(?,?,?,?)");
            actualizar.setInt(1, id);
            actualizar.setString(2, nombre);
            actualizar.setString(3, estado);
            actualizar.setString(4, precio);
            // se ejecuta el procedimiento

            actualizar.executeUpdate();

            System.out.println("Producto actualizado");

            con.close();

        } catch (SQLException e) {
            System.out.println("Error" + e);
        }
    }

//    public static void productosUpdate() {
//        
//    }
}
