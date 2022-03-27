package proyecto.reto_tecnicosofka.models;

public class Opcion {

    private String despcionOpcion;
    private boolean correcta;

    public Opcion() {
    }

    public Opcion(String despcionOpcion, boolean correcta) {
        this.despcionOpcion = despcionOpcion;
        this.correcta = correcta;
    }

    public String getDespcionOpcion() {
        return despcionOpcion;
    }

    public void setDespcionOpcion(String despcionOpcion) {
        this.despcionOpcion = despcionOpcion;
    }

    public boolean isCorrecta() {
        return correcta;
    }

    public void setCorrecta(boolean correcta) {
        this.correcta = correcta;
    }

    @Override
    public String toString() {
        return "despcionOpcion=" + despcionOpcion +
                " correcta=" + correcta;
    }
}
