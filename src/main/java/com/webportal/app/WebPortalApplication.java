package com.webportal.app;

import java.io.PrintStream;
import java.util.Arrays;

import javax.faces.webapp.FacesServlet;
import javax.servlet.DispatcherType;

import org.ocpsoft.rewrite.servlet.RewriteFilter;
import org.ocpsoft.rewrite.servlet.impl.RewriteServletContextListener;
import org.ocpsoft.rewrite.servlet.impl.RewriteServletRequestListener;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;

import com.jedlab.framework.spring.SpringUtil;

//@SpringBootApplication
/**
 *
 * @author Omid Pourhadi
 *
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration(excludeName={"org.springframework.boot.autoconfigure.jsonb.JsonbAutoConfiguration"})
@EnableConfigurationProperties
@PropertySource({ "classpath:database.properties" })
@Import(ContainerConfig.class)
@ImportResource(locations="classpath*:framework-spring.xml")
public class WebPortalApplication extends SpringBootServletInitializer 
{

    public static void main(String[] args)
    {
        SpringApplication sp = new SpringApplication(WebPortalApplication.class);
        sp.setBanner(new Banner() {

            @Override
            public void printBanner(Environment environment, Class<?> sourceClass, PrintStream out)
            {
                out.println("Yet Another Reporting Tool");
            }
        });
        sp.run(args);

    }
    
    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(WebPortalApplication.class, Initializer.class);
    }

    @Bean
    public CommandLineRunner commandLineRunner(ApplicationContext ctx)
    {
        return args -> {

            System.out.println("Let's inspect the beans provided by Spring Boot:");

            String[] beanNames = ctx.getBeanDefinitionNames();
            Arrays.sort(beanNames);
            for (String beanName : beanNames)
            {
                System.out.println(beanName);
            }

        };
    }

//    @Bean
//    public SpringUtil springUtil()
//    {
//        return new SpringUtil();
//    }

    
    @Bean
    public RewriteServletRequestListener rewriteServletRequestListener(){
       return new RewriteServletRequestListener();
    }
   
    @Bean
    public RewriteServletContextListener rewriteServletContextListener(){
        return new RewriteServletContextListener();
    }
    
    @Bean
    public FilterRegistrationBean prettyFilter()
    {
        FilterRegistrationBean prettyFilter = new FilterRegistrationBean(new RewriteFilter());
        prettyFilter.addInitParameter("org.ocpsoft.rewrite.annotation.SCAN_LIB_DIRECTORY", "true");
        prettyFilter.addInitParameter("org.ocpsoft.rewrite.annotation.BASE_PACKAGES", "com.webportal.app");
        prettyFilter.setFilter(new RewriteFilter());
        prettyFilter.setDispatcherTypes(DispatcherType.FORWARD, DispatcherType.REQUEST, DispatcherType.ASYNC, DispatcherType.ERROR);
        prettyFilter.addUrlPatterns("/*");
        return prettyFilter;
    }
    
    @Bean
    public ServletRegistrationBean servletRegistrationBean() {
        FacesServlet servlet = new FacesServlet();
        ServletRegistrationBean servletRegistrationBean = new ServletRegistrationBean(servlet, "*.xhtml");
        servletRegistrationBean.setLoadOnStartup(1);
        return servletRegistrationBean;
    }

}
