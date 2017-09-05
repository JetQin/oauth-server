package com.example.oauth.oauthserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.oauth.oauthserver.domain.Role;
import com.example.oauth.oauthserver.domain.User;

@Repository
@Transactional
public interface RoleRepository extends JpaRepository<Role, Integer> {

}
