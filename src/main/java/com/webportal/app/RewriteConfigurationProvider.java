package com.webportal.app;
import javax.servlet.ServletContext;

import org.ocpsoft.rewrite.annotation.RewriteConfiguration;
import org.ocpsoft.rewrite.config.Configuration;
import org.ocpsoft.rewrite.config.ConfigurationBuilder;
import org.ocpsoft.rewrite.servlet.config.HttpConfigurationProvider;
import org.ocpsoft.rewrite.servlet.config.rule.Join;
import org.springframework.stereotype.Component;

@Component
public class RewriteConfigurationProvider extends HttpConfigurationProvider
{

    @Override
    public Configuration getConfiguration(ServletContext context)
    {
        return ConfigurationBuilder.begin()
                .addRule(Join.path("/login").to("/login.xhtml"))
               
                ;
    }

    @Override
    public int priority()
    {
        return 0;
    }
}