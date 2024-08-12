package models;

import java.util.ArrayList;
import java.util.List;

public class Participante extends models.Persona {
    private List<models.Evento> eventos;

    public Participante(String nombre, String id) {
        super(nombre, id);
        this.eventos = new ArrayList<>();
    }

    public List<models.Evento> getEventos() {
        return eventos;
    }

    public void agregarEvento(models.Evento evento) {
        if (!eventos.contains(evento)) {
            eventos.add(evento);
        }
    }
}

