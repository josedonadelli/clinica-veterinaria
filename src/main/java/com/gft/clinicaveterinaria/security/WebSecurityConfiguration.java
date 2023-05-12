package com.gft.clinicaveterinaria.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfiguration {
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	// Lista de permissoes caso for usar o swagger. Snão, excluir
	/*
	 * private static final String[] SWAGGER_WHITELIST = { "/v2/api-docs",
	 * "/swagger-resources", "/swagger-resources/**", "/configuration/ui",
	 * "/configuration/security", "/swagger-ui.html", "/webjars/**" };
	 */
	// {documento}/cachorros/{id}/consultas
	// v1/racas/{nome}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.headers().frameOptions().disable();
		http.cors().and().csrf().disable().addFilterAfter(new JWTFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests(authorizeRequests -> authorizeRequests.antMatchers(HttpMethod.POST, "/v1/login")
						.permitAll().antMatchers(HttpMethod.POST, "/v1/usuarios").hasAnyRole("USERS", "MANAGERS")
						.antMatchers(HttpMethod.DELETE, "/v1/usuarios").hasAnyRole("MANAGERS")

						.antMatchers(HttpMethod.GET, "/v1/cachorros").hasAnyRole("MANAGERS")
						.antMatchers(HttpMethod.GET, "/v1/cachorros/{id}").hasAnyRole("MANAGERS")
						.antMatchers(HttpMethod.GET, "/v1/cachorros/{id}/consultas").hasAnyRole("MANAGERS")
						.antMatchers(HttpMethod.POST, "/v1/cachorros").hasAnyRole("MANAGERS")
						.antMatchers(HttpMethod.PUT, "/v1/cachorros/{id}").hasAnyRole("MANAGERS")
						.antMatchers(HttpMethod.DELETE, "/v1/cachorros/{id}").hasAnyRole("MANAGERS")

						.antMatchers(HttpMethod.GET, "/v1/clientes").hasAnyRole("MANAGERS")
						.antMatchers(HttpMethod.POST, "/v1/clientes").hasAnyRole("MANAGERS")
						.antMatchers(HttpMethod.PUT, "/v1/clientes/{documento}").hasAnyRole("MANAGERS")
						.antMatchers(HttpMethod.DELETE, "/v1/clientes/{documento}").hasAnyRole("MANAGERS")
						.antMatchers(HttpMethod.POST, "/v1/clientes/{documento}/cachorros/{id}/consultas")
						.hasAnyRole("USERS", "MANAGERS")

						.antMatchers(HttpMethod.GET, "/v1/consultas").hasAnyRole("MANAGERS")
						.antMatchers(HttpMethod.GET, "/v1/consultas/{id}").hasAnyRole("MANAGERS")
						.antMatchers(HttpMethod.POST, "/v1/consultas").hasAnyRole("MANAGERS")
						.antMatchers(HttpMethod.PUT, "/v1/consultas/{id}").hasAnyRole("MANAGERS")
						.antMatchers(HttpMethod.DELETE, "/v1/consultas/{id}").hasAnyRole("MANAGERS")

						.antMatchers(HttpMethod.GET, "/v1/racas").hasAnyRole("USERS", "MANAGERS")
						.antMatchers(HttpMethod.GET, "/v1/racas/{nome}").hasAnyRole("USERS", "MANAGERS")

						.antMatchers(HttpMethod.GET, "/v1/veterinarios").hasAnyRole("MANAGERS")
						.antMatchers(HttpMethod.POST, "/v1/veterinarios").hasAnyRole("MANAGERS")
						.antMatchers(HttpMethod.GET, "/v1/veterinarios/{crmv}").hasAnyRole("MANAGERS")
						.antMatchers(HttpMethod.PUT, "/v1/veterinarios/{crmv}").hasAnyRole("MANAGERS")
						.antMatchers(HttpMethod.DELETE, "/v1/veterinarios/{crmv}").hasAnyRole("MANAGERS")

						.antMatchers("/managers").hasAnyRole("MANAGERS").anyRequest().authenticated())
				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		return http.build();
	}
}
