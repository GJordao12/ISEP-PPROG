package org.example.controller;

import org.example.model.FicheiroListaTarefas;
import org.example.model.ListaTarefas;
import org.example.model.Prioridade;

import java.util.List;

public class AplicacaoController {

    private ListaTarefas lista;
    private FicheiroListaTarefas ficheiroListaTarefas;

    //inicia atributos
    public AplicacaoController() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    //adiciona uma nova tarefa na lista
    public boolean adicionarTarefa(String descricao, Prioridade prioridade) {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    //elimina da lista todas as tarefas
    public void eliminarTarefas() {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    //elimina apenas a última tarefa inserida na lista
    public boolean eliminarUltimaTarefa() {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    //elimina a tarefa, sob a forma de string, recebida por parâmetro
    public boolean eliminarTarefa(String tarefaSelecionada) {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    //verifica se lista está ou não vazia
    public boolean listaVazia() {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    //retorna os elementos da lista, por ordem de inserção
    public String getListaTarefas() {
        return ListaTarefas.toString();

    }

    //retorna os elementos da lista, por ordem de inserção, sob a forma de um List<String>
    public List<String> getArrayListTarefas() {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    //retorna os elementos da lista, por ordem decrescente de prioridade
    public String getListaTarefasPorPrioridade() {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    //retorna os elementos da lista, por ordem decrescente de prioridade, sob a forma de um List<String>
    public List<String> getArrayListTarefasPorPrioridade() {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    //retorna um array com todos os valores de Prioridade
    public Prioridade[] getPrioridades() {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    //guarda em ficheiro de texto a lista de tarefas
    public boolean guardarFicheiroTexto() {
        throw new UnsupportedOperationException("Not supported yet.");

    }

    //guarda em ficheiro binário a lista de tarefas
    public boolean guardarFicheiroBinario() {
        throw new UnsupportedOperationException("Not supported yet.");

    }

}

