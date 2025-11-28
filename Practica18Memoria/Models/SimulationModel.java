package Practica18Memoria.Models;
import java.util.ArrayList;
import java.util.List;

public class SimulationModel {
    private String nombre;
    private List<StepModel> pasos = new ArrayList<>();
    private int fallos;

    public SimulationModel(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public int getFallos(){
        return fallos;
    }
    public void setFallos(int fallos){
        this.fallos = fallos;
    }

    public List<StepModel> getPasos() {
        return pasos;
    }

    public void setPasos(List<StepModel> pasos) {
        this.pasos = pasos;
    }
}