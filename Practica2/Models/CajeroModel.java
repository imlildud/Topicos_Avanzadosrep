package Practica2.Models;
import java.util.HashMap;
import java.util.Map;

public class CajeroModel {
    private Map<String, Cuenta> cuentas;
    private Cuenta cuentaActual;

    public CajeroModel() {
        cuentas = new HashMap<>();
        inicializarCuentas();
    }

    private void inicializarCuentas() {
        cuentas.put("12345", new Cuenta("12345", "1111", 5000, "Juan Perez"));
        cuentas.put("23456", new Cuenta("23456", "2222", 8000, "Panchito Perez"));
        cuentas.put("34567", new Cuenta("34567", "3333", 10000, "Maria Perez"));
        cuentas.put("45678", new Cuenta("45678", "4444", 10, "Josefa Perez"));
    }

    public boolean autenticar(String numeroCuenta, String pin){
        Cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta != null && cuenta.validarPin(pin)){
            cuentaActual = cuenta;
            return true;
        }
        return false;
    }

    public Cuenta getCuentaActual() {
        return cuentaActual;
    }

    public double consultarSaldo() {
        return this.cuentaActual != null ? cuentaActual.getSaldo(): 0.0;
    }

    public boolean retirar (double monto) {
        return cuentaActual != null && cuentaActual.retirar(monto);
    }

    public boolean depositar (double monto) {
        if (cuentaActual != null && cuentaActual.retirar(monto)){
            cuentaActual.depositar(monto);
            return true;
        }
        return false;
    }

    public boolean transferir(String cuentaDestino, double monto) {
        if (cuentaActual != null && monto > 0 && cuentaActual.getSaldo() >= monto) {
            Cuenta destino = cuentas.get(cuentaDestino);

            if (destino != null && !destino.getNumeroCuenta().equals(cuentaActual.getNumeroCuenta())) {
                cuentaActual.retirar(monto);
                destino.depositar(monto);
                return true;
            }
        }
        return false;
    }

    public boolean cuentaExistente (String numeroCuenta){
        return cuentas.containsKey(numeroCuenta);
    }
}