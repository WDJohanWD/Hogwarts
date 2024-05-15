import org.w3c.dom.ls.LSOutput;

import java.time.LocalDate;
import java.util.Date;

public class Main {
    public static void main(String[] args) {


        Profesor snape = new Profesor("Snape","1111-11-11","si");
        snape.explicar();
        snape.imponerDisciplina();
    }

}