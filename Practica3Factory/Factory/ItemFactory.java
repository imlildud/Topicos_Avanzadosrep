package Practica3Factory.Factory;

public class ItemFactory {

    public Object createProduct(String name, double price) {
        return new Product(name, price);
    }

    public Object createClient(String name, String email) {
        return new Client(name, email);
    }

    private class Product {
        private String name;
        private double price;

        public Product(String name, double price) {
            this.name = name;
            this.price = price;
        }

        @Override
        public String toString() {
            return "Producto: " + name + " - Precio: $" + price;
        }
    }

    private class Client {
        private String name;
        private String email;

        public Client(String name, String email) {
            this.name = name;
            this.email = email;
        }

        @Override
        public String toString() {
            return "Cliente: " + name + " - Email: " + email;
        }
    }
}