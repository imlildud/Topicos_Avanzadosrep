package Practica10Repository.Models;
import java.util.ArrayList;
import java.util.List;

public class GestorUsuarios {
    private List<RepositoryModel.Usuario> usuarios = new ArrayList<>();

    public void agregarUsuario(RepositoryModel.Usuario usuario) {
        usuarios.add(usuario);
    }

    public RepositoryModel.Usuario buscarUsuario(String id) {
        for (RepositoryModel.Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }

    public List<RepositoryModel.Usuario> obtenerTodosUsuarios() { // Cambio aquí
        return new ArrayList<>(usuarios);
    }

    public boolean eliminarUsuario(String id) {
        return usuarios.removeIf(usuario -> usuario.getId().equals(id));
    }
}