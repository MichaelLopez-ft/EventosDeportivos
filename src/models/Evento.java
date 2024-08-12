package models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Evento {
    private String nombre;
    private String descripcion;
    private LocalDateTime fechaInicio;
    private LocalDateTime fechaFin;
    private List<Participante> participantes;
    private models.Resultado resultado;

    public Evento(String nombre, String descripcion, LocalDateTime fechaInicio, LocalDateTime fechaFin) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.participantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Participante> getParticipantes() {
        return participantes;
    }

    public void agregarParticipante(Participante participante) {
        if (!participantes.contains(participante)) {
            participantes.add(participante);
            participante.agregarEvento(this);
        }
    }

    public void setResultado(models.Resultado resultado) {
        this.resultado = resultado;
    }

    public models.Resultado getResultado() {
        return resultado;
    }
}

