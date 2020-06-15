package mainescola;

/**
 * @author Jordão
 */
public abstract class Professor {

    private static final String NOME_POR_OMISSAO = "sem nome";
    private static final int ID_POR_OMISSAO = 0;
    private static int SalarioBase = 1500;
    private String nome;
    private int id;

    public Professor(String nome, int id) {
        this.nome = nome;
        this.id = id;
    }

    public Professor() {
        nome = NOME_POR_OMISSAO;
        id = ID_POR_OMISSAO;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalarioBase() {
        return SalarioBase;
    }

    public void setSalarioBase(int SalarioBase) {
        this.SalarioBase = SalarioBase;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s Id: %d", nome, id);
    }

    public abstract float calcularSalario();

}
