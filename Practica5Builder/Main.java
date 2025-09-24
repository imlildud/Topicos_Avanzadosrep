package Practica5Builder;

import Practica4Strategy.Controllers.CajeroController;
import Practica4Strategy.Models.CajeroModel;
import Practica4Strategy.Views.CajeroView;

public class Main {
    public static void main(String[] args) {
        CajeroModel model = new CajeroModel();
        CajeroView view = new CajeroView();
        CajeroController controller = new CajeroController(model, view);

        controller.iniciarSistema();
    }
}
