package pt.ipp.isep.dei.esoft.pot.model.lista;

import pt.ipp.isep.dei.esoft.pot.model.Colaborador;

import java.util.ArrayList;
import java.util.List;

/**
 * Lista de colaboradores.
 *
 * @author Jordão e António
 */
public class ListaColaboradores {

    private List<Colaborador> m_lstListaColaboradores;

    /**
     * Instancia uma nova Lista de Colaboradores.
     */
    public ListaColaboradores() {
        this.m_lstListaColaboradores = new ArrayList<>();
    }

    /**
     * Devolve o colaborador através do email.
     *
     * @param email email
     * @return colaborador by email
     */
    public Colaborador getColaboradorByEmail(String email) {

        for (Colaborador colab : this.m_lstListaColaboradores) {
            if (colab.getEmail().equals(email)) {
                return colab;
            }
        }
        return null;
    }

    /**
     * Adiciona à lista um colaborador.
     *
     * @param oColaborador colaborador
     */
    public void addColaborador(Colaborador oColaborador) {
        this.m_lstListaColaboradores.add(oColaborador);
    }

    /**
     * Devolve a lista de colaboradores.
     *
     * @return colaboradores
     */
    public List<Colaborador> getColaboradores() {
        return this.m_lstListaColaboradores;
    }
}
