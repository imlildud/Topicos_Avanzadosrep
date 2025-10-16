package Practica11Decorator.Models;

public class Adicional implements Ingrediente {

    @Override
    public String getDescripcion() {
        return "Corteza con queso";
    }

    @Override
    public double getCosto() {
        return 80.0;
    }
}
