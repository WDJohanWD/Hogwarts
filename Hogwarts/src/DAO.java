import java.sql.*;

public class DAO {
    private String url;
    private String username;
    private String password;

    public DAO(String url, String user, String pass) {

        this.url = url;
        this.username = user;
        this.password = pass;

    }


    public void crearAlumno(Mago mago) {
        String sql = "INSERT "
        try (Connection conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/hogwarts", this.username, this.password)) {

        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }

    }
}
