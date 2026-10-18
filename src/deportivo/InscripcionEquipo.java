package deportivo;

import java.util.List;
import autenticacion.Socio;

public class InscripcionEquipo {
    private Equipo equipo;
    private List<Socio> nominaHabilitada;
    private int puntos;
    private int partidosJugados;
    private int partidosGanados;
    private int partidosEmpatados;
    private int partidosPerdidos;

    public InscripcionEquipo(Equipo equipo, List<Socio> nominaHabilitada) {
        this.equipo = equipo;
        this.nominaHabilitada = nominaHabilitada;
        this.puntos = 0;
        this.partidosJugados = 0;
        this.partidosGanados = 0;
        this.partidosEmpatados = 0;
        this.partidosPerdidos = 0;
    }

    public Equipo getEquipo() {
        return equipo;
    }

    public List<Socio> getNominaHabilitada() {
        return nominaHabilitada;
    }

    public int getPuntos() {
        return puntos;
    }

    public int getPartidosJugados() {
        return partidosJugados;
    }

    // Métodos getters faltantes que causaban el error de compilación
    public int getPartidosGanados() {
        return partidosGanados;
    }

    public int getPartidosEmpatados() {
        return partidosEmpatados;
    }

    public int getPartidosPerdidos() {
        return partidosPerdidos;
    }

    public void registrarResultado(int golesFavor, int golesContra) {
        partidosJugados++;
        if (golesFavor > golesContra) {
            partidosGanados++;
            puntos += 3; // 3 puntos por victoria en fútbol
        } else if (golesFavor == golesContra) {
            partidosEmpatados++;
            puntos += 1; // 1 punto por empate
        } else {
            partidosPerdidos++;
            // 0 puntos por derrota
        }
    }
}