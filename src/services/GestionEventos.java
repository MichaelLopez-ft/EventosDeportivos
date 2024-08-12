package services;

import models.*;
import models.Excepciones.*;
import models.Resultado;

import java.util.HashMap;
import java.util.Map;

public class GestionEventos {
    private Map<String, Evento> eventos;
    private Map<String, Participante> participantes;

    public GestionEventos() {
        this.eventos = new HashMap<>();
        this.participantes = new HashMap<>();
    }

    public void registrarEvento(Evento evento) {
        eventos.put(evento.getNombre(), evento);
    }

    public void registrarParticipante(Participante participante) {
        participantes.put(participante.getId(), participante);
    }

    public void asignarParticipanteAEvento(String idParticipante, String nombreEvento) throws EventoNoEncontradoException, ParticipanteNoEncontradoException {
        Evento evento = eventos.get(nombreEvento);
        Participante participante = participantes.get(idParticipante);

        if (evento == null) {
            throw new EventoNoEncontradoException("El evento " + nombreEvento + " no fue encontrado.");
        }

        if (participante == null) {
            throw new ParticipanteNoEncontradoException("El participante con ID " + idParticipante + " no fue encontrado.");
        }

        evento.agregarParticipante(participante);
    }

    public void registrarResultado(String nombreEvento, Resultado resultado) throws EventoNoEncontradoException {
        Evento evento = eventos.get(nombreEvento);

        if (evento == null) {
            throw new EventoNoEncontradoException("El evento " + nombreEvento + " no fue encontrado.");
        }

        evento.setResultado(resultado);
    }

    public Evento consultarEvento(String nombreEvento) throws EventoNoEncontradoException {
        Evento evento = eventos.get(nombreEvento);
        if (evento == null) {
            throw new EventoNoEncontradoException("El evento " + nombreEvento + " no fue encontrado.");
        }
        return evento;
    }
}

