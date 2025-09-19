package Practica4.Models;
import Practica4.Views.CajeroView;

public interface OperacionStrategy {
    boolean ejecutar(CajeroModel model, CajeroView view);
    String getNombre();
}