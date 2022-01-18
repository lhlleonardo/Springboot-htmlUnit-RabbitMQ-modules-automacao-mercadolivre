package org.treinamento.domain.model;

import java.util.LinkedList;
import java.util.List;

public class Demanda {

    String itemDemanda;
    String qtdeResultados;
    List<Produto> produtos = new LinkedList<>();;

    public Demanda() {
    }

    public String getItemDemanda() {
        return itemDemanda;
    }

    public void setItemDemanda(String itemDemanda) {
        this.itemDemanda = itemDemanda;
    }

    public String getQtdeResultados() {
        return qtdeResultados;
    }

    public void setQtdeResultados(String qtdeResultados) {
        this.qtdeResultados = qtdeResultados;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public void adicionarProduto(Produto produto) {
        this.produtos.add(produto);
    }

    public String retornarBusca() {

        StringBuilder retorno = new StringBuilder("Você buscou pelo conteúdo '" + itemDemanda +
                "' retornando " + qtdeResultados +
                "(s). \n" +
                "A pesquisa apresentou os seguintes itens: \n");

        for (Produto p : produtos) {
            retorno.append(p.retornaProduto());
        }

        return retorno.toString();
    }
}
