package pt.ipp.isep.dei.esoft.pot.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Candidatura.
 *
 * @author Jordão e António
 */
public class Candidatura {

    private Double valorPretendido;
    private Freelancer freelancer;
    private Date data;
    private int nrDias;
    private String txtApres;
    private String txtMotiv;


    /**
     * Instancia uma nova Candidatura.
     *
     * @param free            freelancer
     * @param valorPretendido valor pretendido
     * @param data            data
     * @param nrDias          número de dias
     * @param txtApres        texto apresentativo
     * @param txtMotiv        texto motivacional
     */
    public Candidatura(Freelancer free, Double valorPretendido, Date data, int nrDias, String txtApres, String txtMotiv) {
        if (free == null || valorPretendido == null || data == null || txtApres == null || txtMotiv == null || txtApres.isEmpty() || txtMotiv.isEmpty())
            throw new IllegalArgumentException("Nenhum dos parâmetros pode ser nulo.");

        this.freelancer = free;
        this.valorPretendido = valorPretendido;
        this.data = data;
        this.nrDias = nrDias;
        this.txtApres = txtApres;
        this.txtMotiv = txtMotiv;
    }

    /**
     * Devolve o freelancer.
     *
     * @return freelancer
     */
    public Freelancer getFreelancer() {
        return this.freelancer;
    }

    /**
     * Devolve o valor pretendido pela candidatura.
     *
     * @return valor pretendido
     */
    public double getValorPretendido() {
        return this.valorPretendido;
    }

    /**
     * Devolve a data da Candidatura.
     *
     * @return data
     */
    public Date getData() {
        return this.data;
    }

    /**
     * Devolve a descrição textual da Candidatura do Freelancer.
     *
     * @return descrição textual
     */
    @Override
    public String toString() {
        return String.format("Freelancer: %s - Valor Pretendido: %.2f POTs - Data: %s - Número de Dias: %d - Texto Apresentativo: %s - Texto Motivacional: %s", this.freelancer.getM_oNome(), this.valorPretendido, this.data, this.nrDias, this.txtApres, this.txtMotiv);
    }

    /**
     * Calcular média.
     *
     * @param c    colaborador
     * @param anun anuncio
     * @return média
     */
    public double calcularMedia(Candidatura c, Anuncio anun) {
        double media = 0;
        int qtdGP = 0;
        List<CompetenciaTecnica> ctListDaTarefa = this.getListaAuxiliar(anun);
        for (ReconhecimentoCompetenciaTecnica rct : c.getFreelancer().getM_lstReconhecimentoCT()) {
            if (ctListDaTarefa.contains(rct.getM_oCT())) {
                media = rct.getM_oGP().getM_intValor() + media;
                qtdGP++;
            }
        }
        return media / qtdGP;
    }

    /**
     * Calcular desvio padrão.
     *
     * @param c    colaborador
     * @param anun anuncio
     * @return desvio padrão
     */
    public double calcularDesvioPadrao(Candidatura c, Anuncio anun) {
        double media = this.calcularMedia(c, anun);
        double desvio = 0;
        List<CompetenciaTecnica> ctListDaTarefa = this.getListaAuxiliar(anun);
        int tamanho = 0;
        for (ReconhecimentoCompetenciaTecnica rct : c.getFreelancer().getM_lstReconhecimentoCT()) {
            if (ctListDaTarefa.contains(rct.getM_oCT())) {
                double intermedio = rct.getM_oGP().getM_intValor() - media;
                desvio += Math.pow(intermedio, 2);
                tamanho++;
            }
        }
        return Math.sqrt(desvio / (tamanho));
    }

    /**
     * Devolve a lista auxiliar.
     *
     * @param anun anúncio
     * @return lista Auxiliar
     */
    public List<CompetenciaTecnica> getListaAuxiliar(Anuncio anun) {
        List<CompetenciaTecnica> ctListDaTarefa = new ArrayList<>();
        for (CaraterCT ct : anun.getTarefa().getM_oCategoriaTarefa().getM_lstCct()) {
            ctListDaTarefa.add(ct.getCt());
        }
        return ctListDaTarefa;
    }
}
