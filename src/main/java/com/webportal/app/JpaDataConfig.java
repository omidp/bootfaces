package com.webportal.app;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.webportal.app.domain.User;
import com.webportal.app.security.SpringSecurityAuditorAware;

/**
 *
 * @author Omid Pourhadi
 *
 */
@Configuration
@EntityScan({ "com.webportal.app.domain" })
@EnableJpaRepositories({ "com.webportal.app.dao" })
@EnableJpaAuditing()
public class JpaDataConfig
{

    @Bean
    public AuditorAware<User> auditAware()
    {
        return new SpringSecurityAuditorAware();
    }

}
