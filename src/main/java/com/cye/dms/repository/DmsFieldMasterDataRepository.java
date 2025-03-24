package com.cye.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cye.dms.entity.DmsFieldMasterData;

@Repository
public interface DmsFieldMasterDataRepository extends JpaRepository<DmsFieldMasterData, Long>{

}
