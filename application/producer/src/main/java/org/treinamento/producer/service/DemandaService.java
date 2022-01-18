package org.treinamento.producer.service;

import com.gargoylesoftware.htmlunit.html.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.treinamento.domain.model.Demanda;
import org.treinamento.domain.model.Produto;
import org.treinamento.producer.config.RabbitMQConfig;
import org.treinamento.producer.pages.MeLiResults;
import java.io.IOException;
import java.util.List;

@Service
public class DemandaService {

    @Autowired
    MeLiService meLiService;

    @Autowired
    private RabbitTemplate template;

    public void retornarItemProcurado(String item) throws IOException {

        HtmlPage resultadoBusca = meLiService.mercadoLivreBuscarItem(item);

        HtmlHeading1 itemBuscado = resultadoBusca.getFirstByXPath(MeLiResults.ITEM_BUSCADO_PATH);
        HtmlSpan quantidadeResultados = resultadoBusca.getFirstByXPath(MeLiResults.QTDE_RESULTADOS_PATH);
        HtmlListItem totalPaginas = resultadoBusca.getFirstByXPath(MeLiResults.QTDE_PAGINAS_PATH);
        HtmlAnchor botaoProximo = resultadoBusca.getFirstByXPath(MeLiResults.BOTAO_PROXIMO_PATH);

        String paginas = totalPaginas.getTextContent().replaceAll("\\D+","");

        Demanda demanda = new Demanda();

        demanda.setItemDemanda(itemBuscado.getTextContent());
        demanda.setQtdeResultados(quantidadeResultados.getTextContent());

        for (int i = 1; i <= Integer.parseInt(paginas); i++) {

            List<HtmlDivision> resultados = resultadoBusca.getByXPath(MeLiResults.RESULTADOS_PATH);

            for (HtmlDivision r : resultados) {

                HtmlSpan precoProduto = r.getFirstByXPath(MeLiResults.PRECO_ITEM_PATH);
                HtmlHeading2 descricaoProduto = r.getFirstByXPath(MeLiResults.DESCRICAO_ITEM_PATH);
                HtmlImage imagemProduto = r.getFirstByXPath(MeLiResults.IMAGEM_ITEM_PATH);

                template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, new Produto(descricaoProduto.getTextContent(), precoProduto.getTextContent(), imagemProduto.getSrc()));
            }

            if (botaoProximo != null) {
                resultadoBusca = botaoProximo.click();
            } else {
                continue;
            }
        }
    }
}
