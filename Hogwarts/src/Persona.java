import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Persona {


    private String nombre;
    private LocalDate fechaNac;
    protected int edad;


    public Persona(String nombre, String fechaNac) {
        this.nombre = nombre;
        this.edad = calcularEdad();
    }

    public abstract Boolean esMayor();

    protected int calcularEdad() {
        LocalDate fechaActual = LocalDate.now();
        int years = (int) ChronoUnit.YEARS.between(fechaActual, this.fechaNac);
        return years;
    }

    @Override
    public String toString() {

        return "El nombre de la persona es: " + this.nombre + ", y la fecha de nacimiento es: " + this.fechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }
}
