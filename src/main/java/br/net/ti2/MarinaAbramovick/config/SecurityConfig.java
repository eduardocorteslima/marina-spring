package br.net.ti2.MarinaAbramovick.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.http.HttpMethod;


import br.net.ti2.MarinaAbramovick.service.CustomUserDetailService;
import static br.net.ti2.MarinaAbramovick.config.SecurityConstants.*;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    private CustomUserDetailService customUserDetailService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
		 http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
         .and().csrf().disable()
         .authorizeRequests()
         .antMatchers(HttpMethod.GET, SIGN_UP_URL).permitAll()
         .and()
         .addFilter(new JWTAuthenticationFilter(authenticationManager()))
         .addFilter(new JWTAuthorizationFilter(authenticationManager(), customUserDetailService));
	}

	/*@Override
	protected void configure(HttpSecurity http) throws Exception{
		http
		.authorizeRequests()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic().and()
		.csrf().disable();
	}*/
	
	@Autowired //Este é o cara que autoriza a requisição
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(customUserDetailService).passwordEncoder(new BCryptPasswordEncoder());
	}
}
