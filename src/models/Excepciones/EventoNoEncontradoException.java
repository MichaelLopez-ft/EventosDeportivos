// src/models/Excepciones/EventoNoEncontradoException.java
package models.Excepciones;

public class EventoNoEncontradoException extends Exception {
    public EventoNoEncontradoException(String mensaje) {
        super("No se encontro el evento " + mensaje);
    }
}


