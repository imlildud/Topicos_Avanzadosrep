package Practica11Decorator.Models.Decoradores;
import Practica11Decorator.Models.Ingrediente;

public class Salchicha extends IngredienteDecorator {

    public Salchicha(Ingrediente ingrediente) {
        super(ingrediente);
    }

    @Override
    public String getDescripcion() {
        return ingrediente.getDescripcion() + " + Salchicha";
    }

    @Override
    public double getCosto() {
        return ingrediente.getCosto() + 5.0;
    }
}

