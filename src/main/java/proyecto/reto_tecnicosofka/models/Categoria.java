package proyecto.reto_tecnicosofka.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Categoria {

    private int nivel;
    private List<Pregunta> preguntas;

    public Categoria(int nivel) {
        this.nivel=nivel;
        this.preguntas = new ArrayList<>();
    }


    public int getNivel() {
        return nivel;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    public List<Pregunta> getPreguntas() {
        return preguntas;
    }

    public void setPregunta(List<Pregunta> preguntas) {
        this.preguntas = preguntas;
    }

    public void crearPreguntas(String descripcionPregunta, String descripcionOpcion1, String descripcionOpcion2, String descripcionOpcion3,
                               String descripcionOpcion4, Boolean correcto1, Boolean correcto2,
                               Boolean correcto3, Boolean correcto4){
        Pregunta pregunta=new Pregunta(descripcionPregunta);
        pregunta.crearOpcionesDePreguntas(descripcionOpcion1, correcto1);
        pregunta.crearOpcionesDePreguntas(descripcionOpcion2, correcto2);
        pregunta.crearOpcionesDePreguntas(descripcionOpcion3, correcto3);
        pregunta.crearOpcionesDePreguntas(descripcionOpcion4, correcto4);
        preguntas.add(pregunta);

    }
    public Pregunta elegirPregunta() {
        Pregunta preguntaElegida = preguntas.get(new Random().nextInt(preguntas.size()));
        return preguntaElegida;
    }

    public String validarCantidadDePreguntas() {
            if (preguntas.size() < 5) {
                return "Hacen falta "+ (5-preguntas.size())+" preguntas para la categoria "+nivel;
            }
            return "";
    }

    @Override
    public String toString() {
        return "nivel= " + nivel +
                " pregunta= " + preguntas;
    }
}
