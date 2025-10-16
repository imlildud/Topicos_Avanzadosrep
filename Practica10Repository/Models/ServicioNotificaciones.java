package Practica10Repository.Models;

public class ServicioNotificaciones {
    private GestorUsuarios gestorUsuarios;

    public ServicioNotificaciones(GestorUsuarios gestorUsuarios) {
        this.gestorUsuarios = gestorUsuarios;
    }

    public void enviarNotificacion(String usuarioId, String mensaje) {
        RepositoryModel.Usuario usuario = gestorUsuarios.buscarUsuario(usuarioId);
        if (usuario == null) {
            System.out.println("Usuario no encontrado: " + usuarioId);
            return;
        }

        if (usuario.isNotificacionesEmail()) {
            enviarEmail(usuario.getEmail(), mensaje);
        }

        if (usuario.isNotificacionesSMS()) {
            enviarSMS(usuario.getTelefono(), mensaje);
        }

        if (usuario.isNotificacionesPush()) {
            enviarPush(usuarioId, mensaje);
        }

        System.out.println("Log: Notificación enviada a " + usuario.getNombre());

        String mensajeCifrado = cifrarMensaje(mensaje);
        System.out.println("Mensaje cifrado: " + mensajeCifrado);
    }

    private void enviarEmail(String email, String mensaje) {
        System.out.println("Enviando EMAIL a " + email + ": " + mensaje);
    }

    private void enviarSMS(String telefono, String mensaje) {
        System.out.println("Enviando SMS a " + telefono + ": " + mensaje);
    }

    private void enviarPush(String usuarioId, String mensaje) {
        System.out.println("Enviando PUSH a " + usuarioId + ": " + mensaje);
    }

    private String cifrarMensaje(String mensaje) {
        return new StringBuilder(mensaje).reverse().toString();
    }

    public void enviarNotificacionUrgente(String usuarioId, String mensaje) {
        RepositoryModel.Usuario usuario = gestorUsuarios.buscarUsuario(usuarioId);
        if (usuario == null) {
            System.out.println("Usuario no encontrado: " + usuarioId);
            return;
        }

        String mensajeUrgente = "URGENTE: " + mensaje;

        if (usuario.isNotificacionesEmail()) {
            enviarEmail(usuario.getEmail(), mensajeUrgente);
        }

        if (usuario.isNotificacionesSMS()) {
            enviarSMS(usuario.getTelefono(), mensajeUrgente);
        }

        if (usuario.isNotificacionesPush()) {
            enviarPush(usuarioId, mensajeUrgente);
        }

        System.out.println("Log: Notificación URGENTE enviada a " + usuario.getNombre());
        String mensajeCifrado = cifrarMensaje(mensajeUrgente);
        System.out.println("Mensaje cifrado: " + mensajeCifrado);
    }
}