package com.example.clients.security;

import org.keycloak.adapters.springboot.KeycloakSpringBootConfigResolver;
import org.keycloak.adapters.springsecurity.KeycloakConfiguration;
import org.keycloak.adapters.springsecurity.config.KeycloakWebSecurityConfigurerAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.WebSecurityConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.core.session.SessionRegistryImpl;
import org.springframework.security.web.authentication.session.RegisterSessionAuthenticationStrategy;
import org.springframework.security.web.authentication.session.SessionAuthenticationStrategy;


@KeycloakConfiguration
public  class KeycloakSecurityConfig extends KeycloakWebSecurityConfigurerAdapter {
    @Override
    protected SessionAuthenticationStrategy sessionAuthenticationStrategy() {
        //impllementation classique pour la securiter pour gestion des session
        return new RegisterSessionAuthenticationStrategy(new SessionRegistryImpl());
    }


    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        //en delege la gestion des user et les role au providere (keycloak qui vas le gerer)
        auth.authenticationProvider(keycloakAuthenticationProvider());//retourn comment il vas gerer les user et les roles
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //pour les droits d'acc
        super.configure(http);
        http.authorizeRequests().antMatchers("/clients").authenticated();
        http.headers().frameOptions().disable();
        http.csrf().disable();
    }

}
