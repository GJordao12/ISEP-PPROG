/**
 * @author Jordão
 */
public class Quadro implements Comparable<Quadro> {

    /**
     * Designação do Quadro por omissão.
     */
    public static final String DESIGNACAO_POR_OMISSAO = "sem designação";
    /**
     * Nome do Autor do Quadro por omissão.
     */
    public static final String NOME_DO_AUTOR = "sem autor";
    /**
     * Ano de Criação do Quadro por omissão.
     */
    public static final int ANO_DE_CRIACAO_POR_OMISSAO = 0;
    /**
     * Designação do Quadro.
     */
    private String designacao;
    /**
     * Nome do Autor do Quadro.
     */
    private String nomeAutor;
    /**
     * Ano de Criação do Quadro.
     */
    private int anoDeCriacao;

    public Quadro(String designacao, String nomeAutor, int anoDeCriacao) {
        this.designacao = designacao;
        this.nomeAutor = nomeAutor;
        this.anoDeCriacao = anoDeCriacao;
    }

    public Quadro() {
        this.designacao = DESIGNACAO_POR_OMISSAO;
        this.nomeAutor = NOME_DO_AUTOR;
        this.anoDeCriacao = ANO_DE_CRIACAO_POR_OMISSAO;
    }

    public String getDesignacao() {
        return designacao;
    }

    public void setDesignacao(String designacao) {
        this.designacao = designacao;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }

    public int getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public void setAnoDeCriacao(int anoDeCriacao) {
        this.anoDeCriacao = anoDeCriacao;
    }

    @Override
    public String toString() {
        return "Quadro:\n\n" + "Designação: " + designacao + '\n' + "Nome do Autor: " + nomeAutor + '\n' + "Ano de criação: " + anoDeCriacao + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof Quadro) {
            if (((Quadro) obj).designacao.equalsIgnoreCase(this.designacao) && this.anoDeCriacao == ((Quadro) obj).anoDeCriacao && this.nomeAutor.equalsIgnoreCase(((Quadro) obj).nomeAutor)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Quadro o) {
        if (this.nomeAutor.compareToIgnoreCase(o.nomeAutor) < 0) {
            return 1;
        }
        return -1;
    }
}
