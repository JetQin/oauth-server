package com.example.oauth.oauthserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.oauth.oauthserver.domain.Permission;

@Repository
@Transactional
public interface PermissionRepository extends JpaRepository<Permission, Long> {

}
