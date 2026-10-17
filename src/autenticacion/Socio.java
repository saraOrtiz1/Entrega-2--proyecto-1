package autenticacion;
import java.util.Date;
import deportivo.Deporte; 

public class Socio extends Usuario {
 private String nombre;
 private Date fechaNacimiento;
 private int puntos;

 public Socio(String login, String password, String nombre, Date fechaNacimiento) {
     super(login, password);
     this.nombre = nombre;
     this.fechaNacimiento = fechaNacimiento;
     this.puntos = 0;
 }

 public String getNombre() {
     return nombre;
 }

 public Date getFechaNacimiento() {
     return fechaNacimiento;
 }

 public int getPuntos() {
     return puntos;
 }

 public int calcularEdad() {
     Date fechaActual = new Date();
     long diff = fechaActual.getTime() - fechaNacimiento.getTime();
     long anos = diff / (1000L * 60 * 60 * 24 * 365);
     return (int) anos;
 }

 public boolean estaInscritoEn(Deporte deporte) {
     // Lógica básica que validará si está inscrito en el deporte
     return true;}
}
