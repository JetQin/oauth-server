package com.example.oauth.oauthserver.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.oauth.oauthserver.domain.Role;
import com.example.oauth.oauthserver.domain.User;
import com.example.oauth.oauthserver.repository.UserRepository;

@Service
public class OauthUserDetailService implements UserDetailsService {

	private static final Logger LOGGER = LoggerFactory.getLogger(OauthUserDetailService.class);

	@Autowired
	UserRepository repository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = repository.findByName(username);
		if (null == user) {
			LOGGER.debug("user not found with the provided username");
			return null;
		}
		List<Role> roles = user.getRoles();
		Set<GrantedAuthority> authorities = getAuthorities(roles);
		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),authorities);
	}

	@Transactional
	private Set<GrantedAuthority> getAuthorities(List<Role> roles) {
		Set<GrantedAuthority> authorities = new HashSet<GrantedAuthority>();
		for (Role role : roles) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getRoleName());
			authorities.add(grantedAuthority);
		}
		LOGGER.debug("user authorities are " + authorities.toString());
		return authorities;
	}

}
