
package Practica18Memoria.Controller;

import Practica18Memoria.Generator.*;
import Practica18Memoria.Models.*;
import Practica18Memoria.Views.*;
import java.util.Scanner;

public class SimulatorController {
    private final ReaderModel reader;
    private final MemoryView view;
    private final FifoGenerator fifoGen;
    private final LRUGenerator lruGen;
    private final OptimoGenerator optimoGen;

    public SimulatorController() {
        this.reader = new ReaderModel();
        this.view = new MemoryView();
        this.fifoGen = new FifoGenerator();
        this.lruGen = new LRUGenerator();
        this.optimoGen = new OptimoGenerator();
    }

    public void ejecutarSimulacion() {
        Scanner sc = new Scanner(System.in);
        view.viewTitle();
        int marcos = reader.readInt(sc, "Ingresa marcos: ", 1, 20);
        view.viewInstructions();
        String[] referencias = reader.readSecuence(sc);

        SimulationModel fifo = fifoGen.simularFIFO(referencias, marcos);
        SimulationModel optimo = optimoGen.simularOptimo(referencias, marcos);
        SimulationModel lru = lruGen.simularLRU(referencias, marcos);

        view.viewStart(marcos, referencias);
        view.viewResults(fifo);
        view.viewResults(optimo);
        view.viewResults(lru);
        view.viewEnding(fifo, optimo, lru);

        sc.close();
    }
}