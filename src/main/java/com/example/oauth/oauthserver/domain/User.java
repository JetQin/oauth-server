package com.example.oauth.oauthserver.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Entity
@Table(name = "USER")
public @Data class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3349262457666475863L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "USER_ID")
	private Long userId;

	@Column(name = "USER_NAME")
	private String username;

	@Column(name = "EMAIL")
	private String email;

	@Column(name = "PASSWORD")
	private String password;

	@Column(name = "ACTIVATED")
	private boolean activated;

	@Column(name = "ACTIVATIONKEY")
	private String activationKey;

	@Column(name = "RESETPASSWORDKEY")
	private String resetPasswordKey;

	@JsonIgnore
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "USER_ROLE",
		joinColumns = @JoinColumn(name = "USER_ID"), 
		inverseJoinColumns = @JoinColumn(name = "ROLE_ID"))
	private List<Role> roles;

	public String toString() {
		return String.format("User[userId:%d,userName:%s,email:%s,activated:%s]", userId, username, email, activated);
	}

}
