public class Mago extends Persona {
    private String tipoEscoba;

    public Mago(String nombre, String fechaNac) {
        super(nombre, fechaNac);
    }

    @Override
    public Boolean esMayor() {
        return edad >= 17;
    }

    @Override
    public String toString() {
        return "El nombre del mago es: " + super.getNombre() + ", la fecha de" + " nacimiento es:" +
                " " + super.getFechaNac() + "y el tipo de " + "escoba es: " + this.tipoEscoba;

    }
}
