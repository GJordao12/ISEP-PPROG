package pt.ipp.isep.dei.esoft.leitura;

import pt.ipp.isep.dei.esoft.pot.controller.console.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.model.Categoria;
import pt.ipp.isep.dei.esoft.pot.model.Organizacao;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.model.Tarefa;
import pt.ipp.isep.dei.esoft.pot.model.lista.ListaTarefas;
import pt.ipp.isep.dei.esoft.pot.model.registo.RegistoCategorias;
import pt.ipp.isep.dei.esoft.pot.model.registo.RegistoOrganizacoes;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Leitura de Tarefas através de um ficheiro.
 *
 * @author Jordão e António
 */
public class LeituraTarefas {

    private RegistoOrganizacoes rorgs;
    private Plataforma m_oPlataforma;
    private Tarefa m_oTarefa;
    private RegistoCategorias m_oRegistoCategorias;
    private ListaTarefas lt;

    /**
     * Instancia uma nova Leitura de Tarefas.
     */
    public LeituraTarefas() {
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
        this.m_oRegistoCategorias = this.m_oPlataforma.getRegistoCategorias();
        this.rorgs = this.m_oPlataforma.getRegistoOrganizacoes();
    }

    /**
     * Lê o ficheiro.
     */
    public void run() {

        try {
            File dadosTarefa = new File("Ficheiros\\Tarefas.txt");
            Scanner sc = new Scanner(dadosTarefa);
            sc.nextLine();
            sc.nextLine();
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] dados = linha.split(";");
                String strReferenciaUnica = dados[0].trim();
                String strDesignacao = dados[1].trim();
                String strDescricaoInformal = dados[2].trim();
                String strCaracterTecnico = dados[3].trim();
                String strDuracaoExecucao = dados[4].trim();
                String strCustoTarefa = dados[5].trim();
                String srtCatId = dados[6].trim();
                String strEmailUtilizador = dados[7].trim();
                Categoria catTarefa = this.m_oRegistoCategorias.getCategoriaById(srtCatId);
                Organizacao org = this.rorgs.getOrganizacaoByEmailUtilizador(strEmailUtilizador);
                this.lt = org.getListaTarefas();
                this.m_oTarefa = this.lt.novaTarefa(strReferenciaUnica, strDesignacao, strDescricaoInformal, strCaracterTecnico, strDuracaoExecucao, strCustoTarefa, catTarefa);
                if (this.lt.validaTarefa(this.m_oTarefa)) {
                    this.lt.registaTarefa(this.m_oTarefa);
                    this.m_oTarefa.setColab(org.getColaboradorByEmailUtilizador(strEmailUtilizador));
                } else {
                    this.m_oTarefa = null;
                }
            }
            sc.close();
        } catch (FileNotFoundException fne) {
            System.out.println("Ficheiro de Tarefas não encontrado!");
        } catch (NullPointerException npe) {
            System.out.println("Falha de informação precisa no Registo deTarefas!");
        }
    }
}
