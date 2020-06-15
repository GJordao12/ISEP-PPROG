package pt.ipp.isep.dei.esoft.leitura;

import pt.ipp.isep.dei.esoft.pot.controller.console.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;
import pt.ipp.isep.dei.esoft.pot.model.CompetenciaTecnica;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.model.registo.RegistoAreasAtividade;
import pt.ipp.isep.dei.esoft.pot.model.registo.RegistoCompetenciasTecnicas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Leitura de Competências Técnicas através de um ficheiro.
 *
 * @author Jordão e António
 */
public class LeituraCompetenciasTecnicas {

    private Plataforma m_oPlataforma;
    private RegistoAreasAtividade m_oRegistoAreasAtividade;
    private RegistoCompetenciasTecnicas m_oRegistoCompetenciasTecnicas;
    private CompetenciaTecnica m_oCompetencia;

    /**
     * Instancia uma nova Leitura de Competências Técnicas.
     */
    public LeituraCompetenciasTecnicas() {
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
        this.m_oRegistoAreasAtividade = this.m_oPlataforma.getRegistoAreaAtividade();
        this.m_oRegistoCompetenciasTecnicas = this.m_oPlataforma.getRegistoCT();
    }

    /**
     * Lê o ficheiro.
     */
    public void run() {

        try {
            File dadosCT = new File("Ficheiros\\Competencias Tecnicas.txt");
            Scanner sc = new Scanner(dadosCT);
            sc.nextLine();
            sc.nextLine();

            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] dados = linha.split(";");
                String strCodigo = dados[0].trim();
                String strDescricaoBreve = dados[1].trim();
                String strDescricaoDetalhada = dados[2].trim();
                String strATCod = dados[3].trim();
                AreaAtividade area = this.m_oRegistoAreasAtividade.getAreaAtividadeByCod(strATCod);
                this.m_oCompetencia = this.m_oRegistoCompetenciasTecnicas.novaCompetenciaTecnica(strCodigo, strDescricaoBreve, strDescricaoDetalhada, area);
                if (this.m_oRegistoCompetenciasTecnicas.validaCompetenciaTecnica(this.m_oCompetencia)) {
                    for (int i = 4; i < dados.length; i++) {
                        int valor = Integer.parseInt(dados[i].trim());
                        i++;
                        String designacao = dados[i].trim();
                        this.m_oCompetencia.addGrauProficiencia(valor, designacao);
                    }
                    this.m_oRegistoCompetenciasTecnicas.registaCompetenciaTecnica(this.m_oCompetencia);
                } else {
                    this.m_oCompetencia = null;
                }
            }
            sc.close();
        } catch (FileNotFoundException fne) {
            System.out.println("Ficheiro de Competências Técnicas não encontrado!");
        } catch (NullPointerException npe) {
            System.out.println("Falha de informação precisa no Registo de Competências Técnicas!");
        }
    }
}
