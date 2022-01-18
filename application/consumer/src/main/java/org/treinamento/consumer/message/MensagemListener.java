package org.treinamento.consumer.message;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.treinamento.domain.model.Demanda;
import org.treinamento.domain.model.Produto;

import java.io.IOException;
import java.util.Date;

@Component
public class MensagemListener {

    private Produto produto;

    private Integer qtdeProdutosTratados;

    public MensagemListener() {
        this.qtdeProdutosTratados = 0;
    }

    public Integer getQtdeProdutosTratados() {
        return qtdeProdutosTratados;
    }

    public void setQtdeProdutosTratados(Integer qtdeProdutosTratados) {
        this.qtdeProdutosTratados = qtdeProdutosTratados;
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(MensagemListener.class);

    @RabbitListener(queues = "${spring.rabbitmq.queue}")
    public void ouvir(Produto produto) throws IOException {

        this.setQtdeProdutosTratados(this.qtdeProdutosTratados ++);

        try {
            LOGGER.info("");
            LOGGER.info("**-------------------------------------**");
            LOGGER.info("Iniciando processamento " + new Date());

            LOGGER.info("Processando o produto de número {}", this.getQtdeProdutosTratados());

            LOGGER.info("Mensagem recebida...");

            LOGGER.info("Apresentando resultados...");

            LOGGER.info(produto.retornaProduto());

        } catch (Exception e) {
            LOGGER.info("Falha...");
            e.printStackTrace();

        } finally {
            LOGGER.info("A busca foi finalizada...");
            LOGGER.info("**-------------------------------------**");
        }
    }
}
