package Practica2.Controllers;
import Practica2.Models.CajeroModel;
import Practica2.Views.CajeroView;

public class CajeroController {
    private CajeroModel model;
    private CajeroView view;
    private boolean sistemaActivo;

    public CajeroController(CajeroModel model, CajeroView view){
        this.model = model;
        this.view = view;
        this.sistemaActivo = true;
    }

    public void iniciarSistema(){
        view.mostrarBienvenida();
        while (sistemaActivo){
            if(autenticarUsuario()){
                ejecutarMenuPrincipal();
            }else{
                view.mostrarMensaje("Credenciales incorrectas");
            }
        }
        view.mostrarMensaje("Gracias por usar nuestro cajero");
    }

    private boolean autenticarUsuario(){
        String numeroCuenta = view.solicitarNumeroCuenta();
        String pin = view.solicitarPin();
        return model.autenticar(numeroCuenta, pin);
    }

    private void ejecutarMenuPrincipal(){
        boolean sesionActiva = true;

        while (sesionActiva) {
            view.mostarMenuPrincipal(model.getCuentaActual().getTitular());
            int opcion = view.leerOpcion();

            switch (opcion) {
                case 1:
                    double saldo = model.consultarSaldo();
                    view.mostrarSaldo(saldo);
                    break;

                case 2:
                    double montoRetiro = view.solicitarCantidad("retirar");
                    if (montoRetiro > 0 && model.retirar(montoRetiro)) {
                        view.mostrarMensaje("Retiro exitoso. Nuevo saldo: $" + model.consultarSaldo());
                    } else {
                        view.mostrarMensaje("No se pudo realizar el retiro. Verifica el monto.");
                    }
                    break;

                case 3:
                    double montoDeposito = view.solicitarCantidad("depositar");
                    if (montoDeposito > 0 && model.depositar(montoDeposito)) {
                        view.mostrarMensaje("Depósito exitoso. Nuevo saldo: $" + model.consultarSaldo());
                    } else {
                        view.mostrarMensaje("No se pudo realizar el depósito. Verifica el monto.");
                    }
                    break;
                case 4:
                    String cuentaDestino = view.solicitarCuentaDestino();
                    double montoTransferir = view.solicitarCantidad("transferir");
                    if (model.transferir(cuentaDestino, montoTransferir)) {
                        view.mostrarMensaje("Transferencia exitosa a la cuenta " + cuentaDestino +
                                ". Nuevo saldo: $" + model.consultarSaldo());
                    } else {
                        view.mostrarMensaje("No se pudo realizar la transferencia. Verifica datos y saldo.");
                    }
                    break;

                case 9:
                    view.mostrarMensaje("Sesión cerrada.");
                    sesionActiva = false;
                    break;

                default:
                    view.mostrarMensaje("Opción no válida, intenta de nuevo.");
            }
        }
    }
}