package Practica11Decorator.Models.Decoradores;
import Practica11Decorator.Models.Ingrediente;

public class Pinaple extends IngredienteDecorator {

    public Pinaple(Ingrediente ingrediente) {
        super(ingrediente);
    }

    @Override
    public String getDescripcion() {
        return ingrediente.getDescripcion() + " + Piña";
    }

    @Override
    public double getCosto() {
        return ingrediente.getCosto() + 18.0;
    }
}