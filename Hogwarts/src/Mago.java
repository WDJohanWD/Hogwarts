public class Mago extends Persona {
    private String tipoEscoba;
    private Casa casa;

    public Mago(String nombre, String fechaNac, String tipoEscoba) {
        super(nombre, fechaNac);
        this.tipoEscoba = tipoEscoba;
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
    public void setCasa(Casa casa) {
        this.casa = casa;
    }
    public Casa getCasa() {
        return casa;
    }
}
