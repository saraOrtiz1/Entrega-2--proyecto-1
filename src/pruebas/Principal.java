package pruebas;

import java.util.Date;

import autenticacion.Autenticador;
import autenticacion.ConsolaMenu;
import autenticacion.CoordinadorAplicacion;
import autenticacion.Empleado;
import autenticacion.Socio;
import comercio.AlimentoCafeteria;
import comercio.Bebida;
import comercio.CalculadorPuntos;
import comercio.CodigoDescuento;
import comercio.CuentaPuntos;
import comercio.GeneradorReportes;
import comercio.GestorDescuentos;
import comercio.Impuestos;
import comercio.ParametroFinanciero;
import comercio.Producto;
import comercio.ReglaBebidaCaliente;
import comercio.RegistroTurnos;
import comercio.Snack;
import deportivo.Turno;


public class Principal {

    public static void main(String[] args) {
        ConsolaMenu consola = new ConsolaMenu();
        Autenticador autenticador = new Autenticador();

        ParametroFinanciero parametros = new ParametroFinanciero(0.19, 0.08, 0.02, 8.0);
        GestorDescuentos gestorDescuentos = new GestorDescuentos(parametros);
        Impuestos impuestos = new Impuestos(parametros);
        CalculadorPuntos calculadorPuntos = new CalculadorPuntos(parametros);
        ReglaBebidaCaliente reglaBebidaCaliente = new ReglaBebidaCaliente();
        RegistroTurnos registroTurnos = new RegistroTurnos();
        GeneradorReportes generadorReportes = new GeneradorReportes();

        CoordinadorAplicacion coordinador = new CoordinadorAplicacion(consola, autenticador,
                gestorDescuentos, impuestos, calculadorPuntos, reglaBebidaCaliente,
                registroTurnos, generadorReportes);

        // Usuarios
        Socio socio1 = new Socio("socio1", "1234", "Carlos Pérez", new Date());
        Socio socio2 = new Socio("socio2", "1234", "Ana Torres", new Date());
        Empleado empleado1 = new Empleado("empleado1", "1234", "Laura Gómez");
        autenticador.registrarUsuario(socio1);
        autenticador.registrarUsuario(socio2);
        autenticador.registrarUsuario(empleado1);

        coordinador.registrarSocio(socio1);
        coordinador.registrarSocio(socio2);
        coordinador.registrarCuentaPuntos(socio1, new CuentaPuntos(0));
        coordinador.registrarCuentaPuntos(socio2, new CuentaPuntos(0));

        // Productos de la tienda
        coordinador.registrarProducto(new Producto("Raqueta de pádel", "Raquetas", 200000, 5));
        coordinador.registrarProducto(new Producto("Tubo de pelotas", "Pelotas", 5000, 20));
        coordinador.registrarProducto(new Producto("Camiseta del club", "Ropa", 60000, 10));

        // Cafetería
        AlimentoCafeteria cafe = new Bebida("Café americano", 5000, "caliente");
        AlimentoCafeteria limonada = new Bebida("Limonada", 6000, "fria");
        AlimentoCafeteria galletas = new Snack("Galletas", 3000);
        coordinador.registrarAlimento(cafe);
        coordinador.registrarAlimento(limonada);
        coordinador.registrarAlimento(galletas);

        // Código de descuento del empleado (15 % para él, 8 % compartido)
        CodigoDescuento codigo = new CodigoDescuento(15, 8);
        codigo.setPropietario(empleado1);
        coordinador.registrarCodigoDescuento(codigo);

        // Turnos: sábado con 3 entrenadores y 1 fisioterapeuta
        coordinador.registrarTurno(new Turno("T1", "e1", "Entrenador 1", "Sabado", "08:00-12:00", "Gimnasio", "ENTRENADOR"));
        coordinador.registrarTurno(new Turno("T2", "e2", "Entrenador 2", "Sabado", "08:00-12:00", "Gimnasio", "ENTRENADOR"));
        coordinador.registrarTurno(new Turno("T3", "e3", "Entrenador 3", "Sabado", "08:00-12:00", "Gimnasio", "ENTRENADOR"));
        coordinador.registrarTurno(new Turno("T4", "f1", "Fisio 1", "Sabado", "08:00-12:00", "Fisioterapia", "FISIOTERAPEUTA"));

        coordinador.iniciar();
    }
}
