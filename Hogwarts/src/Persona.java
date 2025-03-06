import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public abstract class Persona {

    private String nombre;
    private LocalDate fechaNac;
    protected int edad;


    protected Persona(String nombre, String fechaNac) {
        this.nombre = nombre;
        this.fechaNac = LocalDate.parse(fechaNac);
        this.edad = calcularEdad();

    }

    public abstract Boolean esMayor();

    protected int calcularEdad() {
        LocalDate fechaActual = LocalDate.now();
        int years = (int) ChronoUnit.YEARS.between(this.fechaNac, fechaActual); // Cambio en el orden de los argumentos
        return years;
    }


    @Override
    public String toString() {

        return "Su nombre es: " + this.nombre + ", y nació el: " + this.fechaNac;
    }

    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaNac() {
        return fechaNac;
    }
}
