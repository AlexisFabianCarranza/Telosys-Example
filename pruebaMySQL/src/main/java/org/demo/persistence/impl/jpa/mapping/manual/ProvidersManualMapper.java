/*
 * Created on 2020-06-09 ( Date ISO 2020-06-09 - Time 12:08:43 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.1.2
 */
package org.demo.persistence.impl.jpa.mapping.manual;

import org.demo.data.record.ProvidersRecord;
import org.demo.persistence.impl.jpa.mapping.JpaMapper;
import org.demo.persistence.impl.jpa.record.ProvidersJpaRecord;

/**
 * Manual mapping for "Providers" 
 *
 * @author Telosys
 *
 */
public class ProvidersManualMapper implements JpaMapper<ProvidersJpaRecord, ProvidersRecord> {

	@Override
	public ProvidersRecord mapEntityToRecord(ProvidersJpaRecord entity) {
		if ( entity == null ) return null ;
		ProvidersRecord pojo = new ProvidersRecord();
		pojo.setId(entity.getId()); 
		pojo.setUserid(entity.getUserid()); 
		pojo.setPhone(entity.getPhone()); 
		pojo.setDescription(entity.getDescription()); 
		pojo.setAddress(entity.getAddress()); 
		pojo.setCreatedat(entity.getCreatedat()); 
		pojo.setUpdatedat(entity.getUpdatedat()); 
		return pojo;
	}

	@Override
	public ProvidersJpaRecord mapRecordToEntity(ProvidersRecord pojo) {
		if ( pojo == null ) return null ;
		ProvidersJpaRecord entity = new ProvidersJpaRecord();
		entity.setId(pojo.getId()); 
		entity.setUserid(pojo.getUserid()); 
		entity.setPhone(pojo.getPhone()); 
		entity.setDescription(pojo.getDescription()); 
		entity.setAddress(pojo.getAddress()); 
		entity.setCreatedat(pojo.getCreatedat()); 
		entity.setUpdatedat(pojo.getUpdatedat()); 
		return entity;
	}

}
