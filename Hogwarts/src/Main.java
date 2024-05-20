import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {

        Profesor snape = new Profesor("Snape","1111-11-11","si");
        snape.explicar();
        snape.imponerDisciplina();
        Hogwarts hogwarts = new Hogwarts();
        Mago Esteban = new Mago("Mago","2003-10-05","si");
        hogwarts.añadirAlumno(Esteban);
        System.out.println(Esteban.getCasa());
    }

}