package Practica9JavaCrypto.Utils;
import Practica9JavaCrypto.Views.CajeroView;
import Practica9JavaCrypto.Models.CajeroModel;

public class ConsultarSaldoStrategy implements OperacionStrategy {
    @Override
    public boolean ejecutar(CajeroModel model, CajeroView view) {
        double saldo = model.consultarSaldo();
        view.mostrarSaldo(saldo);
        return true;
    }

    @Override
    public String getNombre() {
        return "Consultar Saldo";
    }
}
