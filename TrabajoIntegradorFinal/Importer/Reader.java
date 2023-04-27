package TrabajoIntegradorFinal.Importer;
import TrabajoIntegradorFinal.Entities.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Reader {
    public static void main(String[] args) {

        // Leer archivo partidos.txt
        String rutaRonda = "C:\\Users\\Joel\\Documents\\GitHub\\CursoJavaArgPrograma\\TrabajoIntegradorFinal\\Importer\\Partidos.txt";

        Ronda ronda = null;
        try {
            BufferedReader reader = new BufferedReader(new FileReader(rutaRonda));
            String partido;
            String[] datos;
            String[] goles;
            Partido[] partidos = new Partido[6];
            int i = 0;
            String numeroRonda = null;
            while ((partido = reader.readLine()) != null) {
                datos = partido.split(",");
                numeroRonda = datos[0];
                String nombreEquipo1 = datos[1];
                String nombreEquipo2 = datos[2];

                Equipo equipo1 = new Equipo(nombreEquipo1);
                Equipo equipo2 = new Equipo(nombreEquipo2);

                goles = datos[3].split("-");
                int golesEquipo1 = Integer.parseInt(goles[0]);
                int golesEquipo2 = Integer.parseInt(goles[1]);

                partidos[i] = new Partido(equipo1, equipo2, golesEquipo1, golesEquipo2);
                i++;
            }

            ronda = new Ronda(numeroRonda, partidos);
            System.out.println(numeroRonda);
            reader.close(); // cierra el reader
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        System.out.println("----- RESULTADOS -----");
        for (Partido p : ronda.getPartidos()) {
            System.out.println(p.getEquipo1().getNombre() + " " + p.getGolesEquipo1() + " - " + p.getGolesEquipo2() + " " + p.getEquipo2().getNombre());
        }

        // Leer archivo pronostico.txt
        String rutaPronosticos = "C:\\Users\\Joel\\Documents\\GitHub\\CursoJavaArgPrograma\\TrabajoIntegradorFinal\\Importer\\Pronostico.txt";

        Pronostico[] pronosticos = new Pronostico[2];
        try {
            BufferedReader reader = new BufferedReader(new FileReader(rutaPronosticos));
            String partido;
            String[] datos;
            pronosticos = new Pronostico[6];
            int i = 0;
            while ((partido = reader.readLine()) != null) {
                datos = partido.split(",");
                String nombreParticipante = datos[0];
                String nombreEquipo = datos[1];
                String resultado = datos[2];
                Equipo equipo1Partido = ronda.getPartidos()[i].getEquipo1();
                Equipo equipo2Partido = ronda.getPartidos()[i].getEquipo2();

                ResultadoEnum resultadoEquipo;
                if (resultado.equals("PERDEDOR")) {
                    resultadoEquipo = ResultadoEnum.PERDEDOR;
                } else if (resultado.equals("GANADOR")) {
                    resultadoEquipo = ResultadoEnum.GANADOR;
                } else {
                    resultadoEquipo = ResultadoEnum.EMPATE;
                }

                if (nombreEquipo == equipo1Partido.getNombre()){
                    pronosticos[i] = new Pronostico(ronda.getPartidos()[i], equipo1Partido, resultadoEquipo, nombreParticipante);
                } else {
                    pronosticos[i] = new Pronostico(ronda.getPartidos()[i], equipo2Partido, resultadoEquipo, nombreParticipante);

                }
                i++;
            }

            reader.close(); // cierra el reader
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        int sumaPuntos = 0;
        System.out.println("----- PREDICCIONES -----");
        HashMap<String, Integer> puntos = new HashMap<String, Integer>();
        for (Pronostico pro : pronosticos) {
            puntos.putIfAbsent(pro.getParticipante(), 0);
            sumaPuntos += pro.puntos() + puntos.get(pro.getParticipante());
            puntos.put(pro.getParticipante(), sumaPuntos);
            System.out.println(pro.getResultado() + ": " + pro.getEquipo().getNombre());
            sumaPuntos = 0;
        }

        for (String key : puntos.keySet()){
            System.out.println("\nPuntaje de " + key + ": " + puntos.get(key));

        }
    }
}