package org.example.controller;

import org.example.model.ListaTarefas;
import org.example.model.Prioridade;

/**
 * @author Jordão
 */
public class AplicacaoController {

    private ListaTarefas listaTarefas;

    //inicia atributos
    public AplicacaoController() {
        listaTarefas = new ListaTarefas();
    }

    //adiciona uma nova tarefa na lista
    public boolean adicionarTarefa(String descricao, Prioridade prioridade) {
        return listaTarefas.adicionarTarefa(descricao, prioridade);
    }

    //elimina de lista todas as tarefas
    public void eliminarTarefas() {
        listaTarefas.eliminarTarefas();
    }

    //elimina apenas a última tarefa inserida na lista
    public boolean eliminarUltimaTarefa() {
        return listaTarefas.eliminarUltimaTarefa();
    }

    //verifica se lista está ou não vazia
    public boolean listaVazia() {
        return listaTarefas.listaVazia();
    }

    //retorna os elementos da lista, por ordem de inserção
    public String getListaTarefas() {
        return listaTarefas.toString();
    }

    //retorna os elementos da lista, por decrescente de prioridade
    public String getListaTarefasPorPrioridade() {
        return listaTarefas.toStringPrioridade();
    }
}

