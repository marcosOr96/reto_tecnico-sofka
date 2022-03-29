package proyecto.reto_tecnicosofka.models;

public class Jugador {

    private String nombre;
    private int edad;
    private int premioAcomulado;
    private Ronda ronda;

    public Jugador() {
    }

    public Jugador(String nombre, int edad, int premioAcomulado) {
        this.nombre = nombre;
        this.edad = edad;
        this.premioAcomulado = premioAcomulado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public int getPremioAcomulado() {
        return premioAcomulado;
    }

    public void setPremioAcomulado(int premioAcomulado) {
        this.premioAcomulado = premioAcomulado;
    }

    public Ronda getRonda() {
        return ronda;
    }

    public void setRonda(Ronda ronda) {
        this.ronda = ronda;
    }

    public void asignarRonda(Ronda ronda){
        this.ronda = ronda;
    }

    @Override
    public String toString() {
        return "nombre: " + nombre + ", " +
                " edad: " + edad + ", " +
                " premioAcomulado: " + premioAcomulado + ", " +
                " ronda " + ronda;
    }
}
