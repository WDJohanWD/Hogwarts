public class Muggle extends Persona {
    private Boolean creeEnMagia;


    public Muggle(String nombre, String fechaNac) {
        super(nombre, fechaNac);
        this.creeEnMagia = false;

    }

    public Muggle(String nombre, String fechaNac, Boolean creeEnMagia) {
        super(nombre, fechaNac);
        this.creeEnMagia = creeEnMagia;
    }

    @Override
    public Boolean esMayor() {
        return edad >= 18;
    }
}
