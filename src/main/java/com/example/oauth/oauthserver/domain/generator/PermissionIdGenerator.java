package com.example.oauth.oauthserver.domain.generator;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Random;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.security.crypto.codec.Hex;

public class PermissionIdGenerator implements IdentifierGenerator{

	private int generatePermissionId() {
        Random random = new Random();
        return random.nextInt(100);
    }
	
	@Override
	public Serializable generate(SessionImplementor session, Object object) throws HibernateException {
        Calendar calendar = Calendar.getInstance();
        return "permission_" + this.generatePermissionId() + "_" + calendar.getTimeInMillis();
 
	}

}
