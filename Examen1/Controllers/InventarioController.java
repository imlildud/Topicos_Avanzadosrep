package Examen1.Controllers;

import Models.InventarioModels;
import Views.InventarioView;

public class InventarioController {
    private final InventarioModels model;
    private final InventarioView view;

    public InventarioController(InventarioModels model, InventarioView view) {
        this.model = model;
        this.view = view;
    }

    public void cargarSistema() {
        view.menuPrincipal(this);
    }

    public void agregarProducto() {
        model.agregarProducto();
    }

    public void modificarProducto() {
        model.modificarProducto();
    }

    public void eliminarProducto() {
        model.eliminarProducto();
    }

    public void listarProductos() {
        model.listarProductos();
    }

    public void buscarProducto() {
        model.buscarProducto();
    }

    public void agregarCliente() {
        model.agregarCliente();
    }

    public void modificarCliente() {
        model.modificarCliente();
    }

    public void eliminarCliente() {
        model.eliminarCliente();
    }

    public void listarClientes() {
        model.listarClientes();
    }

    public void buscarCliente() {
        model.buscarCliente();
    }
}