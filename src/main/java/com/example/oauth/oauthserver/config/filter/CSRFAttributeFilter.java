/** 
 * Project Name:oauth-server 
 * File Name:CSRFilter.java 
 * Package Name:com.example.oauth.oauthserver.config.filter
 * Date:Aug 31, 20174:22:23 PM 
 * Copyright (c) 2017, jetq All Rights Reserved. 
 * 
 */
package com.example.oauth.oauthserver.config.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.util.WebUtils;

/**
 * ClassName: CSRFilter
 * 
 * @author jet
 * @version Configuration Framework 1.0
 * @since JDK 1.7
 */
@Component
@Order(Ordered.HIGHEST_PRECEDENCE)
public class CSRFAttributeFilter extends OncePerRequestFilter {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain)
			throws ServletException, IOException {

		CsrfToken csrf = (CsrfToken) request.getAttribute(CsrfToken.class.getName());
		if (csrf != null) {
			Cookie cookie = WebUtils.getCookie(request, "X-XSRF-TOKEN");
			String token = csrf.getToken();
			if (cookie == null || token != null && !token.equals(cookie.getValue())) {
				cookie = new Cookie("X-XSRF-TOKEN", token);
				cookie.setPath(request.getContextPath());
				response.addCookie(cookie);
			}
		}
		chain.doFilter(request, response);
	}

}
