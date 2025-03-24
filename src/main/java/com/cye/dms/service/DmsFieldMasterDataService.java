package com.cye.dms.service;

import java.util.List;

import com.cye.dms.dto.DmsFieldMasterDataDto;



public interface DmsFieldMasterDataService {

      DmsFieldMasterDataDto createDmsFieldMasterData(DmsFieldMasterDataDto dmsFieldMasterDataDto);
       DmsFieldMasterDataDto getDmsFieldMasterDataById(Long id);
       DmsFieldMasterDataDto updateDmsFieldMasterData(Long id,  DmsFieldMasterDataDto dmsFieldMasterDataDto);            
        void deleteDmsFieldMasterData(Long id);
         List<DmsFieldMasterDataDto> getAllDmsFieldMasterData();
     
}
