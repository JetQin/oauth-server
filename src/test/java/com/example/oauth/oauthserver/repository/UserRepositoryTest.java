package com.example.oauth.oauthserver.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import com.example.oauth.oauthserver.config.PersistenceConfiguration;
import com.example.oauth.oauthserver.domain.Role;
import com.example.oauth.oauthserver.domain.User;


@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
//@PropertySource("classpath:application.properties")
@ContextConfiguration(classes = { PersistenceConfiguration.class })
@TestExecutionListeners({ DependencyInjectionTestExecutionListener.class, TransactionalTestExecutionListener.class })
public class UserRepositoryTest {

	@Autowired
	public UserRepository userRepository;

	@Autowired
	public RoleRepository roleRepository;
	
	@Test
	public void testSaveUser(){
		Role role = new Role();
		role.setRoleName("USER");
		roleRepository.save(role);
		long count = roleRepository.count();
		assertEquals(1L, count);
//		Set<Role> roles = new HashSet<Role>();
//		
//		User user = new User();
//		user.setUsername("jet");
//		user.setEmail("jet@email.com");
//		user.setPassword("password");
//		user.setActivated(true);
//		user.setRoles(roles);
//		
//		userRepository.save(user);
	}
	
	@Test
	public void testGetUser(){
		User user = userRepository.findByName("jet");
		assertNotNull(user);
		assertEquals("jet", user.getUsername());
	}
	
	
	@Test
	public void testDeleteUser(){
		User user = userRepository.findByName("jet");
		userRepository.delete(user);
	}
}
