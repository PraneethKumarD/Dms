package com.cye.dms.service;

import java.util.List;

import com.cye.dms.dto.DmsSectionConfigDto;

public interface DmsSectionConfigService {

        DmsSectionConfigDto createDmsSectionConfig(DmsSectionConfigDto dmsSectionConfigDto);
        DmsSectionConfigDto getDmsSectionConfigById(Long id);
        DmsSectionConfigDto updateDmsSectionConfig(Long id,  DmsSectionConfigDto dmsSectionConfigDto);            
        void deleteDmsSectionConfig(Long id);
        List<DmsSectionConfigDto> getAllDmsSectionConfig();
}
