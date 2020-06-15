package pt.ipp.isep.dei.esoft.pot.model;

import java.util.List;

/**
 * Seriação 2.
 *
 * @author Jordão e António
 */
public class Seriacao2 extends Regimento {

    /**
     * Instancia uma nova Seriação 2.
     *
     * @param m_strDesignacao      designação
     * @param m_strDescricaoRegras descrição regras
     */
    public Seriacao2(String m_strDesignacao, String m_strDescricaoRegras) {
        super(m_strDesignacao, m_strDescricaoRegras);
    }

    /**
     * Seria um determinado anúncio, tendo em conta a maior média dos graus de proficiência, menor desvio padrão,
     * menor valor pretendido e data mais antiga da candidatura.
     *
     * @param anun anuncio
     * @return lista candidaturas
     */
    @Override
    public List<Candidatura> Seriar(Anuncio anun) {
        List<Candidatura> lstCand = anun.getM_oListaCandidaturas().getCandidaturas();
        lstCand.sort((c1, c2) -> {
            int cmp = Double.compare(c2.calcularMedia(c2, anun), c1.calcularMedia(c1, anun));
            if (cmp == 0) {
                cmp = Double.compare(c1.calcularDesvioPadrao(c1, anun), c2.calcularDesvioPadrao(c2, anun));
                if (cmp == 0) {
                    cmp = Double.compare(c1.getValorPretendido(), c2.getValorPretendido());
                    if (cmp == 0) {
                        cmp = c1.getData().compareTo(c2.getData());
                    }
                }
            }
            return cmp;
        });
        return lstCand;
    }
}
