package proyecto.reto_tecnicosofka.facade;

import proyecto.reto_tecnicosofka.models.Jugador;
import proyecto.reto_tecnicosofka.models.Ronda;

import java.util.List;

public class Juego {

    private List<Jugador> jugadores;
    private List<Ronda> rondas;

    public Juego() {
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    public List<Ronda> getRondas() {
        return rondas;
    }

    public void setRondas(List<Ronda> rondas) {
        this.rondas = rondas;
    }
}
