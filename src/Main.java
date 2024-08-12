import models.*;
import models.Resultado;
import services.*;
import models.Excepciones.*;
import java.time.LocalDateTime;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        GestionEventos gestionEventos = new GestionEventos();

        // Registrar participantes
        Participante p1 = new Participante("Sergio López", "1234");
        Participante p2 = new Participante("Ana Gomez", "2050");
        gestionEventos.registrarParticipante(p1);
        gestionEventos.registrarParticipante(p2);

        // Registrar evento
        Evento evento1 = new Evento("Carrera 21K", "Carrera de 21 kilómetros", LocalDateTime.now().plusDays(1), LocalDateTime.now().plusDays(1).plusHours(1));
        gestionEventos.registrarEvento(evento1);

        // Asignar participantes al evento
        try {
            gestionEventos.asignarParticipanteAEvento("1234", "Carrera 21K");
            gestionEventos.asignarParticipanteAEvento("2050", "Carrera 21K");
        } catch (EventoNoEncontradoException | ParticipanteNoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        // Registrar resultado
        Resultado resultado = new Resultado(evento1, p1, Arrays.asList(p1, p2));
        try {
            gestionEventos.registrarResultado("Carrera 21K", resultado);
        } catch (EventoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }

        // Consultar evento
        try {
            Evento eventoConsultado = gestionEventos.consultarEvento("Carrera 21K");
            System.out.println("Evento: " + eventoConsultado.getNombre());
            System.out.println("Ganador: " + eventoConsultado.getResultado().getGanador().getNombre());
        } catch (EventoNoEncontradoException e) {
            System.out.println(e.getMessage());
        }
    }
}

