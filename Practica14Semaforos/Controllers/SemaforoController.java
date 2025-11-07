package Practica14Semaforos.Controllers;
import Practica14Semaforos.Models.SemaforoModel;
import Practica14Semaforos.Views.SemaforoView;
import java.util.Scanner;

public class SemaforoController {
    Scanner sc = new java.util.Scanner(System.in);
    SemaforoView view = new SemaforoView();
    SemaforoModel model = new SemaforoModel(view);

    public void iniciar() {
        int opcion = 0;
        int id = 0;
        boolean salir = false;

        while (!salir) {
            view.mostrarMenu();
            opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    view.mostrarMensaje("Asignar ID al proceso a ocupar:");
                    id = sc.nextInt();
                    model.ocupar(id);
                    break;
                case 2:
                    view.mostrarMensaje("Asignar ID al proceso a liberar:");
                    id = sc.nextInt();
                    model.liberar(id);
                    break;
                case 3:
                    model.mostrarTablaEstado();
                    break;
                case 4:
                    salir = true;
                    break;
                default:
                    view.mostrarMensaje("Opcion no valida.");
                    break;
            }
        }
    }
}