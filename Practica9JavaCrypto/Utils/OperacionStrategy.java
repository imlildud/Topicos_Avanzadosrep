package Practica9JavaCrypto.Utils;
import Practica9JavaCrypto.Models.CajeroModel;
import Practica9JavaCrypto.Views.CajeroView;

public interface OperacionStrategy {
    boolean ejecutar(CajeroModel model, CajeroView view);
    String getNombre();
}