package com.example.oauth.oauthserver.repository;

import static org.junit.Assert.assertEquals;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.oauth.oauthserver.domain.Permission;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class PermissionRepositoryTest {

	private static final Logger log = LoggerFactory.getLogger(PermissionRepositoryTest.class);

	@Autowired
	PermissionRepository permissionRepository;

	@Test
	public void testSavePermission() {
		log.debug("test save permission");
		Permission permission = new Permission();
		permission.setPermissionDescription("Read Permission");
		permission.setPermissionName("Read");
		permissionRepository.saveAndFlush(permission);
		long count = permissionRepository.count();
		assertEquals(1L, count);
	}

}
