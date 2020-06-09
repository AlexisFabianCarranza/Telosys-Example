/*
 * Created on 2020-06-09 ( Date ISO 2020-06-09 - Time 11:53:29 )
 * Generated by Telosys ( http://www.telosys.org/ ) version 3.1.2
 */
package org.demo.persistence.impl.springdatajpa.repository;

import org.demo.persistence.impl.jpa.record.ProviderxjobJpaRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * Spring data Jpa repository for "Providerxjob" <br>
 * @author Telosys (http://www.telosys.org/) version 3.1.2
 */
@Repository
public interface ProviderxjobRepository extends JpaRepository<ProviderxjobJpaRecord, Integer>, JpaSpecificationExecutor<ProviderxjobJpaRecord> {
}