package com.cye.dms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cye.dms.entity.DmsFormConfig;


@Repository
public interface DmsFormConfigRepository  extends JpaRepository<DmsFormConfig, Long>{

}
