package Practica4.Models;
import java.util.*;

public class GenericoBilletes {
    private static final int[] DENOMINACIONES = {1000, 500, 200, 100, 50, 20, 10, 5, 2, 1};

    public static Map<Integer, Integer> generarCombinacion(double monto) {
        Map<Integer, Integer> combinacion = new LinkedHashMap<>();
        int restante = (int) monto;

        for (int denominacion : DENOMINACIONES) {
            int cantidad = restante / denominacion;
            if (cantidad > 0) {
                combinacion.put(denominacion, cantidad);
                restante -= cantidad * denominacion;
            }
        }

        return restante == 0 ? combinacion : null;
    }

    public static void imprimirCombinacion(Map<Integer, Integer> combinacion) {
        if (combinacion == null) {
            System.out.println("Imposible combinar los billetes");
            return;
        }

        System.out.println("Desglose de billetes:");
        for (Map.Entry<Integer, Integer> entry : combinacion.entrySet()) {
            System.out.println(entry.getValue() + " billete(s) de $" + entry.getKey());
        }
    }
}