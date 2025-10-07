package Practica9Singleton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    private static DatabaseConnection instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/escuela";
    private String user = "devuser";
    private String pass = "080805";

    private DatabaseConnection() throws SQLException {
        try {
            this.connection = DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            throw new SQLException("Error al conectar con la base de datos", e);
        }
    }

    public static DatabaseConnection getInstance() throws SQLException {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else if (instance.getConnection().isClosed()) {
            instance = new DatabaseConnection();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}