package Practica11Decorator.Models.Decoradores;
import Practica11Decorator.Models.Ingrediente;

public class Mushroom extends IngredienteDecorator {

    public Mushroom(Ingrediente ingrediente) {
        super(ingrediente);
    }

    @Override
    public String getDescripcion() {
        return ingrediente.getDescripcion() + " + Champiñones";
    }

    @Override
    public double getCosto() {
        return ingrediente.getCosto() + 5.0;
    }
}
