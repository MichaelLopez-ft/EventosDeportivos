package models.Excepciones;

public class ParticipanteNoEncontradoException extends Exception {
    public ParticipanteNoEncontradoException(String mensaje) {
        super(mensaje);
    }
}