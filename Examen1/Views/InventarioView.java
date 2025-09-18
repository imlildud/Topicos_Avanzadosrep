package Views;
import Models.InventarioModels;
import java.util.Scanner;

public class InventarioView {
    static Scanner scanner = new Scanner(System.in);

    public InventarioView(InventarioModels models){
    }

    public static void menuInicial(){
        boolean salir = false;
        while (!salir) {
            System.out.println("\n===== SISTEMA DE INVENTARIO =====");
            System.out.println("1. Gestionar Productos");
            System.out.println("2. Gestionar Clientes");
            System.out.println("5. Guardar y Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    menuProductos();
                    break;
                case 2:
                    menuClientes();
                    break;
                case 5:
                    salir = true;
                    System.out.println("¡Gracias por usar el sistema!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
    static void menuProductos() {
        boolean volver = false;

        while (!volver) {
            System.out.println("\n----- GESTIÓN DE PRODUCTOS -----");
            System.out.println("1. Agregar Producto");
            System.out.println("2. Modificar Producto");
            System.out.println("3. Eliminar Producto");
            System.out.println("4. Listar Productos");
            System.out.println("5. Buscar Producto");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    InventarioModels.agregarProducto();
                    break;
                case 2:
                    InventarioModels.modificarProducto();
                    break;
                case 3:
                    InventarioModels.eliminarProducto();
                    break;
                case 4:
                    InventarioModels.listarProductos();
                    break;
                case 5:
                    InventarioModels.buscarProducto();
                    break;
                case 6:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
    static void menuClientes() {
        boolean volver = false;

        while (!volver) {
            System.out.println("\n----- GESTIÓN DE CLIENTES -----");
            System.out.println("1. Agregar Cliente");
            System.out.println("2. Modificar Cliente");
            System.out.println("3. Eliminar Cliente");
            System.out.println("4. Listar Clientes");
            System.out.println("5. Buscar Cliente");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    InventarioModels.agregarCliente();
                    break;
                case 2:
                    InventarioModels.modificarCliente();
                    break;
                case 3:
                    InventarioModels.eliminarCliente();
                    break;
                case 4:
                    InventarioModels.listarClientes();
                    break;
                case 5:
                    InventarioModels.buscarCliente();
                    break;
                case 6:
                    volver = true;
                    break;
                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}