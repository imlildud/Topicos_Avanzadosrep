package Practica11Decorator.Models.Decoradores;
import Practica11Decorator.Models.Ingrediente;

public class Chorizo extends IngredienteDecorator {

    public Chorizo(Ingrediente ingrediente) {
        super(ingrediente);
    }

    @Override
    public String getDescripcion() {
        return ingrediente.getDescripcion() + " + Crema";
    }

    @Override
    public double getCosto() {
        return ingrediente.getCosto() + 12.0;
    }
}