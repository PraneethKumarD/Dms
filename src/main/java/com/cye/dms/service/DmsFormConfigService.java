package com.cye.dms.service;





import java.util.List;

import com.cye.dms.dto.DmsFormConfigDto;



public interface DmsFormConfigService {

        DmsFormConfigDto create(DmsFormConfigDto dmsFormConfigDto);
        DmsFormConfigDto findById(Long id);
        DmsFormConfigDto update(Long id,  DmsFormConfigDto dmsFormConfigDto);            
        void delete(Long id);
        List<DmsFormConfigDto> findall();
}
