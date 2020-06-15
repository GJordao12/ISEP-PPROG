package pt.ipp.isep.dei.esoft.leitura;

/**
 * Inicializa a Leitura de todos os Ficheiros.
 *
 * @author Jordão e António
 */
public class StartLeituraFicheiros {

    public void run() {

        LeituraOrganizacoes uiOrg = new LeituraOrganizacoes();
        LeituraAreasAtividade uiArea = new LeituraAreasAtividade();
        LeituraCompetenciasTecnicas uiCT = new LeituraCompetenciasTecnicas();
        LeituraCategorias uiCat = new LeituraCategorias();
        LeituraTarefas uiTar = new LeituraTarefas();
        LeituraRegimentos uiReg = new LeituraRegimentos();
        LeituraAnuncios uiPubTar = new LeituraAnuncios();
        LeituraFreelancers uiFree = new LeituraFreelancers();
        LeituraCandidaturas uiCand = new LeituraCandidaturas();

        uiOrg.run();
        uiArea.run();
        uiCT.run();
        uiCat.run();
        uiTar.run();
        uiReg.run();
        uiPubTar.run();
        uiFree.run();
        uiCand.run();
    }
}
