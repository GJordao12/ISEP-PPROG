package pt.ipp.isep.dei.esoft.pot.controller.console;

import pt.ipp.isep.dei.esoft.autorizacao.AutorizacaoFacade;
import pt.ipp.isep.dei.esoft.autorizacao.model.SessaoUtilizador;
import pt.ipp.isep.dei.esoft.pot.model.Constantes;
import pt.ipp.isep.dei.esoft.pot.model.Plataforma;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Aplicação POT.
 *
 * @author paulomaio
 */
public class AplicacaoPOT {

    // Inspirado em https://www.javaworld.com/article/2073352/core-java/core-java-simply-singleton.html?page=2
    private static AplicacaoPOT singleton = null;
    private final Plataforma m_oPlataforma;
    private final AutorizacaoFacade m_oAutorizacao;

    private AplicacaoPOT() {
        Properties props = getProperties();
        this.m_oPlataforma = new Plataforma(props.getProperty(Constantes.PARAMS_PLATAFORMA_DESIGNACAO));
        this.m_oAutorizacao = this.m_oPlataforma.getAutorizacaoFacade();
        bootstrap();
    }

    /**
     * Devolve a instância.
     *
     * @return instância
     */
    public static AplicacaoPOT getInstance() {
        if (singleton == null) {
            synchronized (AplicacaoPOT.class) {
                singleton = new AplicacaoPOT();
            }
        }
        return singleton;
    }

    /**
     * Devolve a plataforma.
     *
     * @return plataforma
     */
    public Plataforma getPlataforma() {
        return this.m_oPlataforma;
    }

    /**
     * Devolve a Sessão Atual.
     *
     * @return Sessão Atual
     */
    public SessaoUtilizador getSessaoAtual() {
        return this.m_oAutorizacao.getSessaoAtual();
    }

    /**
     * Efetua login boolean.
     *
     * @param strId  id
     * @param strPwd password
     * @return boolean
     */
    public boolean doLogin(String strId, String strPwd) {
        return this.m_oAutorizacao.doLogin(strId, strPwd) != null;
    }

    /**
     * Efetua logout.
     */
    public void doLogout() {
        this.m_oAutorizacao.doLogout();
    }

    /**
     * Devolve as Propriedades.
     *
     * @return propriedade
     */
    private Properties getProperties() {
        Properties props = new Properties();

        // Adiciona propriedades e valores por omissão
        props.setProperty(Constantes.PARAMS_PLATAFORMA_DESIGNACAO, "Task for Joe");


        // Lê as propriedades e valores definidas
        try {
            InputStream in = new FileInputStream(Constantes.PARAMS_FICHEIRO);
            props.load(in);
            in.close();
        } catch (IOException ignored) {

        }
        return props;
    }

    /**
     * Bootstrap.
     */
    private void bootstrap() {
        this.m_oAutorizacao.registaPapelUtilizador(Constantes.PAPEL_ADMINISTRATIVO);
        this.m_oAutorizacao.registaPapelUtilizador(Constantes.PAPEL_FREELANCER);
        this.m_oAutorizacao.registaPapelUtilizador(Constantes.PAPEL_GESTOR_ORGANIZACAO);
        this.m_oAutorizacao.registaPapelUtilizador(Constantes.PAPEL_COLABORADOR_ORGANIZACAO);
    }


}
