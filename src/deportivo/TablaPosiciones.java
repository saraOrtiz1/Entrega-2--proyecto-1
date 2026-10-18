package deportivo;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class TablaPosiciones {
    private List<InscripcionEquipo> inscripcionesEquipos;

    public TablaPosiciones(List<InscripcionEquipo> inscripcionesEquipos) {
        this.inscripcionesEquipos = inscripcionesEquipos;
    }

    public void calcularYOrdenar() {
        // Ordenar de mayor a menor por Puntos
        inscripcionesEquipos.sort(Comparator.comparingInt(InscripcionEquipo::getPuntos).reversed());
    }

    public void mostrarTabla() {
        calcularYOrdenar();
        System.out.println("==========================================================================================================");
        System.out.println(" TABLA DE POSICIONES - LIGA OFICIAL");
        System.out.println("==========================================================================================================");
        System.out.printf("%-20s | %-8s | %-8s | %-8s | %-8s | %-8s%n", "Equipo", "PJ", "PG", "PE", "PP", "Puntos");
        System.out.println("----------------------------------------------------------------------------------------------------------");
        
        for (InscripcionEquipo ie : inscripcionesEquipos) {
            System.out.printf("%-20s | %-8d | %-8d | %-8d | %-8d | %-8d%n",
                ie.getEquipo().getNombre(),
                ie.getPartidosJugados(),
                ie.getPartidosGanados(),
                ie.getPartidosEmpatados(),
                ie.getPartidosPerdidos(),
                ie.getPuntos()
            );
        }
        System.out.println("==========================================================================================================");
    }
}