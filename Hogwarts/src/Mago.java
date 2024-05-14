public class Mago extends Persona {
    private String tipoEscoba;
    
    public Mago(String nombre, String fechaNac) {
        super(nombre, fechaNac);

    }

    @Override
    public Boolean esMayor() {
        return edad >=17;
    }
}
