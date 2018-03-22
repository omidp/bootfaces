package com.webportal.app;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.boot.web.servlet.ServletContextInitializer;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Initializer implements ServletContextInitializer
{

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException
    {
        System.err.println("------------------------------------");
        servletContext.setInitParameter("primefaces.CLIENT_SIDE_VALIDATION", "true");
        servletContext.setInitParameter("org.ocpsoft.rewrite.annotation.SCAN_LIB_DIRECTORY", "true");
        servletContext.setInitParameter("org.ocpsoft.rewrite.annotation.BASE_PACKAGES", "com.webportal.app");
        servletContext.setInitParameter("com.sun.faces.forceLoadConfiguration", Boolean.TRUE.toString());
        servletContext.addListener(com.sun.faces.config.ConfigureListener.class);
//        servletContext.setInitParameter("primefaces.THEME", "bootstrap");
    }

}