package com.example.oauth.oauthserver.domain;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "ROLE")
@EqualsAndHashCode
public @Data class Role implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6556059265371021067L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "ROLE_ID")
	private Integer roleId;

	@Column(name = "ROLE_NAME")
	private String roleName;

	@Column(name = "ROLE_DESCRIPTION")
	private String roleDescription;

	@JsonIgnore
	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private Set<User> users;

	public String toString() {
		return String.format("roleId:%d,roleName:%s,roleDescription:%s", roleId, roleName, roleDescription);
	}

}
