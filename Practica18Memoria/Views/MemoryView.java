package Practica18Memoria.Views;
import Practica18Memoria.Models.SimulationModel;
import Practica18Memoria.Models.StepModel;
import java.util.Arrays;

public class MemoryView {
    public void viewTitle(){
        System.out.println("=== SIMULADOR DE REEMPLAZO DE PÁGINAS (FIFO, Óptimo, LRU) ===");
    }

    public void viewInstructions(){
        System.out.println("\nIngresa la secuencia de referencias de página separadas por espacio.");
        System.out.println("Ejemplo: A B C A D E F G H A B C");
        System.out.print("Secuencia: ");
    }

    public void viewStart(int marcos, String[] referencias){
        System.out.println("\n--- Datos de entrada ---");
        System.out.println("Marcos: " + marcos);
        System.out.println("Secuencia: " + Arrays.toString(referencias));
        System.out.println("------------------------\n");
    }

    public void viewResults(SimulationModel res) {
        System.out.println("=== Algoritmo: " + res.getNombre() + " ===");
        System.out.printf("%-4s %-6s %-20s %-8s%n", "Paso", "Pág", "Marcos", "Fallo");
        System.out.println("--------------------------------------------------");
        for (StepModel s : res.getPasos()) {
            System.out.printf(
                    "%-4d %-6s %-20s %-8s%n",
                    s.getPaso(),
                    s.getPagina(),
                    marcosToString(s.getMarcos()),
                    s.getFallo() ? "Sí" : "No"
            );
        }
        System.out.println("--------------------------------------------------");
        System.out.println("Fallos de página (" + res.getNombre() + "): " + res.getFallos() + "\n");
    }

    public void viewEnding(SimulationModel fifo, SimulationModel optimo, SimulationModel lru){
        System.out.println("\n=== RESUMEN DE FALLOS DE PÁGINA ===");
        System.out.printf("FIFO  : %d fallos%n", fifo.getFallos());
        System.out.printf("Óptimo: %d fallos%n", optimo.getFallos());
        System.out.printf("LRU   : %d fallos%n", lru.getFallos());
    }

    private static String marcosToString(String[] marcos) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < marcos.length; i++) {
            if (i > 0) sb.append(" | ");
            if (marcos[i] == null) sb.append(" ");
            else sb.append(marcos[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}