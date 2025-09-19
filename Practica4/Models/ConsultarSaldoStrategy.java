package Practica4.Models;
import Practica4.Views.CajeroView;

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
