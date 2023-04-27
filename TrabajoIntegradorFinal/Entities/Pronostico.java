package TrabajoIntegradorFinal.Entities;

public class Pronostico {
    private Partido partido;
    private Equipo equipo;
    private ResultadoEnum resultado;
    private String participante;

    // Constructor
    public Pronostico(Partido partido, Equipo equipo, ResultadoEnum resultado,String participante) {
        this.partido = partido;
        this.equipo = equipo;
        this.resultado = resultado;
        this.participante = participante;
    }

    // Métodos getter y setter
    public Partido getPartido() {
        return partido;
    }

    public void setPartido(Partido partido) {
        this.partido = partido;
    }

    public String getParticipante(){
        return participante;
    }
    public Equipo getEquipo() {
        return equipo;
    }

    public void setEquipo(Equipo equipo) {
        this.equipo = equipo;
    }

    public ResultadoEnum getResultado() {
        return resultado;
    }

    public void setResultado(ResultadoEnum resultado) {
        this.resultado = resultado;
    }

    public int puntos() {
        if (partido.resultado(equipo) == resultado) {
            return 1;
        } else {
            // Si no coincide, no se otorgan puntos.
            return 0;
        }
    }
}
