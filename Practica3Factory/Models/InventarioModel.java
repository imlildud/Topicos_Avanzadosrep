package Practica3Factory.Models;
import java.util.ArrayList;
import java.util.List;

public class InventarioModel<T> {
    private final List<T> items;

    public InventarioModel() {
        this.items = new ArrayList<>();
    }

    public void añadirItem(T item) {
        items.add(item);
    }

    public void quitarItem(T item) {
        items.remove(item);
    }

    public List<T> obtenerItems() {
        return new ArrayList<>(items);
    }

    public T buscarItem(int index) {
        if (index >= 0 && index < items.size()) {
            return items.get(index);
        }
        return null;
    }

    public int obtenerCantidadItems() {
        return items.size();
    }
}