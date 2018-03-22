package com.webportal.app;

import org.springframework.boot.web.embedded.undertow.UndertowBuilderCustomizer;
import org.springframework.boot.web.embedded.undertow.UndertowServletWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;

import io.undertow.Undertow.Builder;

public class ContainerConfig
{

    @Bean
    public UndertowServletWebServerFactory servletWebServerFactory()
    {
        UndertowServletWebServerFactory factory = new UndertowServletWebServerFactory();
        factory.addErrorPages(new ErrorPage(HttpStatus.NOT_FOUND, "/notfound.html"));
        factory.addBuilderCustomizers(new UndertowBuilderCustomizer() {

            @Override
            public void customize(Builder builder)
            {
                builder.addHttpListener(8888, "0.0.0.0");
            }

        });
        return factory;
    }

}
