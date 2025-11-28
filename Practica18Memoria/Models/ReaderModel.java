package Practica18Memoria.Models;
import java.util.Scanner;

public class ReaderModel {
    public int readInt(Scanner sc, String mensaje, int min, int max) {
        while (true) {
            System.out.print(mensaje);
            String linea = sc.nextLine().trim();
            try {
                int v = Integer.parseInt(linea);
                if (v < min || v > max) throw new NumberFormatException();
                return v;
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Ingresa un entero entre " + min + " y " + max + ".");
            }
        }
    }

    public String[] readSecuence(Scanner sc) {
        while (true) {
            String linea = sc.nextLine().trim();
            if (linea.isEmpty()) {
                System.out.println("La secuencia no puede estar vacía. Intenta de nuevo:");
                continue;
            }
            String[] partes = linea.split("\\s+");
            if (partes.length == 0) {
                System.out.println("Secuencia inválida. Intenta de nuevo:");
                continue;
            }
            return partes;
        }
    }
}
