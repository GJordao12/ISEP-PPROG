package pt.ipp.isep.dei.esoft.autorizacao.model;

import java.util.HashSet;
import java.util.Set;

/**
 * Registo Papeis Utilizador.
 *
 * @author paulomaio
 */
public class RegistoPapeisUtilizador {
    private Set<PapelUtilizador> m_lstPapeis = new HashSet<>();

    /**
     * Novo papel utilizador.
     *
     * @param strPapel papel
     * @return papel utilizador
     */
    public PapelUtilizador novoPapelUtilizador(String strPapel) {
        return new PapelUtilizador(strPapel);
    }

    /**
     * Adiciona um papel à lista de papeis.
     *
     * @param papel papel
     * @return boolean
     */
    public boolean addPapel(PapelUtilizador papel) {
        if (papel != null)
            return this.m_lstPapeis.add(papel);
        return false;
    }

    /**
     * Procura um determinado papel de um utilizador.
     *
     * @param strPapel papel
     * @return papel utilizador
     */
    public PapelUtilizador procuraPapel(String strPapel) {
        for (PapelUtilizador p : this.m_lstPapeis) {
            if (p.hasId(strPapel))
                return p;
        }
        return null;
    }
}
