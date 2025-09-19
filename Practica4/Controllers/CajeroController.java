package Practica4.Controllers;
import Practica4.Models.*;
import Practica4.Views.CajeroView;
import java.util.HashMap;
import java.util.Map;

public class CajeroController {
    private final CajeroModel model;
    private final CajeroView view;
    private boolean sistemaActivo;
    private Map<Integer, OperacionStrategy> estrategias;

    public CajeroController(CajeroModel model, CajeroView view){
        this.model = model;
        this.view = view;
        this.sistemaActivo = true;
        this.inicializarEstrategias();
    }

    private void inicializarEstrategias() {
        estrategias = new HashMap<>();
        estrategias.put(1, new ConsultarSaldoStrategy());
        estrategias.put(2, new RetirarStrategy());
        estrategias.put(3, new DepositarStrategy());
        estrategias.put(4, new TransferirStrategy());
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

            if (opcion == 9) {
                view.mostrarMensaje("Sesión cerrada.");
                sesionActiva = false;
            } else {
                ejecutarEstrategia(opcion);
            }
        }
    }

    private void ejecutarEstrategia(int opcion) {
        OperacionStrategy estrategia = estrategias.get(opcion);
        if (estrategia != null) {
            estrategia.ejecutar(model, view);
        } else {
            view.mostrarMensaje("Opción no válida, intenta de nuevo.");
        }
    }
}