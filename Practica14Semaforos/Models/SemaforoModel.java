package Practica14Semaforos.Models;

import Practica14Semaforos.Views.SemaforoView;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class SemaforoModel {
    private final int cupo = 16;
    private ArrayList<ProcesoModel> enUso;
    private ArrayList<ProcesoModel> Liberado;
    private Queue<ProcesoModel> cola;
    private SemaforoView view;

    public SemaforoModel(SemaforoView view) {
        this.view = view;
        enUso = new ArrayList<>();
        Liberado = new ArrayList<>();
        cola = new LinkedList<>();
    }

    public void ocupar(int id) {
        ProcesoModel proceso = new ProcesoModel(id);

        if (enUso.size() < cupo) {
            enUso.add(proceso);
            view.mostrarMensaje("Proceso " + id + " ha entrado.");
        } else {
            cola.add(proceso);
            view.mostrarMensaje("Proceso " + id + " en cola.");
        }
    }

    public void liberar(int id) {
        ProcesoModel procesoLiberado = null;

        for (ProcesoModel p : enUso) {
            if (p.getId() == id) {
                procesoLiberado = p;
                break;
            }
        }

        if (procesoLiberado != null) {
            procesoLiberado.setHoraSalida();
            enUso.remove(procesoLiberado);
            Liberado.add(procesoLiberado);
            view.mostrarMensaje("Proceso " + id + " ha salido del semaforo. a las " + procesoLiberado.getHoraSalida());

            if (!cola.isEmpty()) {
                ProcesoModel siguiente = cola.poll();
                siguiente.setHoraAtencion();
                siguiente.calcularTiempoCola();
                enUso.add(siguiente);

                view.mostrarMensaje("Proceso " + siguiente.getId() +
                        " entró desde la cola. Esperó " +
                        siguiente.getTiempoCola().toSeconds() + " segundos.");
            }
        } else {
            view.mostrarMensaje("El ID " + id + " no está en uso.");
        }
    }

    public ArrayList<ProcesoModel> getProcesosEnUso() {
        return enUso;
    }

    public Queue<ProcesoModel> getCola() {
        return cola;
    }

    public void mostrarTablaEstado() {
        for (ProcesoModel p : enUso) {
            view.mostrarMensaje("Proceso en uso - ID: " + p.getId() +
                               ", Hora Llegada: " + p.getHoraLlegada() +
                               ", Hora Atencion: " + p.getHoraAtencion() +
                               ", Hora Salida: " + p.getHoraSalida() +
                               ", Tiempo en Cola: " + p.getTiempoCola());
        }
        for (ProcesoModel p : cola) {
            view.mostrarMensaje("Proceso en cola - ID: " + p.getId() +
                               ", Hora Llegada: " + p.getHoraLlegada() +
                               ", Hora Atencion: " + p.getHoraAtencion() +
                               ", Hora Salida: " + p.getHoraSalida() +
                               ", Tiempo en Cola: " + p.getTiempoCola());
        }
        for (ProcesoModel p: Liberado){
            view.mostrarMensaje("Proceso liberado - ID: " + p.getId() +
                    ", Hora Llegada: " + p.getHoraLlegada() +
                    ", Hora Atencion: " + p.getHoraAtencion() +
                    ", Hora Salida: " + p.getHoraSalida() +
                    ", Tiempo en Cola: " + p.getTiempoCola());
        }
    }
}