package com.employee.api.config;

import com.employee.api.model.enums.RoleEnum;
import com.employee.api.service.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    private static final String USER = RoleEnum.CANDIDATE.getRole();

    private static final String ADMIN = RoleEnum.ADMIN.getRole();

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Autowired
    private CustomAuthenticationProvider authProvider;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    public void configureAuthentication(AuthenticationManagerBuilder authenticationManagerBuilder)
            throws Exception {
        authenticationManagerBuilder
                .authenticationProvider(this.authProvider)
                .userDetailsService(this.customUserDetailsService)
                .passwordEncoder(this.passwordEncoder);
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authenticationManagerBuilder)
            throws Exception {
        authenticationManagerBuilder
                .authenticationProvider(this.authProvider)
                .userDetailsService(this.customUserDetailsService)
                .passwordEncoder(this.passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //@formatter:off
        http
                .requestMatchers().mvcMatchers(
                "/",
                "/signup",
                "/login", "/logout",
                "/users",
                "/error", "/thisOneThrowsExceptionToTestExceptionHandling")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/")
                .failureUrl("/login?error=true")
                .permitAll()
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login")
                .permitAll()
                .and()
                .authorizeRequests()
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/signup").permitAll()
                .mvcMatchers("/logout").authenticated()
                .mvcMatchers("/users").hasAnyRole(ADMIN)
                .mvcMatchers("/error", "/thisOneThrowsExceptionToTestExceptionHandling").permitAll()
                .anyRequest().permitAll();
        //@formatter:on
    }
}
