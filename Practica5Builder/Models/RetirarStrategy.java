package Practica5Builder.Models;
import Practica4Strategy.Views.CajeroView;

public class RetirarStrategy implements OperacionStrategy {
    @Override
    public boolean ejecutar(CajeroModel model, CajeroView view) {
        double montoRetiro = view.solicitarCantidad("retirar");
        if (montoRetiro > 0 && model.retirar(montoRetiro)) {
            view.mostrarMensaje("Retiro exitoso. Nuevo saldo: $" + model.consultarSaldo());
            return true;
        } else {
            view.mostrarMensaje("No se pudo realizar el retiro. Verifica el monto.");
            return false;
        }
    }

    @Override
    public String getNombre() {
        return "Retirar";
    }
}