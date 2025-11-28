package Practica18Memoria.Generator;
import Practica18Memoria.Models.SimulationModel;
import Practica18Memoria.Models.StepModel;
import Practica18Memoria.Utils.*;
import java.util.Arrays;

public class FifoGenerator {
    public SimulationModel simularFIFO(String[] refs, int numMarcos) {
        SimulationModel res = new SimulationModel("FIFO");

        String[] frames = new String[numMarcos];
        Arrays.fill(frames, null);

        int puntero = 0;
        int fallos = 0;

        for (int i = 0; i < refs.length; i++) {
            String pagina = refs[i];
            boolean hit = PageReplaceUtils.contiene(frames, pagina);
            ;
            boolean fallo = false;

            if (!hit) {
                int posVacia = PageReplaceUtils.indiceVacio(frames);
                if (posVacia != -1) {
                    frames[posVacia] = pagina;
                } else {
                    frames[puntero] = pagina;
                    puntero = (puntero + 1) % numMarcos;
                }
                fallo = true;
                fallos++;
            }
            res.getPasos().add(new StepModel(i + 1, pagina, PageReplaceUtils.copia(frames), fallo));
        }

        res.setFallos(fallos);
        return res;
    }
}