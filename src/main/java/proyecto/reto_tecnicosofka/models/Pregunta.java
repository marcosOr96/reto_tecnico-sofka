package proyecto.reto_tecnicosofka.models;

import java.util.List;

public class Pregunta {

    private String descripcionPregunta;
    private List<Opcion> opciones;

    public Pregunta() {
    }

    public Pregunta(String descripcionPregunta) {
        this.descripcionPregunta = descripcionPregunta;
    }

    public String getDescripcion() {
        return descripcionPregunta;
    }

    public void setDescripcion(String descripcionPregunta) {
        this.descripcionPregunta = descripcionPregunta;
    }

    public List<Opcion> getOpciones() {
        return opciones;
    }

    public void setOpciones(List<Opcion> opciones) {
        this.opciones = opciones;
    }

    @Override
    public String toString() {
        return "descripcion= " + descripcionPregunta +
                " opciones= " + opciones;
    }
}
