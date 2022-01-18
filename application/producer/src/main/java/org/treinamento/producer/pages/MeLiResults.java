package org.treinamento.producer.pages;

public class MeLiResults {

    public static final String ITEM_BUSCADO_PATH = "//h1[@class='ui-search-breadcrumb__title']";
    public static final String QTDE_RESULTADOS_PATH = "//span[@class='ui-search-search-result__quantity-results']";
    public static final String RESULTADOS_PATH = "//div[@class='ui-search-result__wrapper']";
    public static final String QTDE_PAGINAS_PATH = "//li[@class='andes-pagination__page-count']";
    public static final String PRECO_ITEM_PATH = ".//div[@class='ui-search-price ui-search-price--size-medium ui-search-item__group__element']//div[@class='ui-search-price__second-line']//span[@class='price-tag-amount']";
    public static final String DESCRICAO_ITEM_PATH = ".//div[@class='ui-search-result__content-wrapper']//h2[@class='ui-search-item__title ui-search-item__group__element']";
    public static final String IMAGEM_ITEM_PATH = ".//img";
    public static final String BOTAO_PROXIMO_PATH = "//a[@class='andes-pagination__link ui-search-link'][@title='Seguinte']";

}
