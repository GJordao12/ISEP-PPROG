package maincontador;

/**
 * @author Jordão
 */
public abstract class Contador {

    private String id;
    private String cliente;
    private int consumo;

    public Contador(String id, String cliente, int consumo) {
        this.id = id;
        this.cliente = cliente;
        this.consumo = consumo;
    }

    public String getId() {
        return this.id;
    }

    public String getCliente() {
        return this.cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public int getConsumo() {
        return consumo;
    }

    public void setConsumo(int consumo) {
        this.consumo = consumo;
    }

    @Override
    public String toString() {
        return String.format("Contador: %s Dono: %s", this.getId(), this.getCliente());
    }

    public abstract double calcularCusto();
}
