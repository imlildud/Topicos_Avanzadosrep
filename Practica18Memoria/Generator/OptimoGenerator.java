package Practica18Memoria.Generator;
import Practica18Memoria.Models.SimulationModel;
import Practica18Memoria.Models.StepModel;
import Practica18Memoria.Utils.*;
import java.util.Arrays;

public class OptimoGenerator {
    public SimulationModel simularOptimo(String[] refs, int numMarcos) {
        SimulationModel res = new SimulationModel("Óptimo");

        String[] frames = new String[numMarcos];
        Arrays.fill(frames, null);
        int fallos = 0;

        for (int i = 0; i < refs.length; i++) {
            String pagina = refs[i];
            boolean hit = PageReplaceUtils.contiene(frames, pagina);
            boolean fallo = false;

            if (!hit) {
                int posVacia = PageReplaceUtils.indiceVacio(frames);
                if (posVacia != -1) {
                    frames[posVacia] = pagina;
                } else {
                    int indiceReemplazar = -1;
                    int maxDistancia = -1;

                    for (int f = 0; f < numMarcos; f++) {
                        String paginaMarco = frames[f];
                        int distancia = distanciaProximaReferencia(refs, i + 1, paginaMarco);
                        if (distancia > maxDistancia) {
                            maxDistancia = distancia;
                            indiceReemplazar = f;
                        }
                    }

                    frames[indiceReemplazar] = pagina;
                }
                fallo = true;
                fallos++;
            }

            res.getPasos().add(new StepModel(i + 1, pagina, PageReplaceUtils.copia(frames), fallo));
        }

        res.setFallos(fallos);
        return res;
    }

    private static int distanciaProximaReferencia(String[] refs, int inicio, String pagina) {
        for (int i = inicio; i < refs.length; i++) {
            if (refs[i].equals(pagina)) {
                return i - inicio; // distancia
            }
        }
        return Integer.MAX_VALUE;
    }
}