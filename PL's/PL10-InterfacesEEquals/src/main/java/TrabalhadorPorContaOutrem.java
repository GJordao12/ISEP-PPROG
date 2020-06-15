/**
 * @author Jordão
 */
public class TrabalhadorPorContaOutrem extends Impostos {

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
    public static float taxa_OR = 0.02f;
    /**
     * Taxa sobre os rendimentos de trabalho se forem menores ou igual a 30000€
     * do utilizador;
     */
    public static float taxa_RT1 = 0.01f;
    /**
     * Taxa sobre os rendimentos de trabalho se maiores a 30000€ do utilizador;
     */
    public static float taxa_RT2 = 0.02f;
    /**
     * Os outros rendimentos do utilizador.
     */
    public float OR;
    /**
     * Os rendimentos de trabalho do utilizador.
     */
    public float RT;

    /**
     * Constrói uma instância de TrabalhadorPorContaOutrem recebendo como
     * parâmetro o nome, a morada, os outros rendimentos os rendimentos de
     * trabalho do utilizador.
     *
     * @param nome   nome do utilizador
     * @param morada morada do utilizador
     * @param OR     outros rendimentos do utilizador
     * @param RT     rendimentos de trabalho do utilizador
     */
    public TrabalhadorPorContaOutrem(String nome, String morada, float RT, float OR) {
        super(nome, morada);
        this.RT = RT;
        this.OR = OR;
    }

    /**
     * Constrói uma instância de TrabalhadorPorContaOutrem recebendo como
     * parâmetro o nome, a morada e colocando como zero os outros rendimentos e
     * os rendimentos de trabalho do utilizador.
     *
     * @param nome   nome
     * @param morada morada
     */
    public TrabalhadorPorContaOutrem(String nome, String morada) {
        super(nome, morada);
        OR = OR_POR_OMISSAO;
        RT = RT_POR_OMISSAO;
    }

    /**
     * Constrói uma instância de TrabalhadorPorContaOutrem colocando o nome,a
     * morada, os outros rendimentos e os rendimentos de trabalho por omissão;
     */
    public TrabalhadorPorContaOutrem() {
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
     * @param taxa_OR taxa OR
     */
    public static void setTAXA_OR(float taxa_OR) {
        TrabalhadorPorContaOutrem.taxa_OR = taxa_OR;
    }

    /**
     * Devolve a taxa aplicada sobre os rendimentos de trabalho do utilizador.
     *
     * @return taxa aplicada sobre rendimentos de trabalho
     */
    public static float getTAXA_RT() {
        return taxa_RT1;
    }

    /**
     * Modifica o valor da taxa aplicada sobre os rendimentos de trabalho do
     * utilizador.
     *
     * @param taxa_RT1 taxa RT1
     */
    public static void setTAXA_RT(float taxa_RT1) {
        TrabalhadorPorContaOutrem.taxa_RT1 = taxa_RT1;
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
        return String.format("##Trabalhador Por Conta  de Outrem##%n %s Outros Rendimentos: %.2f€%n Rendimentos de Trabalho: %.2f€ ", super.toString(), OR, RT);
    }

    @Override
    public float CalcularImpostos() {
        if (RT <= 30000) {
            return (OR * taxa_OR) + (RT * taxa_RT1);
        } else {
            return (OR * taxa_OR) + (RT * taxa_RT2);
        }
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
        TrabalhadorPorContaOutrem outraPessoas = (TrabalhadorPorContaOutrem) outroObjeto;
        return super.getNome().equalsIgnoreCase(outraPessoas.getNome()) && super.getMorada().equalsIgnoreCase(outraPessoas.getMorada()) && this.RT == outraPessoas.RT && this.OR == outraPessoas.OR;
    }
}
