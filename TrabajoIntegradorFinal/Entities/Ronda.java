package TrabajoIntegradorFinal.Entities;

public class Ronda {
    private String nro;
    private Partido[] partidos;

    // Constructor
    public Ronda(String nro, Partido[] partidos) {
        this.nro = nro;
        this.partidos = partidos;
    }

    // Métodos getter y setter
    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public Partido[] getPartidos() {
        return partidos;
    }

    public void setPartidos(Partido[] partidos) {
        this.partidos = partidos;
    }
}