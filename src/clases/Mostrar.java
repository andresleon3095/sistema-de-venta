package clases;

import static clases.ProductoDAO.llamarProductos;
import java.util.Scanner;

public class Mostrar {

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {

        String nombre, estado, precio;
        int idProducto;
        int opcion, idBorrar;
        Scanner entrada = new Scanner(System.in);

        System.out.println("Ingresar opcion 1 mostrar 2 para ingresar 3 actualiar y 4 eliminar");
        opcion = Integer.parseInt(entrada.nextLine());

        switch (opcion) {
            case 1:
                llamarProductos();
                break;
            case 2:
                ProductoInsertar producto = new ProductoInsertar();

                System.out.println("Ingresar producto");
                nombre = entrada.nextLine();

                System.out.println("Ingresar estado");
                estado = entrada.nextLine();

                System.out.println("Ingresar Precio");
                precio = entrada.nextLine();

                ProductoInsertar.InsertarProductos(nombre, estado, precio);
                break;
            case 3:
                
                System.out.println("Ingresar id producto");
                idProducto = Integer.parseInt(entrada.nextLine());
                
                System.out.println("Ingresar producto");
                nombre = entrada.nextLine();

                System.out.println("Ingresar estado");
                estado = entrada.nextLine();

                System.out.println("Ingresar Precio");
                precio = entrada.nextLine();

                ProductoActualizar actualizar = new ProductoActualizar(idProducto, nombre, estado, precio);
                
                break;
            case 4:
                ProductoEliminar borrarProducto = new ProductoEliminar();

                System.out.println("Ingresar el id producto");
                idBorrar = entrada.nextInt();
                ProductoEliminar.productoDelete(idBorrar);
                break;
            default:
                System.out.println("Ninguna de las anteriores");
        }

    }

}
