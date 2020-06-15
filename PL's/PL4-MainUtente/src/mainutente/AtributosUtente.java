package mainutente;

/**
 * @author Jordão
 */
public class AtributosUtente {

    private static final String NOME_POR_OMISSAO = "Sem Nome";
    private static final String GENERO_POR_OMISSAO = "Sem Genéro";
    private static final int IDADE_POR_OMISSAO = 0;
    private static final double PESO_POR_OMISSAO = 0;
    private static final double ALTURA_POR_OMISSAO = 0;
    private int TotalUtentes = 0;
    private String nome;
    private String genero;
    private int idade;
    private double peso;
    private double altura;

    public AtributosUtente() {
        idade = IDADE_POR_OMISSAO;
        peso = PESO_POR_OMISSAO;
        altura = ALTURA_POR_OMISSAO;
        nome = NOME_POR_OMISSAO;
        genero = GENERO_POR_OMISSAO;
        TotalUtentes++;

    }

    public AtributosUtente(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
        TotalUtentes++;
    }

    public AtributosUtente(String nome, String genero, int idade, double peso, double altura) {
        this.nome = nome;
        this.genero = genero;
        this.idade = idade;
        this.peso = peso;
        this.altura = altura;
        TotalUtentes++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    public String toString() {
        return ("O Utente " + nome + " do género " + genero + " tem " + idade + " anos, mede " + altura + "m e pesa " + peso + "kg!");
    }

    public int calcularDiferencaIdades(AtributosUtente AtributosOutroUtente) {
        return Math.abs(idade - AtributosOutroUtente.idade);
    }

    public double calcularIMC() {
        return (peso / (Math.pow(altura, 2)));
    }

    public String calcularGrauDeObesidade() {

        if (calcularIMC() < 18) {
            return String.format("Magro(IMC=%.2f)", calcularIMC());
        } else {
            if (calcularIMC() <= 25) {
                return String.format("Saudável(IMC=%.2f)", calcularIMC());
            } else {
                if (calcularIMC() > 25) {
                    return String.format("Obeso(IMC=%.2f)", calcularIMC());
                } else {
                    return "Indefenido";
                }
            }
        }
    }

    public int isMaisNovo(AtributosUtente AtributosOutroUtente) {
        int idade1 = idade;
        int idade2 = AtributosOutroUtente.idade;

        return (idade1 - idade2);
    }

    public int TotalUtentes() {
        return TotalUtentes;
    }

}
