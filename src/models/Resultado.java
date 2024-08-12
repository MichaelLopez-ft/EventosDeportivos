package models;

import java.util.List;

public class Resultado {
    private Evento evento;
    private Participante ganador;
    private List<Participante> posiciones;

    public Resultado(Evento evento, Participante ganador, List<Participante> posiciones) {
        this.evento = evento;
        this.ganador = ganador;
        this.posiciones = posiciones;
    }

    public Evento getEvento() {
        return evento;
    }

    public Participante getGanador() {
        return ganador;
    }

    public List<Participante> getPosiciones() {
        return posiciones;
    }
}

