import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

/**
 * @author Jordão
 */
public class Exposicao implements Comparable<Exposicao> {

    /**
     * Designação da Exposição.
     */
    private String designacao;

    /**
     * Ano de Realização da Exposição.
     */
    private int anoDeRealizacao;

    /**
     * Lista de Quadros da Exposição.
     */
    private ArrayList<Quadro> listaDeQuadros = new ArrayList<>();

    public Exposicao(String designacao, int anoDeRealizacao, ArrayList<Quadro> listaDeQuadros) {
        this.designacao = designacao;
        this.anoDeRealizacao = anoDeRealizacao;
        this.listaDeQuadros = listaDeQuadros;
    }

    public Exposicao(String designacao, int anoDeRealizacao, Quadro... quadros) {
        this.designacao = designacao;
        this.anoDeRealizacao = anoDeRealizacao;
        Collections.addAll(this.listaDeQuadros, quadros);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Exposicao)) return false;
        Exposicao exposicao = (Exposicao) o;
        return anoDeRealizacao == exposicao.anoDeRealizacao &&
                designacao.equals(exposicao.designacao) &&
                Objects.equals(listaDeQuadros, exposicao.listaDeQuadros);
    }

    public boolean addQuadro(Quadro q) {
        return this.listaDeQuadros.add(q);
    }

    public boolean removeQuadro(Quadro q) {
        return this.listaDeQuadros.remove(q);
    }

    @Override
    public String toString() {
        this.listaDeQuadros.sort((o1, o2) -> {
            if (o1.getNomeAutor().compareToIgnoreCase(o2.getNomeAutor()) < 0) {
                return -1;
            }
            if (o1.getNomeAutor().compareToIgnoreCase(o2.getNomeAutor()) > 0) {
                return 1;
            }
            return 0;
        });
        StringBuilder str = new StringBuilder();
        str.append("Lista de Quadros na Exposição ").append(this.designacao).append(" realizada em ").append(this.anoDeRealizacao).append(":\n");
        for (Quadro q : this.listaDeQuadros) {
            str.append(q.toString()).append("\n");
        }
        return str.toString();
    }

    @Override
    public int compareTo(Exposicao o) {
        return Integer.compare(o.anoDeRealizacao, this.anoDeRealizacao);
    }
}