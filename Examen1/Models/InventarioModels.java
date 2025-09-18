package Examen1.Models;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class InventarioModels {
    private final List<Producto> productos;
    private final List<Cliente> clientes;
    private final List<Venta> ventas;
    private final Scanner scanner;
    private int nextProductoId;
    private int nextClienteId;
    private int nextVentaId;

    public InventarioModel() {
        this.productos = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.ventas = new ArrayList<>();
        this.scanner = new Scanner(System.in);
        this.nextProductoId = 1;
        this.nextClienteId = 1;
        this.nextVentaId = 1;
    }

    public static class Producto {
        private final int id;
        private String codigo;
        private String nombre;
        private double precio;
        private int cantidad;
        private String categoria;
        private String fechaVencimiento;

        public Producto(int id, String codigo, String nombre, double precio, int cantidad, String categoria, String fechaVencimiento) {
            this.id = id;
            this.codigo = codigo;
            this.nombre = nombre;
            this.precio = precio;
            this.cantidad = cantidad;
            this.categoria = categoria;
            this.fechaVencimiento = fechaVencimiento;
        }

        public int getId() { return id; }
        public String getCodigo() { return codigo; }
        public void setCodigo(String codigo) { this.codigo = codigo; }
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public double getPrecio() { return precio; }
        public void setPrecio(double precio) { this.precio = precio; }
        public int getCantidad() { return cantidad; }
        public void setCantidad(int cantidad) { this.cantidad = cantidad; }
        public String getCategoria() { return categoria; }
        public void setCategoria(String categoria) { this.categoria = categoria; }
        public String getFechaVencimiento() { return fechaVencimiento; }
        public void setFechaVencimiento(String fechaVencimiento) { this.fechaVencimiento = fechaVencimiento; }
    }

    public static class Cliente {
        private final int id;
        private String nombre;
        private String email;
        private String telefono;
        private double saldo;

        public Cliente(int id, String nombre, String email, String telefono, double saldo) {
            this.id = id;
            this.nombre = nombre;
            this.email = email;
            this.telefono = telefono;
            this.saldo = saldo;
        }

        public int getId() { return id; }
        public String getNombre() { return nombre; }
        public void setNombre(String nombre) { this.nombre = nombre; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public String getTelefono() { return telefono; }
        public void setTelefono(String telefono) { this.telefono = telefono; }
        public double getSaldo() { return saldo; }
        public void setSaldo(double saldo) { this.saldo = saldo; }
    }

    public static class Venta {
        private final int id;
        private int productoId;
        private int cantidad;
        private double precio;
        private String fecha;
        private int clienteId;

        public Venta(int id, int productoId, int cantidad, double precio, String fecha, int clienteId) {
            this.id = id;
            this.productoId = productoId;
            this.cantidad = cantidad;
            this.precio = precio;
            this.fecha = fecha;
            this.clienteId = clienteId;
        }

        public int getId() { return id; }
        public int getProductoId() { return productoId; }
        public void setProductoId(int productoId) { this.productoId = productoId; }
        public int getCantidad() { return cantidad; }
        public void setCantidad(int cantidad) { this.cantidad = cantidad; }
        public double getPrecio() { return precio; }
        public void setPrecio(double precio) { this.precio = precio; }
        public String getFecha() { return fecha; }
        public void setFecha(String fecha) { this.fecha = fecha; }
        public int getClienteId() { return clienteId; }
        public void setClienteId(int clienteId) { this.clienteId = clienteId; }
    }

    public void agregarProducto() {
        System.out.println("\n--- AGREGAR NUEVO PRODUCTO ---");
        System.out.print("Código: ");
        String codigo = scanner.nextLine();

        for (Producto producto : productos) {
            if (producto.getCodigo().equals(codigo)) {
                System.out.println("Error: El código ya existe. No se puede agregar el producto.");
                return;
            }
        }

        System.out.print("Nombre: ");
        String nombre = scanner.nextLine();

        System.out.print("Precio: ");
        double precio = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Cantidad: ");
        int cantidad = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Categoría: ");
        String categoria = scanner.nextLine();

        System.out.print("Fecha de Vencimiento (DD/MM/YYYY) o N/A: ");
        String fechaVencimiento = scanner.nextLine();

        Producto nuevoProducto = new Producto(nextProductoId++, codigo, nombre, precio, cantidad, categoria, fechaVencimiento);
        productos.add(nuevoProducto);

        System.out.println("Producto agregado con éxito.");
    }

    public Scanner getScanner() {
        return scanner;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public List<Venta> getVentas() {
        return ventas;
    }
}