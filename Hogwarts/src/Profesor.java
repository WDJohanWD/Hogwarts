import java.util.Random;

public class Profesor extends Mago implements Docente {
    private final String[] frasesIconicas = {
            "No es bueno dejarse arrastrar por los sueños y olvidar vivir",
            "La valentía siempre es la mejor opción",
            "La felicidad se puede encontrar incluso en los momentos más oscuros, si uno recuerda" +
                    " encender la luz",
            "Por el bien común",
            "Son nuestras elecciones las que muestran quienes somos realmente, mucho más que " +
                    "nuestras habilidades"
    };

    public Profesor(String nombre, String fechaNac, String tipoEscoba) {
        super(nombre, fechaNac, tipoEscoba);
    }


    @Override
    public void imponerDisciplina() {
        System.out.println("Silencio Totalis");
    }

    @Override
    public void explicar() {
        Random r = new Random();
        int index= r.nextInt(frasesIconicas.length);
        System.out.println(frasesIconicas[index]);
    }
}
