package pt.ipp.isep.dei.esoft.pot.model.registo;

import pt.ipp.isep.dei.esoft.pot.model.AreaAtividade;
import pt.ipp.isep.dei.esoft.pot.model.Categoria;

import java.util.ArrayList;
import java.util.List;

/**
 * Registo de Categorias.
 *
 * @author Jordão e António
 */
public class RegistoCategorias {

    private List<Categoria> m_lstCategorias;

    /**
     * Instancia um novo Registo de categorias.
     */
    public RegistoCategorias() {
        this.m_lstCategorias = new ArrayList<>();
    }

    /**
     * Constrói uma nova Categoria através do construtor da classe Categoria.
     *
     * @param strDescricao descrição
     * @param at           área atividade
     * @return categoria
     */
    public Categoria novaCategoria(String strDescricao, AreaAtividade at) {
        String strId = geraCategoriaId();
        return new Categoria(strId, strDescricao, at);
    }

    /**
     * Adiciona uma categoria recebida por parâmetro à lista de Categorias.
     *
     * @param oCatTarefa categoria
     * @return boolean
     */

    private boolean addCategoria(Categoria oCatTarefa) {
        return this.m_lstCategorias.add(oCatTarefa);
    }

    /**
     * Regista uma categoria.
     *
     * @param categoria categoria
     * @return boolean
     */
    public boolean registaCategoria(Categoria categoria) {
        if (this.validaCategoria(categoria)) {
            return addCategoria(categoria);
        }
        return false;
    }

    /**
     * Gera um ID de uma categoria.
     *
     * @return id
     */
    private String geraCategoriaId() {
        return "123" + this.m_lstCategorias.size();
    }

    /**
     * Valida uma categoria.
     *
     * @param oCatTarefa categoria tarefa
     * @return boolean
     */
    public boolean validaCategoria(Categoria oCatTarefa) {
        boolean bRet = true;

        if (this.m_lstCategorias.contains(oCatTarefa)) {
            bRet = false;
        }

        return bRet;
    }

    /**
     * Devolve a categoria através do ID.
     *
     * @param catId categoria id
     * @return categoria
     */
    public Categoria getCategoriaById(String catId) {

        for (Categoria cat : this.m_lstCategorias) {
            if (cat.getId().equals(catId)) {
                return cat;
            }
        }
        return null;
    }
}
