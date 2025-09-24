package Practica5Builder.Models;
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
        cuentas.put("12345", Cuenta.builder()
                .setNumeroCuenta("12345")
                .setPin("1111")
                .setSaldo(5000)
                .setTitular("Juan Perez")
                .build());

        cuentas.put("23456", Cuenta.builder()
                .setNumeroCuenta("23456")
                .setPin("2222")
                .setSaldo(8000)
                .setTitular("Panchito Perez")
                .build());

        cuentas.put("34567", Cuenta.builder()
                .setNumeroCuenta("34567")
                .setPin("3333")
                .setSaldo(10000)
                .setTitular("Maria Perez")
                .build());

        cuentas.put("45678", Cuenta.builder()
                .setNumeroCuenta("45678")
                .setPin("4444")
                .setSaldo(10)
                .setTitular("Josefa Perez")
                .build());
    }

    public boolean autenticar(String numeroCuenta, String pin) {
        Cuenta cuenta = cuentas.get(numeroCuenta);
        if (cuenta != null && cuenta.validarPin(pin)) {
            cuentaActual = cuenta;
            return true;
        }
        return false;
    }

    public Cuenta getCuentaActual() {
        return cuentaActual;
    }

    public double consultarSaldo() {
        return this.cuentaActual != null ? cuentaActual.getSaldo() : 0.0;
    }

    public boolean retirar(double monto) {
        if (cuentaActual != null && cuentaActual.getSaldo() >= monto) {
            Map<Integer, Integer> combinacion = GenericoBilletes.generarCombinacion(monto);
            if (combinacion != null) {
                cuentaActual.retirar(monto);
                GenericoBilletes.imprimirCombinacion(combinacion);
                return true;
            }
        }
        return false;
    }

    public boolean depositar(double monto) {
        if (cuentaActual != null && monto > 0) {
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

    public boolean cuentaExistente(String numeroCuenta) {
        return cuentas.containsKey(numeroCuenta);
    }

    public boolean validarCuentaDestino(String numeroCuenta) {
        return cuentas.containsKey(numeroCuenta) &&
                !numeroCuenta.equals(cuentaActual.getNumeroCuenta());
    }
}