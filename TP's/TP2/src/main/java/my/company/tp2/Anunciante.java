package my.company.tp2;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jordão
 */
public class Anunciante {

    /**
     * Nome do Anunciante por omissão.
     */
    private static final String NOME_POR_OMISSAO = "sem nome";
    /**
     * Limite de artigos para venda do Anunciante.
     */
    private static int limiteVenda = 2;
    /**
     * Limite de artigos para aluguer do Anunciante.
     */
    private static int limiteAlugar = 3;
    /**
     * Nome do Anunciante.
     */
    private String nome;
    /**
     * Endereço do Anunciante.
     */
    private Endereco endereco;
    /**
     * Lista de artigos para vender do Anunciante.
     */
    private List<Vendivel> artigosAVender;
    /**
     * Lista de artigos para aluguer do Anunciante.
     */
    private List<Alugavel> artigosAAlugar;

    /**
     * Constrói uma instância para o Anunciante, recebendo como parâmetro o nome
     * do Anunciante, Endereço, Lista de artigos para vender e Lista de artigos
     * para aluguer.
     *
     * @param nome           Nome do Anunciante
     * @param endereco       Endereço do Anunciante
     * @param artigosAVender Lista de artigos para vender do Anunciante
     * @param artigosAAlugar Lista de artigos para aluguer do Anunciante
     */
    public Anunciante(String nome, Endereco endereco, List<Vendivel> artigosAVender, List<Alugavel> artigosAAlugar) {
        this.nome = nome;
        this.endereco = new Endereco(endereco.getNomeRua(), endereco.getCodPostal(), endereco.getLocalidade());
        if (artigosAVender.size() <= limiteVenda) {
            this.artigosAVender = new ArrayList<>(artigosAVender);
        } else {
            this.artigosAVender = new ArrayList<>();
        }
        if (artigosAAlugar.size() <= limiteAlugar) {
            this.artigosAAlugar = new ArrayList<>(artigosAAlugar);
        } else {
            this.artigosAAlugar = new ArrayList<>();
        }
    }

    /**
     * Constrói uma instância para o Anunciante atribuindo o Nome do Anunciante, o Endereço do anunciante,
     * a Lista de artigos para vender do Anunciante e a Lista de artigos para aluguer do Anunciante por omissão.
     */
    public Anunciante() {
        this.nome = NOME_POR_OMISSAO;
        this.endereco = new Endereco();
        this.artigosAVender = new ArrayList<Vendivel>();
        this.artigosAAlugar = new ArrayList<Alugavel>();
    }

    /**
     * Modifica Limite de artigos para venda do Anunciante.
     *
     * @param limiteDeArtigosAVenda Limite de artigos para venda
     */
    public static void setLimiteDeArtigosAVenda(int limiteDeArtigosAVenda) {
        Anunciante.limiteVenda = limiteDeArtigosAVenda;
    }

    /**
     * Modifica o Limite de artigos para aluguer do Anunciante.
     *
     * @param limiteDeArtigosAAlugar Limite de artigos para aluguer
     */
    public static void setLimiteDArtigosAAlugar(int limiteDeArtigosAAlugar) {
        Anunciante.limiteAlugar = limiteDeArtigosAAlugar;
    }

    /**
     * Devolve o Nome do Anunciante.
     *
     * @return Nome do Anunciante
     */
    public String getNome() {
        return nome;
    }

    /**
     * Modifica o Nome do Anunciante.
     *
     * @param nome Nome do Anunciante
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Devolve o Endereço do Anunciante.
     *
     * @return Endereço do Anunciante
     */
    public Endereco getEndereco() {
        return endereco;
    }

    /**
     * Modifica o Endereço do Anunciante.
     *
     * @param endereco Endereço do Anunciante
     */
    public void setEndereco(Endereco endereco) {
        this.endereco = new Endereco(endereco.getNomeRua(), endereco.getCodPostal(), endereco.getLocalidade());
    }

    /**
     * Devolve a Lista de artigos para vender do Anunciante.
     *
     * @return Lista de artigos para vender
     */
    public List<Vendivel> getArtigosAVender() {
        return artigosAVender;
    }

    /**
     * Modifica a Lista de artigos para vender do Anunciante.
     *
     * @param artigosAVender Lista de artigos para vender
     */
    public void setArtigosAVender(List<Vendivel> artigosAVender) {
        this.artigosAVender = new ArrayList<Vendivel>(artigosAVender);
    }

    /**
     * Devolve a Lista de artigos para aluguer do Anunciante.
     *
     * @return Lista de artigos para aluguer
     */
    public List<Alugavel> getArtigosAAlugar() {
        return artigosAAlugar;
    }

    /**
     * Modifica a Lista de artigos para aluguer do Anunciante.
     *
     * @param artigosAAlugar Lista de artigos para aluguer
     */
    public void setArtigosAAlugar(List<Alugavel> artigosAAlugar) {
        this.artigosAAlugar = new ArrayList<Alugavel>(artigosAAlugar);
    }

    /**
     * Devolve o Número de artigos para aluguer do Anunciante.
     *
     * @return Número de artigos para aluguer
     */
    public int getNumeroDeArtigosAAlugar() {
        return this.artigosAAlugar.size();
    }

    /**
     * Devolve o Número de artigos para venda do Anunciante.
     *
     * @return Número de artigos para venda
     */
    public int getNumeroDeArtigosAVender() {
        return this.artigosAVender.size();
    }

    /**
     * Adiciona um Artigo para Aluguer à lista de Aluguer do Anunciante.
     *
     * @param a Artigo para Aluguer
     * @return boolean
     */
    public boolean adicionarAlugavel(Alugavel a) {
        if (this.artigosAAlugar.size() < limiteAlugar) {
            return this.artigosAAlugar.add(a);
        }
        return false;
    }

    /**
     * Adiciona um Artigo para Vender à lista de Aluguer do Anunciante.
     *
     * @param v Artigo para Vender
     * @return boolean
     */
    public boolean adicionarVendivel(Vendivel v) {
        if (this.artigosAVender.size() < limiteVenda) {
            return this.artigosAVender.add(v);
        }
        return false;
    }

    /**
     * Devolve o Alugavel mais caro da Lista do Anunciante.
     *
     * @return Alugavel mais caro
     */
    public Alugavel getAlugavelMaisCaro() {
        Alugavel maisCaro = this.artigosAAlugar.get(0);
        for (Alugavel alugavel : this.artigosAAlugar) {
            if (alugavel.getValorAluguer() > maisCaro.getValorAluguer()) {
                maisCaro = alugavel;
            }
        }
        return maisCaro;
    }

    /**
     * Devolve o possível total de vendas do Anunciante.
     *
     * @return possível total de vendas
     */
    public float getTotalPossivelVendas() {
        float soma = 0;
        for (Vendivel vendivel : artigosAVender) {
            soma += vendivel.getValorVenda();
        }
        return soma;
    }

    /**
     * Devolve a descrição textual do Anunciante: Nome e Endereço.
     *
     * @return Anunciante
     */
    @Override
    public String toString() {
        return String.format("Anunciante %s, de endereço %s", this.nome, this.endereco);
    }
}
