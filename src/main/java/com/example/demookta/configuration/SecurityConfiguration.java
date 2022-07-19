package com.example.demookta.configuration;

import com.okta.spring.boot.oauth.Okta;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${ENABLE_SECURITY:true}")
    private boolean isSecurityEnable;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("Is security enable: " + isSecurityEnable);
        if(isSecurityEnable) {
            http.authorizeRequests()
                    .anyRequest().authenticated()
                    .and()
                    .oauth2ResourceServer().jwt();
            http.cors();
            Okta.configureResourceServer401ResponseBody(http);
        } else {
            http.authorizeRequests().anyRequest().permitAll();
        }
    }
}
