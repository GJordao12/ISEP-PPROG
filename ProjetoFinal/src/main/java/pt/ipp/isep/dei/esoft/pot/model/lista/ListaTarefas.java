package pt.ipp.isep.dei.esoft.pot.model.lista;

import pt.ipp.isep.dei.esoft.pot.model.Categoria;
import pt.ipp.isep.dei.esoft.pot.model.Colaborador;
import pt.ipp.isep.dei.esoft.pot.model.Tarefa;

import java.util.ArrayList;
import java.util.List;

/**
 * Lista de Tarefas.
 *
 * @author Jordão e António
 */
public class ListaTarefas {

    private List<Tarefa> m_lstTarefas;

    /**
     * Instancia uma nova Lista de tarefas.
     */
    public ListaTarefas() {
        this.m_lstTarefas = new ArrayList<>();
    }

    /**
     * Constrói uma nova tarefa através do construtor da classe Tarefa.
     *
     * @param strRefUnica     referência única
     * @param strDesig        designação
     * @param strDescInformal descrição informal
     * @param strCaracTecnico carácter técnico
     * @param strDuracao      duração
     * @param strCusto        custo
     * @param oCatTarefa      categoria de tarefa
     * @return tarefa
     */
    public Tarefa novaTarefa(String strRefUnica, String strDesig, String strDescInformal, String strCaracTecnico, String strDuracao, String strCusto, Categoria oCatTarefa) {

        return new Tarefa(strRefUnica, strDesig, strDescInformal, strCaracTecnico, strDuracao, strCusto, oCatTarefa);
    }

    /**
     * Regista a tarefa.
     *
     * @param oTarefa tarefa
     * @return boolean
     */
    public boolean registaTarefa(Tarefa oTarefa) {

        if (this.validaTarefa(oTarefa)) {
            return addTarefa(oTarefa);
        }
        return false;
    }

    private boolean addTarefa(Tarefa oTarefa) {

        return this.m_lstTarefas.add(oTarefa);
    }

    /**
     * Valida a tarefa.
     *
     * @param oTarefa tarefa
     * @return boolean
     */
    public boolean validaTarefa(Tarefa oTarefa) {

        boolean bRet = true;
        if (this.m_lstTarefas.contains(oTarefa))
            bRet = false;

        return bRet;
    }

    /**
     * Devolve a lista de tarefas que sejam para publicar.
     *
     * @param c colaborador
     * @return tarefas para publicar
     */
    public List<Tarefa> getTarefasParaPublicar(Colaborador c) {
        List<Tarefa> lst = new ArrayList<>();
        for (Tarefa tar : this.m_lstTarefas) {
            if (tar.getColab().equals(c)) {
                lst.add(tar);
            }
        }
        return lst;
    }

    /**
     * Devolve as tarefas para publicar através da referência.
     *
     * @param ref referencia
     * @param c   colaborador
     * @return tarefas para publicar
     */
    public Tarefa getTarefasParaPublicarByRef(String ref, Colaborador c) {
        List<Tarefa> lst = getTarefasParaPublicar(c);
        for (Tarefa tar : lst) {
            if (tar.getM_strReferenciaUnica().equals(ref)) {
                return tar;
            }
        }
        return null;
    }
}

