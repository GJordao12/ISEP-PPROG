package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Categoria.
 *
 * @author Jordão e António
 */
public class Categoria {

    private AreaAtividade o_AT;
    private String m_strId;
    private String m_strDescricao;
    private List<CaraterCT> m_lstCct;

    /**
     * Instancia uma nova Categoria.
     *
     * @param strId        id
     * @param strDescricao descrição
     * @param o_AT         area atividade
     */
    public Categoria(String strId, String strDescricao, AreaAtividade o_AT) {

        if ((strId == null) || (strDescricao == null) || (o_AT == null) ||
                (strId.isEmpty()) || (strDescricao.isEmpty()))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");

        this.m_strId = strId;
        this.m_strDescricao = strDescricao;
        this.o_AT = o_AT;
        this.m_lstCct = new ArrayList<>();
    }

    /**
     * Verifica se tem ID.
     *
     * @param strId id
     * @return boolean
     */
    public boolean hasId(String strId) {
        return this.m_strId.equalsIgnoreCase(strId);
    }

    /**
     * Devolve o ID.
     *
     * @return id
     */
    public String getId() {
        return this.m_strId;
    }

    /**
     * Hash code.
     *
     * @return hash
     */
    @Override
    public int hashCode() {

        int hash = 7;
        hash = 23 * hash + Objects.hashCode(this.m_strId);
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
        Categoria obj = (Categoria) o;
        return (Objects.equals(m_strId, obj.m_strId));
    }

    /**
     * Devolve a lista de caráter de competência técnica.
     *
     * @return carácter competência técnica
     */
    public List<CaraterCT> getM_lstCct() {
        return this.m_lstCct;
    }

    /**
     * Devolve a descrição textual da Categoria.
     *
     * @return descrição textual
     */
    @Override
    public String toString() {
        return String.format("ID: %s , Descrição: %s ", this.m_strId, this.m_strDescricao);
    }

    /**
     * Cria um novo Caráter de Competência Técnica através do construtor da classe CaraterCT.
     *
     * @param m_oCompetenciaTecnica competência técnica
     * @param gp                    grau proficiência
     * @param obg                   obrigatoriedade
     * @return caráter competência técnica
     */
    public CaraterCT novoCaracterCT(CompetenciaTecnica m_oCompetenciaTecnica, GrauProficiencia gp, boolean obg) {
        return new CaraterCT(m_oCompetenciaTecnica, gp, obg);
    }

    /**
     * Regista o caráter da competência técnica.
     *
     * @param cCt caráter competência técnica
     * @return boolean
     */
    public boolean registaCaracterCT(CaraterCT cCt) {
        if (this.validaCaraterCT(cCt)) {
            return addCaraterCT(cCt);
        }
        return false;
    }

    /**
     * Valida o caráter da competência técnica recebido por parâmetro.
     *
     * @param o_CTT caráter da competência técnica
     * @return boolean
     */
    public boolean validaCaraterCT(CaraterCT o_CTT) {
        boolean bRet = true;

        if (this.m_lstCct.contains(o_CTT)) {
            bRet = false;
        }

        return bRet;
    }

    /**
     * Adiciona à lista de caráter das competências técnicas um CCT recebido por parâmetro.
     *
     * @param cCt caráter competência técnica
     * @return boolean
     */
    private boolean addCaraterCT(CaraterCT cCt) {
        return this.m_lstCct.add(cCt);
    }
}

