/**
 * @author Jordão
 */
public class Reformado extends Impostos {

    /**
     * Os outro rendimentos por omissão do utilizador.
     */
    public static final float OR_POR_OMISSAO = 0;
    /**
     * Os rendimentos de trabalho por omissão do utilizador.
     */
    public static final float RT_POR_OMISSAO = 0;
    /**
     * Taxa sobre os outros rendimentos do utilizador;
     */
    public static float taxa_OR = 0.03f;
    /**
     * Taxa sobre os rendimentos de trabalho do utilizador;
     */
    public static float taxa_RT = 0.01f;
    /**
     * Os outros rendimentos do utilizador.
     */
    public float OR;
    /**
     * Os rendimentos de trabalho do utilizador.
     */
    public float RT;

    /**
     * Constrói uma instância de Reformado recebendo como parâmetro o nome, a
     * morada, os outros rendimentos os rendimentos de trabalho do utilizador.
     *
     * @param nome   nome do utilizador
     * @param morada morada do utilizador
     * @param OR     outros rendimentos do utilizador
     * @param RT     rendimentos de trabalho do utilizador
     */
    public Reformado(String nome, String morada, float RT, float OR) {
        super(nome, morada);
        this.RT = RT;
        this.OR = OR;
    }

    /**
     * Constrói uma instância de Reformado recebendo como parâmetro o nome, a
     * morada e colocando como zero os outros rendimentos e os rendimentos de
     * trabalho do utilizador.
     *
     * @param nome   nome
     * @param morada morada
     */
    public Reformado(String nome, String morada) {
        super(nome, morada);
        OR = OR_POR_OMISSAO;
        RT = RT_POR_OMISSAO;
    }

    /**
     * Constrói uma instância de Reformado colocando o nome,a morada, os outros
     * rendimentos e os rendimentos de trabalho por omissão;
     */
    public Reformado() {
        super();
        OR = OR_POR_OMISSAO;
        RT = RT_POR_OMISSAO;
    }

    /**
     * Devolve a taxa aplicada sobre os outros rendimentos do utilizador.
     *
     * @return taxa aplicada sobre outros rendimentos
     */
    public static float getTAXA_OR() {
        return taxa_OR;
    }

    /**
     * Modifica o valor da taxa aplicada sobre os outros rendimentos do
     * utilizador.
     *
     * @param taxa_OR Taxa OR
     */
    public static void setTAXA_OR(float taxa_OR) {
        Reformado.taxa_OR = taxa_OR;
    }

    /**
     * Devolve a taxa aplicada sobre os rendimentos de trabalho do utilizador.
     *
     * @return taxa aplicada sobre rendimentos de trabalho
     */
    public static float getTAXA_RT() {
        return taxa_RT;
    }

    /**
     * Modifica o valor da taxa aplicada sobre os rendimentos de trabalho do
     * utilizador.
     *
     * @param taxa_RT Taxa RT
     */
    public static void setTAXA_RT(float taxa_RT) {
        Reformado.taxa_RT = taxa_RT;
    }

    /**
     * Devolve os outros rendimentos do utilizador.
     *
     * @return outros rendimentos do utilizador.
     */
    public float getOR() {
        return OR;
    }

    /**
     * Modifica os outros rendimentos do utilizador.
     *
     * @param OR outros rendimentos do utilizador.
     */
    public void setOR(float OR) {
        this.OR = OR;
    }

    /**
     * Devolve rendimentos de trabalho do utilizador.
     *
     * @return rendimentos de trabalho do utilizador.
     */
    public float getRT() {
        return RT;
    }

    /**
     * Modifica os outros rendimentos do utilizador.
     *
     * @param RT rendimentos de trabalho do utilizador.
     */
    public void setRT(float RT) {
        this.RT = RT;
    }

    @Override
    public String toString() {
        return String.format("##Reformado##%n %s Outros Rendimentos: %.2f€%n Rendimentos de Trabalho: %.2f€", super.toString(), OR, RT);
    }

    @Override
    public float CalcularImpostos() {
        return (OR * taxa_OR) + (RT * taxa_RT);
    }

    //6. Reescreva o método equals nas classes da hierarquia de contribuintes.
    @Override
    public boolean equals(Object outroObjeto) {
        if (this == outroObjeto) {
            return true;
        }
        if (outroObjeto == null || this.getClass() != outroObjeto.getClass()) {
            return false;
        }
        Reformado outraPessoas = (Reformado) outroObjeto;
        return super.getNome().equalsIgnoreCase(outraPessoas.getNome()) && super.getMorada().equalsIgnoreCase(outraPessoas.getMorada()) && this.RT == outraPessoas.RT && this.OR == outraPessoas.OR;
    }
}
