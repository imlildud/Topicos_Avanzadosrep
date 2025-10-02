package Practica6MySql;
import Practica6MySql.Dao.EstudianteDAO;
import Practica6MySql.Dao.EstudianteDAOImpl;
import Practica6MySql.Models.Estudiante;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/escuela";
        String user = "user";
        String pass = "password";

        try (Connection conn = DriverManager.getConnection(url, user, pass)) {
            EstudianteDAO dao = new EstudianteDAOImpl(conn);
            for (Estudiante e : dao.listar()) {
                System.out.println(e.getId() + " - " + e.getNombre());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
