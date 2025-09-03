package Practica2;

import Practica2.Controllers.CajeroController;
import Practica2.Models.CajeroModel;
import Practica2.Views.CajeroView;

public class Main {
    public static void main(String[] args) {
        CajeroModel model = new CajeroModel();
        CajeroView view = new CajeroView();
        CajeroController controller = new CajeroController(model, view);

        controller.iniciarSistema();
    }
}