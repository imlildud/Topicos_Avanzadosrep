package Practica9JavaCrypto.Utils;
import Practica9JavaCrypto.Views.CajeroView;
import Practica9JavaCrypto.Models.CajeroModel;

public class DepositarStrategy implements OperacionStrategy {
    @Override
    public boolean ejecutar(CajeroModel model, CajeroView view) {
        double montoDeposito = view.solicitarCantidad("depositar");
        if (montoDeposito > 0 && model.depositar(montoDeposito)) {
            view.mostrarMensaje("Depósito exitoso. Nuevo saldo: $" + model.consultarSaldo());
            return true;
        } else {
            view.mostrarMensaje("No se pudo realizar el depósito. Verifica el monto.");
            return false;
        }
    }

    @Override
    public String getNombre() {
        return "Depositar";
    }
}