package proyecto.reto_tecnicosofka.models;

import java.util.Random;
import java.util.Scanner;

public class Ronda {

    private Categoria categoria;
    private Premio premio;

    public Ronda() {
    }

    public Ronda(int nivelCategoria, int cantidadPremio) {

        this.categoria=new Categoria(nivelCategoria);
        this.premio=new Premio(cantidadPremio);
    }


    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Premio getPremio() {
        return premio;
    }

    public void setPremio(Premio premio) {
        this.premio = premio;
    }

    public boolean preguntarPermanencia(){
        System.out.println("Desea continuar y responder la siguiente pregunta?");
        Scanner sc = new Scanner(System.in);
        boolean consulta = true;

        if (sc.equals("si")) {
            consulta = true;
        }
        if (sc.equals("no")){
            consulta = false;
        }
        return consulta;
    }

    @Override
    public String toString() {
        return " categoria= " + categoria +
                " premio= " + premio;
    }
}
