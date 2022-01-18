package org.treinamento.commons.webclient;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient chrome() { return chromeDriver(); }

    @Bean
    public WebClient firefox() { return firefoxDriver(); }

    public WebClient chromeDriver() {

        WebClient webClient = new WebClient(BrowserVersion.CHROME);

        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);

        return webClient;
    }

    public WebClient firefoxDriver() {

        WebClient webClient = new WebClient(BrowserVersion.FIREFOX);

        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);

        return webClient;
    }
}