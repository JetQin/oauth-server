package com.example.oauth.oauthserver.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.oauth.oauthserver.domain.Role;
import com.example.oauth.oauthserver.domain.User;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class UserRepositoryTest {

	@Autowired
	public UserRepository userRepository;

	
	@Test
	public void testSaveUser(){
		Role role = new Role();
		role.setRoleName("USER");
		List<Role> roles = new ArrayList<Role>();
		roles.add(role);
		
		User user = new User();
		user.setUsername("jet");
		user.setEmail("jet@email.com");
		user.setPassword("password");
		user.setActivated(true);
		user.setRoles(roles);
		
		userRepository.save(user);
	}
	
	@Test
	public void testGetUser(){
		User user = userRepository.findByName("admin");
		assertNotNull(user);
		assertEquals("admin", user.getUsername());
	}
	
	
	@Test
	public void testDeleteUser(){
		User user = userRepository.findByName("jet");
		userRepository.delete(user);
	}
}
