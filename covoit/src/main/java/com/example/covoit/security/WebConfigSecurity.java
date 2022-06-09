package com.example.covoit.security;


import com.example.covoit.entity.UserEntity;
import com.example.covoit.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

@Configuration
@EnableWebSecurity
public class WebConfigSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    private AccountService accountService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
                UserEntity user = accountService.loadUserByUsername(username);
                Collection<GrantedAuthority> authorities = new ArrayList<>();
                user.getRoles().forEach(r -> {
                    authorities.add(new SimpleGrantedAuthority(r.getRoleName()));
                });
                return new User(user.getUsername(),user.getPassword(),authorities);
            }
        });
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        JwtAuthentificationFilter jwtAuthentificationFilter = new JwtAuthentificationFilter(authenticationManagerBean());
        jwtAuthentificationFilter.setFilterProcessesUrl("/Covoit/login/**");
        http.cors().and().csrf().disable();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/Covoit/admin/refresh/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/Covoit/login/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/Covoit/admin/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/Covoit/admin/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/Covoit/user/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/Covoit/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.POST,"/Covoit/user/**").permitAll();
        http.authorizeRequests().antMatchers(HttpMethod.DELETE,"/Covoit/**").permitAll();

        http.authorizeRequests().antMatchers(HttpMethod.POST,"/Covoit/admin/validate_account").hasAuthority("Admin");
        http.authorizeRequests().antMatchers(HttpMethod.GET,"/Covoit/getAllUser").hasAuthority("User");

        http.headers().frameOptions().disable();
        http.authorizeRequests().anyRequest().authenticated();
        http.addFilter(jwtAuthentificationFilter);
        http.addFilterBefore(new JwtAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }


    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        final CorsConfiguration config = new CorsConfiguration();

        config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        config.setAllowedMethods(Arrays.asList("GET", "POST", "OPTIONS", "DELETE", "PUT", "PATCH"));
        config.setAllowCredentials(true);
        config.setAllowedHeaders(Arrays.asList("Authorization", "Cache-Control", "Content-Type"));

        final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);

        return source;
    }
}
