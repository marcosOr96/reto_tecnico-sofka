package proyecto.reto_tecnicosofka.facade;

import proyecto.reto_tecnicosofka.models.Jugador;
import proyecto.reto_tecnicosofka.models.Ronda;

import java.util.ArrayList;
import java.util.List;

public class Juego {

    private List<Jugador> jugadores;
    private List<Ronda> rondas;

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public Juego() {
        this.jugadores = new ArrayList<>();
        this.rondas = new ArrayList<>();
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

    public void configurarJuego(String nombre, int edad){
        this.jugadores.add(new Jugador(nombre,edad,0));
        rondas.add(new Ronda(0));
        rondas.add(new Ronda(1));
        rondas.add(new Ronda(2));
        rondas.add(new Ronda(3));
        rondas.add(new Ronda(4));
    }

    public void crearPreguntas(String descripcionPregunta,Integer nivel,
                               String descripcionOpcion1, String descripcionOpcion2, String descripcionOpcion3,
                               String descripcionOpcion4, Boolean correcto1, Boolean correcto2,
                               Boolean correcto3, Boolean correcto4){
        for (Ronda rango:this.rondas) {
           if ( rango.getCategoria().getNivel()==nivel){
               rango.getCategoria().crearPreguntas(descripcionPregunta);
           }
        }
    }

    public void iniciarJuego(){
        rondas.get(0).getCategoria().elegirPregunta();
    }

    public void responderPregunta(int posicion) {
        rondas.get(posicion).getCategoria().getPreguntas().get(1).elegirRespuesta();
    }

    public void aumentarNivel(int posicion) {
        if (rondas.get(posicion).getCategoria().elegirPregunta().elegirRespuesta()) {
            posicion = posicion + 1;
            rondas.get(posicion).getCategoria().elegirPregunta();
            rondas.get(posicion).getCategoria().getPreguntas().get(1).elegirRespuesta();
        }
    }

    public int acomularPremios(int posicion, int jugadorNumero){
        int acomulado = 0;
        if (rondas.get(posicion).getCategoria().elegirPregunta().elegirRespuesta()) {
            for (int i = 0; i < posicion; i++) {
                acomulado = acomulado + rondas.get(i).getPremio().getCantPuntos();
            }
            return acomulado;
        }
        return acomulado;
    }
}
