package org.treinamento.producer.message;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.treinamento.producer.config.RabbitMQConfig;
import org.treinamento.producer.service.DemandaService;

import java.io.IOException;
import java.util.Date;
import java.util.UUID;

@RestController
public class MensagemProducer {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private DemandaService demandaService;

    @PostMapping("/publicar")
    public void publicarMensagem(@RequestBody Mensagem mensagem) throws IOException {

        mensagem.setIdMensagem(UUID.randomUUID().toString());
        mensagem.setMessageDate(new Date());

        demandaService.retornarItemProcurado(mensagem.getMensagem());



        System.out.println("Mensagem criada: ");
        System.out.println("ID: " + mensagem.getIdMensagem());
        System.out.println("Conteúdo: " + mensagem.getMensagem());
        System.out.println("Criada em: " + mensagem.getMessageDate());
    }
}