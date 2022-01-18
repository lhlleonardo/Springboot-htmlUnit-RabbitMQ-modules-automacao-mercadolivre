package org.treinamento.producer.service;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlButton;
import com.gargoylesoftware.htmlunit.html.HtmlInput;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.treinamento.producer.pages.MeLiHome;
import java.io.IOException;

@Service
public class MeLiService {

    @Autowired
    public WebClient chrome;

    public HtmlPage mercadoLivreBuscarItem(String item) throws IOException {

        HtmlPage page = chrome.getPage(MeLiHome.URL);

        HtmlInput campoBusca = page.getFirstByXPath(MeLiHome.CAMPO_BUSCA_PATH);

        campoBusca.setValueAttribute(item);

        HtmlButton botaoBusca = page.getFirstByXPath(MeLiHome.BOTAO_BUSCA_PATH);

        HtmlPage resultadoBusca = botaoBusca.click();

        return resultadoBusca;
    }
}
