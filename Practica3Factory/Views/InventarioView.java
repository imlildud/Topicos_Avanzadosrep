package Practica3Factory.Views;
import java.util.Scanner;

public class InventarioView {
    private final Scanner scanner;

    public InventarioView() {
        this.scanner = new Scanner(System.in);
    }

    public void verMenu() {
        System.out.println("\n=== SISTEMA DE INVENTARIO ===");
        System.out.println("1. Agregar Producto");
        System.out.println("2. Mostrar Productos");
        System.out.println("3. Agregar Cliente");
        System.out.println("4. Mostrar Clientes");
        System.out.println("5. Salir");
        System.out.print("Seleccione una opción: ");
    }

    public int getInput() {
        return scanner.nextInt();
    }

    public String getStringInput() {
        scanner.nextLine();
        return scanner.nextLine();
    }

    public double getDoubleInput() {
        return scanner.nextDouble();
    }

    public void showMessage(String message) {
        System.out.println(message);
    }

    public void showItem(Object item) {
        System.out.println(item.toString());
    }
}
