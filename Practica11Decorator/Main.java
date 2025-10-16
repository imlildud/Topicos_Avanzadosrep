package Practica11Decorator;
import Practica11Decorator.Models.*;
import Practica11Decorator.Models.Decoradores.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA DE CAFETERÍA - PATRÓN DECORATOR ===\n");

        Ingrediente ingrediente1 = new Carnes();
        System.out.println("1. " + ingrediente1.getDescripcion());
        System.out.println("   Costo: $" + ingrediente1.getCosto());
        System.out.println();

        Ingrediente ingrediente2 = new Salchicha(new Chorizo(new Adicional()));
        System.out.println("2. " + ingrediente2.getDescripcion());
        System.out.println("   Costo: $" + ingrediente2.getCosto());
        System.out.println();

        Ingrediente ingrediente3 = new Pinaple(new Mushroom(new Carnes()));
        System.out.println("3. " + ingrediente3.getDescripcion());
        System.out.println("   Costo: $" + ingrediente3.getCosto());
        System.out.println();

        Ingrediente ingrediente4 = new Mushroom(new Salchicha(new Pinaple(new Adicional())));
        System.out.println("4. " + ingrediente4.getDescripcion());
        System.out.println("   Costo: $" + ingrediente4.getCosto());
        System.out.println();

        Ingrediente ingrediente5 = new Chorizo(new Carnes());
        System.out.println("5. " + ingrediente5.getDescripcion());
        System.out.println("   Costo: $" + ingrediente5.getCosto());
        System.out.println();

        Ingrediente ingrediente6 = new Pinaple(new Adicional());
        System.out.println("6. " + ingrediente6.getDescripcion());
        System.out.println("   Costo: $" + ingrediente6.getCosto());
        System.out.println();

        Ingrediente ingrediente7 = new Mushroom(new Adicional());
        System.out.println("7. " + ingrediente7.getDescripcion());
        System.out.println("   Costo: $" + ingrediente7.getCosto());
        System.out.println();

        Ingrediente ingrediente8 = new Chorizo(new Salchicha(new Adicional()));
        System.out.println("8. " + ingrediente8.getDescripcion());
        System.out.println("   Costo: $" + ingrediente8.getCosto());
        System.out.println();

        Ingrediente ingrediente9 = new Salchicha(new Chorizo(new Pinaple(new Mushroom(new Adicional()))));
        System.out.println("9. " + ingrediente9.getDescripcion());
        System.out.println("   Costo: $" + ingrediente9.getCosto());
        System.out.println();

        System.out.println("=== ¡Gracias por usar nuestro sistema! ===");
    }
}