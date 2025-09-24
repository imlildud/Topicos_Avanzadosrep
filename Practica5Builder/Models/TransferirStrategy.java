package Practica5Builder.Models;
import Practica4Strategy.Views.CajeroView;

public class TransferirStrategy implements OperacionStrategy {
    @Override
    public boolean ejecutar(CajeroModel model, CajeroView view) {
        String cuentaDestino = view.solicitarCuentaDestino();

        if (!model.validarCuentaDestino(cuentaDestino)) {
            view.mostrarMensaje("Cuenta destino no válida o es la misma cuenta.");
            return false;
        }

        double montoTransferir = view.solicitarCantidad("transferir");
        if (model.transferir(cuentaDestino, montoTransferir)) {
            view.mostrarMensaje("Transferencia exitosa a la cuenta " + cuentaDestino +
                    ". Nuevo saldo: $" + model.consultarSaldo());
            return true;
        } else {
            view.mostrarMensaje("No se pudo realizar la transferencia. Verifica el monto.");
            return false;
        }
    }

    @Override
    public String getNombre() {
        return "Transferir";
    }
}