import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Hogwarts {
    private ArrayList<Mago> listaAlumnos = new ArrayList<>();
    private HashMap<Mago, String> materiasImpartidas = new HashMap<Mago, String>();


    public Hogwarts() {
        this.listaAlumnos = new ArrayList<>();
        this.materiasImpartidas = new HashMap<>();

    }

    public void añadirAlumno(Mago alumno) {
        Random r = new Random();
        int num = r.nextInt(Casa.values().length);
        Casa c = Casa.values()[num];
        alumno.setCasa(c);
        listaAlumnos.add(alumno);
    }

    public void graduar(Mago alumno) {
        listaAlumnos.remove(alumno);
    }

    public void asignarProfesor(String materia, Profesor profe) {
        materiasImpartidas.put(profe, materia);
    }

    public void listarProfesores() {

        for (Mago profe : materiasImpartidas.keySet()) {

            System.out.printf("El profesor que imparte la asignatura de %s es %s",
                    materiasImpartidas.get(profe), profe);
        }
    }

    public ArrayList<Mago> alumnadoCasa(Casa casa) {
        ArrayList<Mago> alumnado = new ArrayList<>();
        for (Mago alumno : listaAlumnos) {
            if (alumno.getCasa().equals(casa)) {
                alumnado.add(alumno);
            }
        }
        return alumnado;
    }

}

