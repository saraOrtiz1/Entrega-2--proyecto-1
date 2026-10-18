package deportivo;

import java.util.ArrayList;
import java.util.List;

public class Competencia {
    private String nombre;
    private List<InscripcionEquipo> equiposInscritos;

    public Competencia(String nombre) {
        this.nombre = nombre;
        this.equiposInscritos = new ArrayList<>();
    }

    public void inscribirEquipo(InscripcionEquipo inscripcion) {
        equiposInscritos.add(inscripcion);
    }

    public List<InscripcionEquipo> getEquiposInscritos() {
        return equiposInscritos;
    }

    public String getNombre() {
        return nombre;
    }
}
