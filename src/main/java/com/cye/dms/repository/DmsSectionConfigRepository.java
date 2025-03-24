package com.cye.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cye.dms.entity.DmsSectionConfig;

@Repository
public interface DmsSectionConfigRepository extends JpaRepository<DmsSectionConfig, Long>{

}
