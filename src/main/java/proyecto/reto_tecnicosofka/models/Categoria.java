package proyecto.reto_tecnicosofka.models;

public class Categoria {

    private Pregunta pregunta;

    public Categoria() {
    }

    public Pregunta getPregunta() {
        return pregunta;
    }

    public void setPregunta(Pregunta pregunta) {
        this.pregunta = pregunta;
    }

    @Override
    public String toString() {
        return "pregunta= " + pregunta;
    }
}
