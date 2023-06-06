package br.furb.inf.furbot.configuracao;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import br.furb.inf.furbot.security.AutenticacaoFiltroJWT;
import br.furb.inf.furbot.security.AutorizacaoFiltroJWT;
import br.furb.inf.furbot.security.UtilJWT;

@Configuration
@EnableWebSecurity
public class SegurancaJWT extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;

	@Autowired
	private BCryptPasswordEncoderConfig bCryptPasswordEncoderConfig;

	@Autowired
	private UtilJWT jwtUtil;

	private static final String[] PUBLIC_MATCHERS = { //
			"/swagger-ui/**", //
			"/swagger-ui.html", //
			"/v3/**", //
			"/api/usuarios/{id}/alterar_senha" //
	};

	private static final String[] PUBLIC_MATCHERS_POST = { "/usuarios", "/login" };

	private static final String[] PUBLIC_MATCHER_GET = { "/*.js", "/*.js.map", "/*.html", "/", "/*.css", "/*.json",
			"/*.woff2", "/*.woff", //
			"/*.png", "/assets/**", "/svg/**", "/actuator/**" };

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.cors().and().csrf().disable();
		http.cors().and().authorizeRequests()
				.antMatchers(HttpMethod.POST, PUBLIC_MATCHERS_POST).permitAll()
				.antMatchers(HttpMethod.GET, PUBLIC_MATCHER_GET).permitAll()
				.antMatchers(PUBLIC_MATCHERS).permitAll()
				.anyRequest().authenticated();
		http.addFilter(new AutenticacaoFiltroJWT(authenticationManager(), jwtUtil));
		http.addFilter(new AutorizacaoFiltroJWT(authenticationManager(), jwtUtil, this.userDetailsService));
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.headers().frameOptions().disable();
	}

	@Override
	public void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService)
				.passwordEncoder(bCryptPasswordEncoderConfig.bCryptPasswordEncoder());
	}

	@Bean
	CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Collections.singletonList("*"));
		configuration.setAllowedMethods(Collections.singletonList("*"));
		configuration.setAllowedHeaders(Collections.singletonList("*"));
		configuration.setAllowedOriginPatterns(Collections.singletonList("*"));
		configuration.setExposedHeaders(Collections.singletonList(HttpHeaders.ACCEPT));
		configuration.setAllowCredentials(false);
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		return source;
	}

}
