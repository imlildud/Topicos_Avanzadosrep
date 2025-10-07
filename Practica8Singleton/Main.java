package Practica9Singleton;

import Practica9Singleton.Dao.EstudianteDAO;
import Practica9Singleton.Dao.EstudianteDAOImpl;
import Practica9Singleton.Models.Estudiante;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        try {
            DatabaseConnection dbConnection = DatabaseConnection.getInstance();
            EstudianteDAO dao = new EstudianteDAOImpl(dbConnection.getConnection());

            for (Estudiante e : dao.listar()) {
                System.out.println(e.getId() + " - " + e.getNombre());
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}