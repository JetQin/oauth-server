package com.example.oauth.oauthserver.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

@Entity
@Table(name = "PERMISSION")
public @Data class Permission implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5535092924586031572L;

	@Id
	@Column(name="PERMISSION_ID")
	@GenericGenerator(name="per_generator",strategy="com.example.oauth.oauthserver.domain.generator.PermissionIdGenerator")
	@GeneratedValue(generator="per_generator")
	private Long permissionId;
	
	@Column(name="PERMISSION_NAME")
	private String permissionName;
	
	@Column(name="PERMISSION_DESCRIPTION")
	private String permissionDescription;
	
	public String toString(){
		return String.format("Permission[id=%s,name=%s,description=%s]", permissionId,permissionName,permissionDescription);
	}
	
}
