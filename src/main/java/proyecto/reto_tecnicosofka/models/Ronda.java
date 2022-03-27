package proyecto.reto_tecnicosofka.models;

public class Ronda {

    private Categoria categoria;
    private Premio premio;

    public Ronda() {
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

    @Override
    public String toString() {
        return "categoria= " + categoria +
                " premio= " + premio;
    }
}
