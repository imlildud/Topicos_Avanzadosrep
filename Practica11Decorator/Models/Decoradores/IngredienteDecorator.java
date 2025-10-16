package Practica11Decorator.Models.Decoradores;
import Practica11Decorator.Models.Ingrediente;

public abstract class IngredienteDecorator implements Ingrediente {
    protected Ingrediente ingrediente;

    public IngredienteDecorator(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    @Override
    public String getDescripcion() {
        return ingrediente.getDescripcion();
    }

    @Override
    public double getCosto() {
        return ingrediente.getCosto();
    }
}