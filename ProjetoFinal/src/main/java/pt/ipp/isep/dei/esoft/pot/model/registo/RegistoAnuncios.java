package pt.ipp.isep.dei.esoft.pot.model.registo;

import pt.ipp.isep.dei.esoft.pot.model.Anuncio;
import pt.ipp.isep.dei.esoft.pot.model.Colaborador;
import pt.ipp.isep.dei.esoft.pot.model.Regimento;
import pt.ipp.isep.dei.esoft.pot.model.Tarefa;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Registo de Anúncios.
 *
 * @author Jordão e António
 */
public class RegistoAnuncios {

    private List<Anuncio> m_lstAnuncios;

    /**
     * Instancia um novo Registo de Anúncios.
     */
    public RegistoAnuncios() {
        this.m_lstAnuncios = new ArrayList<>();
    }

    /**
     * Constrói um novo Anúncio através do construtor da classe Anúncio.
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
     * @return anuncio
     */
    public Anuncio novoAnuncio(Colaborador c, Tarefa tarefa, Date dtIniP, Date dtFimP, Date dtIniC, Date dtFimC, Date dtIniS, Date dtFimS, Regimento regT) {
        return new Anuncio(c, tarefa, dtIniP, dtFimP, dtIniC, dtFimC, dtIniS, dtFimS, regT);
    }

    /**
     * Regista um anuncio recebido por parâmetro.
     *
     * @param m_oAnuncio anuncio
     * @return boolean
     */
    public boolean registaAnuncio(Anuncio m_oAnuncio) {

        if (this.validaAnuncio(m_oAnuncio)) {
            return addAnuncio(m_oAnuncio);
        }
        return false;
    }

    /**
     * Adiciona um Anúncio recebido por parâmetro à lista de Anúncios.
     *
     * @param m_oAnuncio anuncio
     * @return boolean
     */
    private boolean addAnuncio(Anuncio m_oAnuncio) {

        return this.m_lstAnuncios.add(m_oAnuncio);
    }

    /**
     * Valida um anúncio recebido por parâmetro.
     *
     * @param m_oAnuncio anuncio
     * @return boolean
     */
    public boolean validaAnuncio(Anuncio m_oAnuncio) {

        boolean bRet = true;
        if (this.m_lstAnuncios.contains(m_oAnuncio))
            bRet = false;

        return bRet;
    }

    /**
     * Devolve os anúncios para seriar automáticos.
     *
     * @param colab colaborador
     * @return anúncios para seriar automáticos
     */
    public List<Anuncio> getAnunciosParaSeriarAutomaticos(Colaborador colab) {
        List<Anuncio> lst = new ArrayList<>();
        for (Anuncio anun : this.m_lstAnuncios) {
            if (anun.getC().equals(colab)) {
                lst.add(anun);
            }
        }
        return lst;
    }


    /**
     * Devolve um anúncio através do ID.
     *
     * @param id id
     * @return anúncio
     */
    public Anuncio getAnuncioById(String id) {
        for (Anuncio anun : this.m_lstAnuncios) {
            if (anun.getSrtId().equals(id)) {
                return anun;
            }
        }
        return null;
    }

    /**
     * Devolve um anúncio através do ID e do colaborador.
     *
     * @param id id
     * @param c  colaborador
     * @return anúncio
     */
    public Anuncio getAnuncioByIdEColab(String id, Colaborador c) {

        List<Anuncio> lst = this.getAnunciosParaSeriarAutomaticos(c);
        for (Anuncio anun : lst) {
            if (anun.getSrtId().equals(id)) {
                return anun;
            }
        }
        return null;
    }
}

