package Practica4;

import Practica4.Controllers.CajeroController;
import Practica4.Models.CajeroModel;
import Practica4.Views.CajeroView;

public class Main {
    public static void main(String[] args) {
        CajeroModel model = new CajeroModel();
        CajeroView view = new CajeroView();
        CajeroController controller = new CajeroController(model, view);

        controller.iniciarSistema();
    }
}
