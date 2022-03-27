package proyecto.reto_tecnicosofka.models;

public class Premio {

    private int cantPuntos;

    public Premio() {
    }

    public Premio(int cantPuntos) {
        this.cantPuntos = cantPuntos;
    }

    public int getCantPuntos() {
        return cantPuntos;
    }

    public void setCantPuntos(int cantPuntos) {
        this.cantPuntos = cantPuntos;
    }

    @Override
    public String toString() {
        return "cantPuntos= " + cantPuntos;
    }
}
