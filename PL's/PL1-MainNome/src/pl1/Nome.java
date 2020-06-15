package pl1;

/**
 * @author Jordão
 */
public class Nome {
    private static final String NOME_POR_OMISSAO = "sem nome";
    private static final int IDADE_POR_OMISSAO = 0;
    private String nome;
    private int idade;

    public Nome() {
        nome = NOME_POR_OMISSAO;
        idade = IDADE_POR_OMISSAO;
    }

    public Nome(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String toString() {
        return ("O seu nome é " + nome + " e tem " + idade + " anos!");
    }
}
