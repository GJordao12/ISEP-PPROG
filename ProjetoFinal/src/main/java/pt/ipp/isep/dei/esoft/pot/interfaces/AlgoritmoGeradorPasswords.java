package pt.ipp.isep.dei.esoft.pot.interfaces;

/**
 * Interface do Algoritmo Gerador de Passwords.
 *
 * @author Jordão e António
 */
public interface AlgoritmoGeradorPasswords {

    /**
     * Gera password.
     *
     * @param strNomeGestor  nome gestor
     * @param strEmailGestor email gestor
     * @return string
     */
    String geraPassword(String strNomeGestor, String strEmailGestor);
}
