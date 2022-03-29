package proyecto.reto_tecnicosofka.facade;

import proyecto.reto_tecnicosofka.models.Jugador;
import proyecto.reto_tecnicosofka.models.Opcion;
import proyecto.reto_tecnicosofka.models.Pregunta;
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

    public void configurarJuego(){
        rondas.add(new Ronda(0,10));
        rondas.add(new Ronda(1,15));
        rondas.add(new Ronda(2,30));
        rondas.add(new Ronda(3,50));
        rondas.add(new Ronda(4,100));
    }

    public Jugador crearJugador(String nombre, int edad){
        Jugador jugador=new Jugador(nombre,edad,0);
        jugador.asignarRonda(rondas.get(0));
        jugadores.add(jugador);
        return jugador;
    }

    public void crearPreguntas(String descripcionPregunta,Integer nivel,
                               String descripcionOpcion1, String descripcionOpcion2, String descripcionOpcion3,
                               String descripcionOpcion4, Boolean correcto1, Boolean correcto2,
                               Boolean correcto3, Boolean correcto4){
        for (Ronda rango:this.rondas) {
           if ( rango.getCategoria().getNivel()==nivel){
               rango.getCategoria().crearPreguntas(descripcionPregunta, descripcionOpcion1,
                       descripcionOpcion2, descripcionOpcion3, descripcionOpcion4, correcto1, correcto2,
                       correcto3, correcto4);
           }
        }
    }

    public Pregunta iniciarJuego(){
        return rondas.get(0).getCategoria().elegirPregunta();
    }

    public Pregunta continuarJuego(int nivel){
        return rondas.get(nivel).getCategoria().elegirPregunta();
    }

    public boolean responderPregunta(int ronda, String descripcion) {
        return rondas.get(ronda).getCategoria().getPreguntas().get(ronda).elegirRespuesta(descripcion);
    }

    public String validarCantidadDePreguntas() {
        String mensaje="";
        for (Ronda r:rondas) {
            String respuesta=r.getCategoria().validarCantidadDePreguntas();
            if (!respuesta.equalsIgnoreCase("")){
                mensaje+=respuesta;
                mensaje+="\n";
            }
        }
        return mensaje;
    }

    public int aumentarNivel(int ronda, String descripcion) {
        int nivelActual = rondas.get(ronda).getCategoria().getNivel();
        if (responderPregunta(ronda,descripcion)) {
            nivelActual = nivelActual + 1;
            return nivelActual;
        }
        return 0;
    }

    public void aumentarNivelCategoria(Jugador jugador) {
        if (jugador.getRonda().getCategoria().getNivel() < 4) {
            jugador.asignarRonda(rondas.get(jugador.getRonda().getCategoria().getNivel() + 1));
        }
    }

}
