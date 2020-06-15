package mainescola;

/**
 * @author Jordão
 */
public class ProfessorAssistente extends Professor {

    private float ValorDeMajoracao = 1f;

    public ProfessorAssistente(String nome, int id, float ValorDeMajoracao) {
        super(nome, id);
    }

    public float getValorDeMajoracao() {
        return ValorDeMajoracao;
    }

    public void setValorDeMajoracao(float ValorDeMajoracao) {
        this.ValorDeMajoracao = ValorDeMajoracao;
    }

    @Override
    public String toString() {
        return String.format("%s Categoria: Assistente", super.toString());
    }

    @Override
    public float calcularSalario() {
        return (super.getSalarioBase() * ValorDeMajoracao);
    }
}
