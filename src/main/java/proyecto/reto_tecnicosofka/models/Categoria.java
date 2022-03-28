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

    public void crearPreguntas(String descripcionPregunta){
        preguntas.add(new Pregunta(descripcionPregunta));
    }
    public Pregunta elegirPregunta() {
        Pregunta preguntaElegida = preguntas.get(new Random().nextInt(preguntas.size()));
        return preguntaElegida;
    }

    @Override
    public String toString() {
        return "nivel= " + nivel +
                " pregunta= " + preguntas;
    }
}
