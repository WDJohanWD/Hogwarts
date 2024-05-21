import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        DAO baseDatos = new DAO("jdbc:mysql://localhost:3306/hogwarts","root", "");

        Mago harry = new Mago("Harry Potter","2003-10-05","si");


        baseDatos.crearAlumno(harry);
    }

}