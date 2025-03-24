package com.cye.dms.service;

import com.cye.dms.dto.DmsSectionConfigDto;

public interface DmsSectionConfigService {

        DmsSectionConfigDto create(DmsSectionConfigDto dmsSectionConfigDto);
        DmsSectionConfigDto findById(Long id);
        DmsSectionConfigDto update(Long id,  DmsSectionConfigDto dmsSectionConfigDto);            
        void delete(Long id);
}
