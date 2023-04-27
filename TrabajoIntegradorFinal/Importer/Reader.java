package TrabajoIntegradorFinal.Importer;
import TrabajoIntegradorFinal.Entities.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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
            Partido[] partidos = new Partido[2];
            int i = 0;
            while ((partido = reader.readLine()) != null) {
                datos = partido.split(",");
                String nombreEquipo1 = datos[0];
                String nombreEquipo2 = datos[1];

                Equipo equipo1 = new Equipo(nombreEquipo1);
                Equipo equipo2 = new Equipo(nombreEquipo2);

                goles = datos[2].split("-");
                int golesEquipo1 = Integer.parseInt(goles[0]);
                int golesEquipo2 = Integer.parseInt(goles[1]);

                partidos[i] = new Partido(equipo1, equipo2, golesEquipo1, golesEquipo2);
                i++;
            }

            //System.out.println(partidos[0].resultado(partidos[0].getEquipo1()));
            String numeroRonda = Integer.toString(1);
            ronda = new Ronda(numeroRonda, partidos);

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
            pronosticos = new Pronostico[2];
            int i = 0;
            while ((partido = reader.readLine()) != null) {
                datos = partido.split(",");
                String nombreEquipo = datos[0];
                String resultado = datos[1];
                Equipo equipo1Partido = ronda.getPartidos()[i].getEquipo1();
                Equipo equipo2Partido = ronda.getPartidos()[i].getEquipo2();
                String nombreEquipo1 = equipo1Partido.getNombre();
                Equipo equipo;

                ResultadoEnum resultadoEquipo;
                if (resultado.equals("PERDEDOR")) {
                    resultadoEquipo = ResultadoEnum.PERDEDOR;
                } else if (resultado.equals("GANADOR")) {
                    resultadoEquipo = ResultadoEnum.GANADOR;
                } else {
                    resultadoEquipo = ResultadoEnum.EMPATE;
                }

                if (nombreEquipo == equipo1Partido.getNombre()){
                    pronosticos[i] = new Pronostico(ronda.getPartidos()[i], equipo1Partido, resultadoEquipo);
                } else {
                    pronosticos[i] = new Pronostico(ronda.getPartidos()[i], equipo2Partido, resultadoEquipo);

                }
                i++;
            }

            reader.close(); // cierra el reader
        } catch (IOException e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }

        int sumaPuntos = 0;
        System.out.println("----- PREDICCIONES -----");

        for (Pronostico pro : pronosticos) {
            sumaPuntos += pro.puntos();
            System.out.println(pro.getResultado() + ": " + pro.getEquipo().getNombre());
        }
        System.out.println("\nPuntaje: " + String.valueOf(sumaPuntos));
    }
}