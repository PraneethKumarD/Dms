package com.cye.dms.service;

import java.util.List;

import com.cye.dms.dto.DmsFieldMasterDataDto;



public interface DmsFieldMasterDataService {

      DmsFieldMasterDataDto create(DmsFieldMasterDataDto dmsFieldMasterDataDto);
       DmsFieldMasterDataDto findById(Long id);
       DmsFieldMasterDataDto update(Long id,  DmsFieldMasterDataDto dmsFieldMasterDataDto);            
        void delete(Long id);
         List<DmsFieldMasterDataDto> findall();
     
}
