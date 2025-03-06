import java.sql.*;
import java.util.ArrayList;

public class DAO {
    final private String url;
    final private String username;
    final private String password;

    public DAO(String url, String user, String pass) {

        this.url = url;
        this.username = user;
        this.password = pass;

    }

    public void crearAlumno(Mago mago) {
        /*Consulta de la bases de datos*/
        String consultaEnPersona = "select * from persona where nombre= ? ";
        String consultaEnMago = "select * from mago where persona_id = ? ";
        String introducirMagoAlumno = "insert into alumno (mago_id) values (?)";
        /*Bucle para conectarse a la base de datos */
        try (Connection conexion = DriverManager.getConnection(this.url, this.username,
                this.password)) {

            /*Crea la sentencia*/
            PreparedStatement sentencia = conexion.prepareStatement(consultaEnPersona);

            /*Introducir el parámetro en la consulta*/
            sentencia.setString(1, mago.getNombre());

            /*Guarda todo el resultado de la sentencia*/
            ResultSet resultado = sentencia.executeQuery();

            System.out.println("CAMBIO BORJA");


            if (resultado.next()) {

                /*Obtener el id */
                int id = resultado.getInt("id");

                /*Crea la sentencia*/
                PreparedStatement sentencia1 = conexion.prepareStatement(consultaEnMago);

                /*Sacar el id de mago*/
                sentencia1.setInt(1, id);

                /*Guardar el resultado*/
                ResultSet resultado1 = sentencia1.executeQuery();

                /*Obtener el id mago */


                if (resultado1.next()) {
                    int idMago = resultado1.getInt("id");

                    /*Crea la sentencia*/
                    PreparedStatement sentencia2 = conexion.prepareStatement(introducirMagoAlumno);

                    sentencia2.setInt(1, idMago);

                    int resultado2 = sentencia2.executeUpdate();

                    System.out.println(resultado2);
                }
            }
            System.out.println("Operaciones realizadas con éxito");


        } catch (SQLException e) {
            System.out.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    
}

