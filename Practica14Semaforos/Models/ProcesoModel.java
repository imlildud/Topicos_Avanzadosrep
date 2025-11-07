package Practica14Semaforos.Models;
import java.time.Duration;
import java.time.LocalDateTime;

public class ProcesoModel {
    private int id;
    private LocalDateTime horaLlegada;
    private LocalDateTime horaSalida;
    private LocalDateTime horaAtencion;
    private Duration tiempoCola;

    public ProcesoModel(int id) {
        this.id = id;
        this.horaLlegada = LocalDateTime.now();
        this.horaSalida = null;
        this.horaAtencion = null;
        this.tiempoCola = Duration.ZERO;
    }

    // Getters
    public int getId() {
        return id;
    }

    public LocalDateTime getHoraLlegada() {
        return horaLlegada;
    }

    public LocalDateTime getHoraSalida() {
        return horaSalida;
    }

    public LocalDateTime getHoraAtencion() {
        return horaAtencion;
    }

    public Duration getTiempoCola() {
        return tiempoCola;
    }

    // Setters
    public void setHoraSalida() {
        this.horaSalida = LocalDateTime.now();
    }

    public void setHoraAtencion() {
        this.horaAtencion = LocalDateTime.now();
    }

    public void calcularTiempoCola() {
        if (horaAtencion != null) {
            this.tiempoCola = Duration.between(horaLlegada, horaAtencion);
        }
    }
}
