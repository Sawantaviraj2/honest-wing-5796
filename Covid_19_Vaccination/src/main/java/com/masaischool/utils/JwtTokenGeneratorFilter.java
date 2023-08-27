package com.masaischool.utils;

import java.io.IOException;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.crypto.SecretKey;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtTokenGeneratorFilter extends OncePerRequestFilter {

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

		if (authentication != null) {

			SecretKey key = Keys.hmacShaKeyFor(SecurityConstants.JWT_KEY.getBytes());

			String jwt = Jwts.builder().
					setIssuer("Covid_19").
					setSubject("JWT Token")
					.claim("username", authentication.getName())
					.claim("authorities", convertToString(authentication.getAuthorities())).
					setIssuedAt(new Date())
					.setExpiration(new Date(new Date().getTime() + 85000000))
					.signWith(key).compact();

			response.setHeader(SecurityConstants.JWT_HEADER, jwt);

		}

		filterChain.doFilter(request, response);

	}

	private String convertToString(Collection<? extends GrantedAuthority> collection) {

		Set<String> set = new HashSet<>();

		for (GrantedAuthority authority : collection) {
			set.add(authority.getAuthority());
		}
		String join = String.join(",", set);

		System.out.println(join);

		return join;

	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException {

		return !request.getServletPath().equals("/auth/login");
	}
}
