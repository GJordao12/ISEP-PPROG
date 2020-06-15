package pt.ipp.isep.dei.esoft.leitura;

import pt.ipp.isep.dei.esoft.pot.controller.console.AplicacaoPOT;
import pt.ipp.isep.dei.esoft.pot.model.Anuncio;
import pt.ipp.isep.dei.esoft.pot.model.Candidatura;
import pt.ipp.isep.dei.esoft.pot.model.Freelancer;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;
import pt.ipp.isep.dei.esoft.pot.model.lista.ListaCandidaturas;
import pt.ipp.isep.dei.esoft.pot.model.registo.RegistoAnuncios;
import pt.ipp.isep.dei.esoft.pot.model.registo.RegistoFreelancer;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Leitura de Candidaturas através de um ficheiro.
 *
 * @author Jordão e António
 */
public class LeituraCandidaturas {

    private Plataforma m_oPlataforma;
    private RegistoFreelancer rfree;
    private RegistoAnuncios ranu;
    private Anuncio anu;
    private Freelancer free;
    private Candidatura cand;
    private ListaCandidaturas m_LstCandidaturas;

    /**
     * Instancia uma nova Leitura de Candidaturas.
     */
    public LeituraCandidaturas() {
        this.m_oPlataforma = AplicacaoPOT.getInstance().getPlataforma();
        this.rfree = this.m_oPlataforma.getRegistoFreelancer();
        this.ranu = this.m_oPlataforma.getRegistoAnuncios();
    }

    /**
     * Lê o ficheiro.
     */
    public void run() {

        try {
            File dadosCandidatura = new File("Ficheiros\\Candidaturas.txt");
            Scanner sc = new Scanner(dadosCandidatura);
            sc.nextLine();
            sc.nextLine();
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String[] dados = linha.split(";");
                String anuncioId = dados[0].trim();
                Date dataCand = new SimpleDateFormat("dd-MM-yyyy").parse(dados[1].trim());
                double valorPrt = Double.parseDouble(dados[2].trim());
                int nDias = Integer.parseInt(dados[3].trim());
                String txtApres = dados[4].trim();
                String txtMotiv = dados[5].trim();
                String strEmailUtilizador = dados[6].trim();
                this.free = this.rfree.getFreelancerByEmail(strEmailUtilizador);
                this.anu = this.ranu.getAnuncioById(anuncioId);
                this.m_LstCandidaturas = this.anu.getM_oListaCandidaturas();
                this.cand = this.anu.novaCandidatura(this.free, dataCand, valorPrt, nDias, txtApres, txtMotiv);
                if (this.m_LstCandidaturas.validaCandidatura(this.cand)) {
                    this.m_LstCandidaturas.registaCandidatura(this.cand);
                } else {
                    this.cand = null;
                }
            }
            sc.close();
        } catch (FileNotFoundException fne) {
            System.out.println("Ficheiro de Candidaturas não encontrado!");
        } catch (NullPointerException npe) {
            System.out.println("Falha de informação precisa no Registo de Candidaturas!");
        } catch (ParseException pe) {
            System.out.println("Erro no formato das datas no ficheiro Candidaturas!");
        }
    }
}
