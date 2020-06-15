package pt.ipp.isep.dei.esoft.leitura;

import pt.ipp.isep.dei.esoft.pot.controller.console.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.model.*;
import pt.ipp.isep.dei.esoft.pot.model.registo.RegistoCompetenciasTecnicas;
import pt.ipp.isep.dei.esoft.pot.model.registo.RegistoFreelancer;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Leitura de Freelancers através de um ficheiro.
 *
 * @author Jordão e António
 */
public class LeituraFreelancers {

    private Plataforma m_oPlataforma;
    private RegistoFreelancer rf;
    private Freelancer m_oFreelancer;
    private RegistoCompetenciasTecnicas rcts;
    private ReconhecimentoCompetenciaTecnica m_oReconhecimentoCT;

    /**
     * Instancia uma nova Leitura de Freelancers.
     */
    public LeituraFreelancers() {
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
        this.rf = m_oPlataforma.getRegistoFreelancer();
        this.rcts = this.m_oPlataforma.getRegistoCT();
    }

    /**
     * Lê o ficheiro.
     */
    public void run() {

        try {
            File dadosFreelancer = new File("Ficheiros\\Freelancers.txt");
            Scanner sc = new Scanner(dadosFreelancer);
            sc.nextLine();
            sc.nextLine();
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] dados_Da_Freelancer = linha.split(";");
                String nome = dados_Da_Freelancer[0].trim();
                int nif = Integer.parseInt(dados_Da_Freelancer[1].trim());
                EnderecoPostal endPostal = new EnderecoPostal(dados_Da_Freelancer[2].trim(), dados_Da_Freelancer[3].trim(), dados_Da_Freelancer[4].trim());
                int tele = Integer.parseInt(dados_Da_Freelancer[5].trim());
                String email = dados_Da_Freelancer[6].trim();
                this.m_oFreelancer = this.rf.novoFreelancer(nome, nif, endPostal, tele, email);
                if (this.rf.validaFreelancer(this.m_oFreelancer)) {
                    for (int i = 7; i < dados_Da_Freelancer.length; i++) {
                        String codCT = dados_Da_Freelancer[i].trim();
                        i++;
                        int valorGP = Integer.parseInt(dados_Da_Freelancer[i].trim());
                        i++;
                        Date data = new SimpleDateFormat("dd-MM-yyyy").parse(dados_Da_Freelancer[i].trim());
                        CompetenciaTecnica ct = this.rcts.getCompetenciaTecnicaById(codCT);
                        GrauProficiencia gp = ct.getGrauProficienciaByValor(valorGP);
                        this.m_oReconhecimentoCT = this.m_oFreelancer.novaReconhecimentoCT(data, ct, gp);
                    }
                    this.rf.registaFreelancer(this.m_oFreelancer);
                } else {
                    this.m_oFreelancer = null;
                }
            }
            sc.close();
        } catch (FileNotFoundException fne) {
            System.out.println("Ficheiro de Freelancers não encontrado!");
        } catch (NullPointerException npe) {
            System.out.println("Falha de informação precisa no Registo de Freelancers!");
        } catch (ParseException pe) {
            System.out.println("Erro no formato das datas no ficheiro Freelancers!");
        }
    }
}
