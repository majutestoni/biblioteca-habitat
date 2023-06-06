package br.furb.inf.furbot.security;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

public class AutorizacaoFiltroJWT extends BasicAuthenticationFilter {

	private UtilJWT jwtUtil;

	private UserDetailsService detailsService;

	public AutorizacaoFiltroJWT(AuthenticationManager authenticationManager, UtilJWT jwtUtil,
			UserDetailsService detailsService) {
		super(authenticationManager);
		this.jwtUtil = jwtUtil;
		this.detailsService = detailsService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		String header = request.getHeader("Authorization");
		if (header != null && header.startsWith("Bearer ")) {
			UsernamePasswordAuthenticationToken authenticationToken = getAuthenticate(request, header.substring(7));
			if (authenticationToken != null) {
				SecurityContextHolder.getContext().setAuthentication(authenticationToken);
			}
		}
		chain.doFilter(request, response);
	}

	private UsernamePasswordAuthenticationToken getAuthenticate(HttpServletRequest request, String token) {
		if (this.jwtUtil.isValidToken(token)) {
			String username = this.jwtUtil.getUsername(token);
			UserDetails details = this.detailsService.loadUserByUsername(username);
			return new UsernamePasswordAuthenticationToken(details, null, details.getAuthorities());
		}
		return null;
	}

}
