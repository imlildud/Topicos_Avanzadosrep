package Pratica3.Controller;

import Pratica3.Models.InventarioModel;
import Pratica3.Views.InventarioView;
import Pratica3.Factory.ItemFactory;

public class InventarioController {
    private final InventarioModel<Object> productModel;
    private final InventarioModel<Object> clientModel;
    private final InventarioView view;
    private final ItemFactory factory;

    public InventarioController() {
        this.productModel = new InventarioModel<>();
        this.clientModel = new InventarioModel<>();
        this.view = new InventarioView();
        this.factory = new ItemFactory();
    }

    public void iniciar() {
        boolean funcionando = true;

        while (funcionando) {
            view.verMenu();
            int menu = view.getInput();

            switch (menu) {
                case 1:
                    añadirProducto();
                    break;
                case 2:
                    mostrarProductos();
                    break;
                case 3:
                    añadirCliente();
                    break;
                case 4:
                    mostrarClientes();
                    break;
                case 5:
                    funcionando = false;
                    view.showMessage("Sistema cerrado.");
                    break;
                default:
                    view.showMessage("Opción no válida.");
            }
        }
    }

    private void añadirProducto() {
        view.showMessage("Ingrese nombre del producto:");
        String name = view.getStringInput();

        view.showMessage("Ingrese precio del producto:");
        double price = view.getDoubleInput();

        Object producto = factory.createProduct(name, price);
        productModel.añadirItem(producto);

        view.showMessage("Producto agregado exitosamente.");
    }

    private void mostrarProductos() {
        view.showMessage("\n=== LISTA DE PRODUCTOS ===");
        for (Object producto : productModel.obtenerItems()) {
            view.showItem(producto);
        }
    }

    private void añadirCliente() {
        view.showMessage("Ingrese nombre del cliente:");
        String name = view.getStringInput();

        view.showMessage("Ingrese email del cliente:");
        String email = view.getStringInput();

        Object cliente = factory.createClient(name, email);
        clientModel.añadirItem(cliente);

        view.showMessage("Cliente agregado exitosamente.");
    }

    private void mostrarClientes() {
        view.showMessage("\n=== LISTA DE CLIENTES ===");
        for (Object cliente : clientModel.obtenerItems()) {
            view.showItem(cliente);
        }
    }
}