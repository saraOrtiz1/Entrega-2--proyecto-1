package deportivo;

import java.util.Date;

public class Turno {
    private String idTurno;
    private String empleadoId;
    private String nombreEmpleado;
    private String diaSemana; // Ej: "Lunes", "Martes"
    private String franjaHoraria; // Ej: "08:00-14:00"
    private String area; // Ej: "Gimnasio", "Fisioterapia", "Pádel"

    public Turno(String idTurno, String empleadoId, String nombreEmpleado, String diaSemana, String franjaHoraria, String area) {
        this.idTurno = idTurno;
        this.empleadoId = empleadoId;
        this.nombreEmpleado = nombreEmpleado;
        this.diaSemana = diaSemana;
        this.franjaHoraria = franjaHoraria;
        this.area = area;
    }

    public String getIdTurno() { return idTurno; }
    public String getEmpleadoId() { return empleadoId; }
    public void setEmpleadoId(String empleadoId) { this.empleadoId = empleadoId; }
    public String getNombreEmpleado() { return nombreEmpleado; }
    public void setNombreEmpleado(String nombreEmpleado) { this.nombreEmpleado = nombreEmpleado; }
    public String getDiaSemana() { return diaSemana; }
    public String getFranjaHoraria() { return franjaHoraria; }
    public String getArea() { return area; }
}