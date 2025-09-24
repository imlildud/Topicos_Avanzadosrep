package Practica5Builder.Models;
import Practica4Strategy.Views.CajeroView;

public interface OperacionStrategy {
    boolean ejecutar(CajeroModel model, CajeroView view);
    String getNombre();
}