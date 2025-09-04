package Practica2.Models;
import java.util.*;

public class GenericoBilletes {
    private static final int[] Denominaciones = {1000,500,200,100,50,20,10,5,2,1};
    public static Map<Integer, Integer> generarCombinacion(double monto){
        Map<Integer, Integer> combinacion = new LinkedHashMap<>();
        int restante =  (int)monto;

        for (int d: Denominaciones){
            int cantidad = restante/d;
            if (cantidad >0){
                combinacion.put(d, cantidad);
                restante -= cantidad * d;
            }
        }

        if (restante == 0){
            return combinacion;
        }else{
            return null;
        }
    }

    public static void imprimirCombinacion(Map<Integer, Integer> combinacion){
        if (combinacion == null){
            System.out.println("Imposible combinar los billetes");
            return;
        }
        for (Map.Entry<Integer, Integer> e: combinacion.entrySet()){
            System.out.println(e.getValue() + " de " + e.getKey());
        }
    }
}
