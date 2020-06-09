/*
 * Created on 2020-06-09 ( Date ISO 2020-06-09 - Time 12:08:44 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.1.2
 */
package org.demo.persistence.impl.jpa.mapping.modelmapper;

import org.demo.persistence.impl.jpa.mapping.JpaMapper;
import org.demo.persistence.impl.jpa.mapping.JpaMapperProvider;

/**
 * Mapper provider for "ModelMapper" implementation.
 * 
 * @author Telosys
 */
public class JpaMapperProviderImpl implements JpaMapperProvider {

	@Override
	public <JPA, POJO> JpaMapper<JPA, POJO> getMapper(Class<JPA> jpaClass, Class<POJO> pojoClass) {

		return new JpaMapperImpl<>(jpaClass, pojoClass);
	}

}
