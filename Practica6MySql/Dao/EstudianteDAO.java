package Practica6MySql.Dao;
import Practica6MySql.Models.Estudiante;
import java.util.List;

public interface EstudianteDAO {
    void insertar(Estudiante e);
    Estudiante obtenerPorId(int id);
    List<Estudiante> listar();
    void actualizar(Estudiante e);
    void eliminar(int id);
}