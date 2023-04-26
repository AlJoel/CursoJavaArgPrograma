package TrabajoIntegrador.Entidades;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Partido {

	private Equipo equipo1;
	private Equipo equipo2;
	private int golesEquipo1;
	private int golesEquipo2;

	public Equipo getEquipo1() {
		return equipo1;
	}

	public void setEquipo1(Equipo equipo1) {
		this.equipo1 = equipo1;
	}

	public Equipo getEquipo2() {
		return equipo2;
	}

	public void setEquipo2(Equipo equipo2) {
		this.equipo2 = equipo2;
	}

	public int getGolesEquipo1() {
		return golesEquipo1;
	}

	public void setGolesEquipo1(int golesEquipo1) {
		this.golesEquipo1 = golesEquipo1;
	}

	public int getGolesEquipo2() {
		return golesEquipo2;
	}

	public void setGolesEquipo2(int golesEquipo2) {
		this.golesEquipo2 = golesEquipo2;
	}

	public ResultadoEnum resultado(Equipo equipo) throws FileNotFoundException {

		ResultadoEnum resultado;
		File pronostico = new File("pronostico.txt");
		Scanner scanner = new Scanner(pronostico);

		while (scanner.hasNextLine()) {
			String[] linea = scanner.nextLine().split(",");
			if (linea[0].equals(equipo.getNombre()) || linea[1].equals(equipo.getNombre())) {
				int golesLocal = Integer.parseInt(linea[2]);
				int golesVisitante = Integer.parseInt(linea[3]);
				if (linea[0].equals(equipo.getNombre())) {
					if (golesLocal > golesVisitante) {
						resultado = ResultadoEnum.GANADOR;
					} else if (golesLocal < golesVisitante) {
						resultado = ResultadoEnum.PERDEDOR;
					} else {
						resultado = ResultadoEnum.EMPATE;
					}
				} else {
					if (golesVisitante > golesLocal) {
						resultado = ResultadoEnum.GANADOR;
					} else if (golesVisitante < golesLocal) {
						resultado = ResultadoEnum.PERDEDOR;
					} else {
						resultado = ResultadoEnum.EMPATE;
					}
				}
				return resultado;
			}
		}
		return null;
	}
}
