package persistencia;

import autenticacion.Socio;
import deportivo.Deporte;
import deportivo.Equipo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.*;

public class AlmacenadorArchivos {

    public static Map<String, Socio> cargarSocios(String rutaArchivo) throws Exception {
        Map<String, Socio> socios = new HashMap<>();
        File file = new File(rutaArchivo);
        if (!file.exists()) return socios;

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty() || linea.startsWith("#")) continue;
                String[] partes = linea.split(";");
                // Formato: login;password;nombre;fechaNacimiento(yyyy-MM-dd)
                if (partes.length >= 4) {
                    Date fecha = sdf.parse(partes[3].trim());
                    Socio s = new Socio(partes[0].trim(), partes[1].trim(), partes[2].trim(), fecha);
                    socios.put(s.getLogin(), s);
                }
            }
        }
        return socios;
    }

    public static List<Equipo> cargarEquipos(String rutaArchivo, Map<String, Deporte> deportes) throws Exception {
        List<Equipo> equipos = new ArrayList<>();
        File file = new File(rutaArchivo);
        if (!file.exists()) return equipos;

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty() || linea.startsWith("#")) continue;
                String[] partes = linea.split(";");
                // Formato: nombreEquipo;cupoMax;edadMin;edadMax;nombreDeporte
                if (partes.length >= 5) {
                    String nomEq = partes[0].trim();
                    int cupo = Integer.parseInt(partes[1].trim());
                    int edadMin = Integer.parseInt(partes[2].trim());
                    int edadMax = Integer.parseInt(partes[3].trim());
                    String nomDep = partes[4].trim();

                    Deporte dep = deportes.computeIfAbsent(nomDep, k -> new Deporte(k, 5));
                    equipos.add(new Equipo(nomEq, cupo, edadMin, edadMax, dep));
                }
            }
        }
        return equipos;
    }
}