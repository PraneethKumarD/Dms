package com.cye.dms.service;





import java.util.List;

import com.cye.dms.dto.DmsFormConfigDto;



public interface DmsFormConfigService {

        DmsFormConfigDto createDmsFormConfig(DmsFormConfigDto dmsFormConfigDto);
        DmsFormConfigDto getDmsFormConfigById(Long id);
        DmsFormConfigDto updateDmsFormConfig(Long id,  DmsFormConfigDto dmsFormConfigDto);            
        void deleteDmsFormConfig(Long id);
        List<DmsFormConfigDto> getAllDmsFormConfigs();
}
