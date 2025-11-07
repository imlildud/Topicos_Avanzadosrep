package Practica14Semaforos.Views;

public class SemaforoView {

    public void mostrarMenu() {
        System.out.println("\n--- MENU SEMAFORO ---");
        System.out.println("1. Ocupar proceso");
        System.out.println("2. Liberar proceso");
        System.out.println("3. Mostrar estado del semaforo");
        System.out.println("4. Salir");
        System.out.print("Selecciona una opcion: ");
    }

    public void mostrarMensaje(String mensaje) {
        System.out.println(mensaje);
    }
}