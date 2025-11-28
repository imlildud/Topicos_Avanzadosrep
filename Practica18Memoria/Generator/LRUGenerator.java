package Practica18Memoria.Generator;
import Practica18Memoria.Models.SimulationModel;
import Practica18Memoria.Models.StepModel;
import Practica18Memoria.Utils.*;
import java.util.Arrays;


public class LRUGenerator {
    public SimulationModel simularLRU(String[] refs, int numMarcos) {
        SimulationModel res = new SimulationModel("LRU");

        String[] frames = new String[numMarcos];
        int[] lastUsed = new int[numMarcos];
        Arrays.fill(frames, null);
        Arrays.fill(lastUsed, -1);
        int fallos = 0;

        for (int i = 0; i < refs.length; i++) {
            String pagina = refs[i];
            boolean hit = false;
            int posHit = -1;

            for (int f = 0; f < numMarcos; f++) {
                if (frames[f] != null && frames[f].equals(pagina)) {
                    hit = true;
                    posHit = f;
                    break;
                }
            }

            boolean fallo = false;

            if (hit) {
                lastUsed[posHit] = i;
            } else {
                int posVacia = PageReplaceUtils.indiceVacio(frames);
                if (posVacia != -1) {
                    frames[posVacia] = pagina;
                    lastUsed[posVacia] = i;
                } else {
                    int idxLRU = 0;
                    int minLast = lastUsed[0];
                    for (int f = 1; f < numMarcos; f++) {
                        if (lastUsed[f] < minLast) {
                            minLast = lastUsed[f];
                            idxLRU = f;
                        }
                    }
                    frames[idxLRU] = pagina;
                    lastUsed[idxLRU] = i;
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