package pt.ipp.isep.dei.esoft.pot.model;

import pt.ipp.isep.dei.esoft.pot.model.lista.ListaCandidaturas;

import java.util.Date;

/**
 * Anúncio.
 *
 * @author Jordão e António
 */
public class Anuncio {

    private Colaborador c;
    private Tarefa tarefa;
    private Date dtIniP;
    private Date dtFimP;
    private Date dtIniC;
    private Date dtFimC;
    private Date dtIniS;
    private Date dtFimS;
    private Regimento regT;
    private String srtId;
    private ListaCandidaturas m_oListaCandidaturas;
    private ProcessoSeriacao ps;

    /**
     * Instancia um novo Anuncio.
     *
     * @param c      colaborador
     * @param tarefa tarefa
     * @param dtIniP data inicial publicação
     * @param dtFimP data final publicação
     * @param dtIniC data inicial candidaturas
     * @param dtFimC data final candidaturas
     * @param dtIniS data inicial seriação
     * @param dtFimS data final seriação
     * @param regT   tipo regimento
     */
    public Anuncio(Colaborador c, Tarefa tarefa, Date dtIniP, Date dtFimP, Date dtIniC, Date dtFimC, Date dtIniS, Date dtFimS, Regimento regT) {
        if ((c == null) || (tarefa == null) || (dtIniP == null) || (dtFimP == null) || (dtIniC == null) || (dtFimC == null) || (dtIniS == null) || (dtFimS == null) || (regT == null))
            throw new IllegalArgumentException("Nenhum dos argumentos pode ser nulo ou vazio.");

        this.c = c;
        this.tarefa = tarefa;
        this.dtIniP = dtIniP;
        this.dtFimP = dtFimP;
        this.dtIniC = dtIniC;
        this.dtFimC = dtFimC;
        this.dtIniS = dtIniS;
        this.dtFimS = dtFimS;
        this.regT = regT;

        this.m_oListaCandidaturas = new ListaCandidaturas();
    }

    /**
     * Devolve o colaborador.
     *
     * @return colaborador
     */
    public Colaborador getC() {
        return this.c;
    }

    /**
     * Modifica o id.
     *
     * @param id id
     */
    public void setStrId(String id) {
        this.srtId = id;
    }

    /**
     * Devolve o ID.
     *
     * @return id
     */
    public String getSrtId() {
        return this.srtId;
    }

    /**
     * Devolve um tipo de regimento.
     *
     * @return tipo regimento
     */
    public Regimento getRegT() {
        return this.regT;
    }

    /**
     * Devolve a tarefa.
     *
     * @return tarefa
     */
    public Tarefa getTarefa() {
        return this.tarefa;
    }

    /**
     * Devolve a lista de candidaturas.
     *
     * @return lista candidaturas
     */
    public ListaCandidaturas getM_oListaCandidaturas() {
        return this.m_oListaCandidaturas;
    }

    /**
     * Cria um novo processo de seriação através do construtor da classe ProcessoSeriacao.
     *
     * @param colab colaborador
     * @return processo seriação
     */
    public ProcessoSeriacao novoProcessoSeriacao(Colaborador colab) {
        return new ProcessoSeriacao(this.getRegT(), colab);
    }

    /**
     * Aceita as candidaturas.
     *
     * @return boolean
     */
    public boolean aceitaCandidaturas() {
        Date dataAtual = new Date();
        return dataAtual.before(this.dtFimC);
    }

    /**
     * Verifica se o freelancer é elegível.
     *
     * @param free freelancer
     * @return boolean
     */
    public boolean eFreelancerElegivel(Freelancer free) {
        for (CaraterCT ct : this.getTarefa().getM_oCategoriaTarefa().getM_lstCct()) {
            if (!VerificarCaraterCT(free, ct)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Verifica o Caráter da Competência Técnica.
     *
     * @param free freelancer
     * @param ct   competência técnica
     * @return boolean
     */
    private boolean VerificarCaraterCT(Freelancer free, CaraterCT ct) {
        for (ReconhecimentoCompetenciaTecnica rct : free.getM_lstReconhecimentoCT()) {
            if (rct.getM_oCT().equals(ct.getCt())) {
                return (rct.getM_oGP().getM_intValor() >= ct.getGp().getM_intValor());
            }
        }
        return true;
    }

    /**
     * Cria uma nova candidatura.
     *
     * @param free     freelancer
     * @param dataCand data candidatura
     * @param valorPrt valor pretendido
     * @param nDias    número de dias
     * @param txtApres texto apresentativo
     * @param txtMotiv texto motivacional
     * @return candidatura
     */
    public Candidatura novaCandidatura(Freelancer free, Date dataCand, double valorPrt, int nDias, String txtApres, String txtMotiv) {
        if (aceitaCandidaturas()) {
            if (eFreelancerElegivel(free)) {
                return this.m_oListaCandidaturas.novaCandidatura(free, dataCand, valorPrt, nDias, txtApres, txtMotiv);
            }
        }
        return null;
    }

    /**
     * Devolve a descrição textual da tarefa.
     *
     * @return String
     */
    @Override
    public String toString() {
        return String.format("Tarefa: Designação: %s , Custo: %s POTs , Duração da Execução: %s dias - Anúncio: Tipo de Regimento: %s , Data inicial de publicitação: %s , Data final de publicitação: %s , Data inicial de apresentação de candidaturas: %s , Data final de apresentação de candidaturas: %s , Data inicial de seriação: %s , Data final de seriação: %s - Colaborador: %s", this.tarefa.getM_strDesignacao(), this.tarefa.getM_strCustoTarefa(), this.tarefa.getM_strDuracaoExecucao(), this.regT.getM_strDesignacao(), this.dtIniP, this.dtFimP, this.dtIniC, this.dtFimC, this.dtIniS, this.dtFimS, this.c.getNome());
    }

    /**
     * Regista o processo de seriação.
     *
     * @param ps Processo de Seriação
     * @return boolean
     */
    public boolean registaProcessoSeriacao(ProcessoSeriacao ps) {
        setProcessoSeriacao(ps);
        return true;
    }

    /**
     * Modifica o Processo de Seriação.
     *
     * @param ps processo de seriação
     */
    private void setProcessoSeriacao(ProcessoSeriacao ps) {
        this.ps = ps;
    }
}
