package Practica10Repository;
import Practica10Repository.Models.GestorUsuarios;
import Practica10Repository.Models.RepositoryModel;
import Practica10Repository.Models.ServicioNotificaciones;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== SISTEMA SIN PATRONES ===");

        GestorUsuarios gestor = new GestorUsuarios();
        ServicioNotificaciones servicio = new ServicioNotificaciones(gestor);

        RepositoryModel.Usuario usuario1 = new RepositoryModel.Usuario("1", "Juan Pérez", "juan@email.com", "+123456789");
        RepositoryModel.Usuario usuario2 = new RepositoryModel.Usuario("2", "María García", "maria@email.com", "+987654321");
        RepositoryModel.Usuario usuario3 = new RepositoryModel.Usuario("3", "Carlos López", "carlos@email.com", "+192837465");

        usuario2.setNotificacionesSMS(false);
        gestor.agregarUsuario(usuario1);
        gestor.agregarUsuario(usuario2);
        gestor.agregarUsuario(usuario3);

        System.out.println("\n--- Notificación normal ---");
        servicio.enviarNotificacion("1", "Bienvenido al sistema");

        System.out.println("\n--- Notificación urgente ---");
        servicio.enviarNotificacionUrgente("2", "Su cuenta está por expirar");

        System.out.println("\n--- Notificacion urgente ---");
        servicio.enviarNotificacion("3", "Mensaje de prueba");
    }
}