package pt.ipp.isep.dei.esoft.pot.model;

import java.util.Objects;

/**
 * Tarefa.
 *
 * @author Jordão e António
 */
public class Tarefa {

    private String m_strReferenciaUnica;
    private String m_strDesignacao;
    private String m_strDescricaoInformal;
    private String m_strCaracterTecnico;
    private String m_strDuracaoExecucao;
    private String m_strCustoTarefa;
    private Categoria m_oCategoriaTarefa;
    private Colaborador colab;

    /**
     * Instancia uma nova Tarefa.
     *
     * @param strReferenciaUnica   referencia única
     * @param strDesignacao        designação
     * @param strDescricaoInformal descrição informal
     * @param strCaracterTecnico   carácter técnico
     * @param strDuracaoExecucao   duração execução
     * @param strCustoTarefa       custo tarefa
     * @param oCatTarefa           categoria tarefa
     */
    public Tarefa(String strReferenciaUnica, String strDesignacao, String strDescricaoInformal,
                  String strCaracterTecnico, String strDuracaoExecucao, String strCustoTarefa, Categoria oCatTarefa) {

        if ((strReferenciaUnica == null) || (strDesignacao == null) || (strDescricaoInformal == null) ||
                (strCaracterTecnico == null) || (strDuracaoExecucao == null) || (strCustoTarefa == null) || (oCatTarefa == null) ||
                (strReferenciaUnica.isEmpty()) || (strDesignacao.isEmpty()) || (strDescricaoInformal.isEmpty()) ||
                (strCaracterTecnico.isEmpty()) || (strDuracaoExecucao.isEmpty()) || (strCustoTarefa.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");

        this.m_strReferenciaUnica = strReferenciaUnica;
        this.m_strDesignacao = strDesignacao;
        this.m_strDescricaoInformal = strDescricaoInformal;
        this.m_strCaracterTecnico = strCaracterTecnico;
        this.m_strDuracaoExecucao = strDuracaoExecucao;
        this.m_strCustoTarefa = strCustoTarefa;
        this.m_oCategoriaTarefa = oCatTarefa;
    }

    /**
     * Verifica se tem ID.
     *
     * @param strId id
     * @return boolean
     */
    public boolean hasId(String strId) {
        return this.m_strReferenciaUnica.equalsIgnoreCase(strId);
    }

    /**
     * Hash code.
     *
     * @return hash
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strReferenciaUnica);
        return hash;
    }

    /**
     * Verifica se dois objetos são iguais.
     *
     * @param o objeto
     * @return boolean
     */
    @Override
    public boolean equals(Object o) {
        // Inspirado em https://www.sitepoint.com/implement-javas-equals-method-correctly/

        // self check
        if (this == o)
            return true;
        // null check
        if (o == null)
            return false;
        // type check and cast
        if (getClass() != o.getClass())
            return false;
        // field comparison
        Tarefa obj = (Tarefa) o;
        return (Objects.equals(m_strReferenciaUnica, obj.m_strReferenciaUnica));
    }

    /**
     * Devolve a designação da tarefa.
     *
     * @return designação da tarefa
     */
    public String getM_strDesignacao() {
        return this.m_strDesignacao;
    }

    /**
     * Devolve o colaborador da tarefa.
     *
     * @return colaborador da tarefa
     */
    public Colaborador getColab() {
        return this.colab;
    }

    /**
     * Modifica o colaborador da tarefa.
     *
     * @param colab colaborador da tarefa
     */
    public void setColab(Colaborador colab) {
        this.colab = colab;
    }

    /**
     * Devolve a Categoria de Tarefa.
     *
     * @return categoria tarefa
     */
    public Categoria getM_oCategoriaTarefa() {
        return this.m_oCategoriaTarefa;
    }

    /**
     * Devolve a referência única da tarefa.
     *
     * @return referencia única
     */
    public String getM_strReferenciaUnica() {
        return this.m_strReferenciaUnica;
    }

    /**
     * Devolve o custo de tarefa da tarefa.
     *
     * @return custo tarefa da tarefa
     */
    public String getM_strCustoTarefa() {
        return this.m_strCustoTarefa;
    }

    /**
     * Devolve a Duração de Execução da tarefa.
     *
     * @return duração execução
     */
    public String getM_strDuracaoExecucao() {
        return this.m_strDuracaoExecucao;
    }

    /**
     * Devolve a descrição textual da tarefa.
     *
     * @return descrição textual
     */
    @Override
    public String toString() {
        return String.format("Referência Única: %s , Designação: %s , Descrição Informal: %s , Carácter Técnico: %s , Duração Execução: %s , Custo: %s POTs - Categoria: %s", this.m_strReferenciaUnica, this.m_strDesignacao, this.m_strDescricaoInformal, this.m_strCaracterTecnico, this.m_strDuracaoExecucao, this.m_strCustoTarefa, this.m_oCategoriaTarefa.toString());
    }
}
