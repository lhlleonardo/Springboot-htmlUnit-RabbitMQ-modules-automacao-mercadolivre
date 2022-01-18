package org.treinamento.domain.model;

public class Produto {

    String descricao;
    String preco;
    String urlImagem;

    public Produto() {
    }

    public Produto(String descricao, String preco, String urlImagem) {
        this.descricao = descricao;
        this.preco = preco;
        this.urlImagem = urlImagem;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public String retornaProduto() {
        return preco + " | " + descricao + " | " + urlImagem + ".\n";
    }

}
