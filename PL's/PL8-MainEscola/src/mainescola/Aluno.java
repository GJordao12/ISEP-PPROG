package mainescola;

/**
 * @author Jordão
 */
public class Aluno {

    private static final String NOME_POR_OMISSAO = "sem nome";
    private static final int ID_POR_OMISSAO = 0;
    private static final int NMECANOGRAFICO_POR_OMISSAO = 0;
    private String nome;
    private int id;
    private int NMecagonografico;

    public Aluno(String nome, int id, int NMecagonografico) {
        this.nome = nome;
        this.id = id;
        this.NMecagonografico = NMecagonografico;
    }

    public Aluno() {
        nome = NOME_POR_OMISSAO;
        id = ID_POR_OMISSAO;
        NMecagonografico = NMECANOGRAFICO_POR_OMISSAO;
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

    public int getNMecagonografico() {
        return NMecagonografico;
    }

    public void setNMecagonografico(int NMecagonografico) {
        this.NMecagonografico = NMecagonografico;
    }

    @Override
    public String toString() {
        return String.format("Nome: %s Id: %d", nome, id);
    }
}
