package Practica11Decorator.Models;

public class Carnes implements Ingrediente {

    @Override
    public String getDescripcion() {
        return "Peperoni";
    }

    @Override
    public double getCosto() {
        return 24.0;
    }
}