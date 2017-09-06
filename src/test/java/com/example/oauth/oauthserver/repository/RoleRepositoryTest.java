package com.example.oauth.oauthserver.repository;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.oauth.oauthserver.domain.Role;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class RoleRepositoryTest {

	@Autowired
	public RoleRepository roleRepository;

	@Test
	public void testSaveRole() {
		Role role = new Role();
		role.setRoleName("USER");
		roleRepository.save(role);
		long count = roleRepository.count();
		assertEquals(1L, count);
	}

	@Test
	public void testDeleteRole() {
		roleRepository.deleteAll();
		long count = roleRepository.count();
		assertEquals(0L, count);
	}

}
