package proyecto.reto_tecnicosofka.models;

public class Opcion {

    private String descripcionOpcion;
    private boolean correcta;

    public Opcion() {
    }

    public Opcion(String descripcionOpcion, boolean correcta) {
        this.descripcionOpcion = descripcionOpcion;
        this.correcta = correcta;
    }

    public String getDescripcionOpcion() {
        return descripcionOpcion;
    }

    public void setDescripcionOpcion(String descripcionOpcion) {
        this.descripcionOpcion = descripcionOpcion;
    }

    public boolean isCorrecta() {
        return correcta;
    }

    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }

    @Override
    public String toString() {
        return "despcionOpcion=" + descripcionOpcion +
                " correcta=" + correcta;
    }
}
