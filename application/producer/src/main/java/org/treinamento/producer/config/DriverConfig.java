package org.treinamento.producer.config;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DriverConfig {

    @Bean
    public WebClient chrome() { return chromeDriver(); }

    @Bean
    public WebClient firefox() { return firefoxDrive(); }

    public WebClient chromeDriver() {

        WebClient webClient = new WebClient(BrowserVersion.CHROME);

        webClient.getOptions().setUseInsecureSSL(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setRedirectEnabled(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(false);

        return webClient;
    }

    public WebClient firefoxDrive() {

        WebClient webClient = new WebClient(BrowserVersion.FIREFOX);

        webClient.getOptions().setUseInsecureSSL(false);
        webClient.getOptions().setThrowExceptionOnScriptError(false);
        webClient.getOptions().setRedirectEnabled(true);
        webClient.getOptions().setCssEnabled(false);
        webClient.getOptions().setJavaScriptEnabled(true);

        return webClient;
    }
}
