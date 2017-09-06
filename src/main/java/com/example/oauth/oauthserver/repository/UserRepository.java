package com.example.oauth.oauthserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.oauth.oauthserver.domain.User;

@Repository
@Transactional(propagation=Propagation.REQUIRED, readOnly=true, noRollbackFor=Exception.class)
public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select u from User u where u.username = ?1")
	public User findByName(String userName);
}
