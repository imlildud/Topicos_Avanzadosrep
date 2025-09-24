import java.util.Scanner;

class Pizza {
    private String masa;
    private String salsa;
    private String queso;
    private String[] toppings;
    private String tamaño;

    Pizza(PizzaBuilder builder) {
        this.masa = builder.masa;
        this.salsa = builder.salsa;
        this.queso = builder.queso;
        this.toppings = builder.toppings;
        this.tamaño = builder.tamaño;
    }

    public void mostrarPizza() {
        System.out.println("Pizza " + tamaño + ":");
        System.out.println("Masa: " + masa);
        System.out.println("Salsa: " + salsa);
        System.out.println("Queso: " + queso);
        System.out.println("Toppings: " + String.join(", ", toppings));
    }

    public static class PizzaBuilder {
        private String masa = "Regular";
        private String salsa = "Tomate";
        private String queso = "Mozzarella";
        private String[] toppings = {};
        private String tamaño = "Mediana";

        public PizzaBuilder setMasa(String masa) {
            this.masa = masa;
            return this;
        }

        public PizzaBuilder setSalsa(String salsa) {
            this.salsa = salsa;
            return this;
        }

        public PizzaBuilder setQueso(String queso) {
            this.queso = queso;
            return this;
        }

        public PizzaBuilder setToppings(String[] toppings) {
            this.toppings = toppings;
            return this;
        }

        public PizzaBuilder setTamaño(String tamaño) {
            this.tamaño = tamaño;
            return this;
        }

        public Pizza build() {
            return new Pizza(this);
        }
    }
}

class Cocina {
    public Pizza crearPizzaHawaiana() {
        return new Pizza.PizzaBuilder()
                .setMasa("Fina")
                .setSalsa("Tomate")
                .setQueso("Mozzarella")
                .setToppings(new String[]{"Jamón", "Piña"})
                .setTamaño("Grande")
                .build();
    }

    public Pizza crearPizzaPeperoni() {
        return new Pizza.PizzaBuilder()
                .setMasa("Integral")
                .setSalsa("Pesto")
                .setQueso("Cheda")
                .setToppings(new String[]{"Peperoni", "Salchicha", "Tocino"})
                .setTamaño("Mediana")
                .build();
    }
}

public class EjemploBuilder{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Cocina cC = new Cocina();
        Pizza pizzaCreada = null;
        int opcion = 0;

        do {
            System.out.println("\n_______Bienvenido a pizzeria Julio Hernesto_______");
            System.out.println("1.- Crear pizza Hawaiana");
            System.out.println("2.- Crear pizza Peperoni");
            System.out.println("3.- Mostrar pizza creada");
            System.out.println("5.- Salir");
            System.out.print("Selecciona una opción: ");

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    pizzaCreada = cC.crearPizzaHawaiana();
                    System.out.println("¡Pizza Hawaiana creada exitosamente!");
                    break;
                case 2:
                    pizzaCreada = cC.crearPizzaPeperoni();
                    System.out.println("¡Pizza Peperoni creada exitosamente!");
                    break;
                case 3:
                    if (pizzaCreada != null) {
                        System.out.println("\n--- PIZZA CREADA ---");
                        pizzaCreada.mostrarPizza();
                    } else {
                        System.out.println("No hay ninguna pizza creada. Selecciona opción 1 o 2 primero.");
                    }
                    break;
                case 4:
                    System.out.println("¡Gracias por visitar la pizzería!");
                    break;
                default:
                    System.out.println("Opción inválida. Intenta de nuevo.");
            }
        } while (opcion != 4);

        sc.close();
    }
}