package proyecto.reto_tecnicosofka.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Pregunta {

    private String descripcionPregunta;
    private List<Opcion> opciones;

    public Pregunta() {
        this.opciones = new ArrayList<>();
    }

    public Pregunta(String descripcionPregunta) {
        this.descripcionPregunta = descripcionPregunta;
    }

    public String getDescripcionPregunta() {
        return descripcionPregunta;
    }

    public void setDescripcionPregunta(String descripcionPregunta) {
        this.descripcionPregunta = descripcionPregunta;
    }

    public List<Opcion> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<Opcion> opciones) {
        this.opciones = opciones;
    }

    public void crearOpcionesDePreguntas(String descripcionOpcion,boolean correcta){
        this.opciones.add(new Opcion(descripcionOpcion,correcta));
    }

    public boolean elegirRespuesta(){
        Opcion opcionElegida = opciones.get(new Random().nextInt());
        return opcionElegida.isCorrecta();
    }

    @Override
    public String toString() {
        return "descripcion= " + descripcionPregunta +
                " opciones= " + opciones;
    }
}
