package pt.ipp.isep.dei.esoft.pot.model;

/**
 * Caráter Competência Técnica.
 *
 * @author Jordão e António
 */
public class CaraterCT {

    private boolean obrigatoria;
    private CompetenciaTecnica ct;
    private GrauProficiencia gp;

    /**
     * Instancia um novo Caráter de uma Competência Técnica.
     *
     * @param ct competência técnica
     * @param gp grau de proficiência
     * @param ob obrigatório
     */
    public CaraterCT(CompetenciaTecnica ct, GrauProficiencia gp, boolean ob) {
        if ((ct == null) || (gp == null))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");

        this.ct = ct;
        this.gp = gp;
        this.obrigatoria = ob;
    }

    /**
     * Devolve a competência técnica.
     *
     * @return competência técnica
     */
    public CompetenciaTecnica getCt() {
        return this.ct;
    }

    /**
     * Devolve o grau de proficiência.
     *
     * @return grau de proficiência
     */
    public GrauProficiencia getGp() {
        return this.gp;
    }

    /**
     * Devolve a descrição textual da Competência Técnica.
     *
     * @return descrição textual
     */
    @Override
    public String toString() {
        return String.format("Competência Técnica: %s , Grau Proficiência: %s , Obrigatoriedade: %s" + this.obrigatoria, this.ct, this.gp);
    }
}
