package com.cye.dms.mapper;

import com.cye.dms.dto.DmsFormConfigDto;
import com.cye.dms.entity.DmsFormConfig;

public class DmsFormConfigMapper {


    public static DmsFormConfigDto toDto(DmsFormConfig dmsFormConfig) {
        DmsFormConfigDto dto = new DmsFormConfigDto();
                  
        dto.setOrgId(dmsFormConfig.getOrgId());
        dto.setServiceTypeId(dmsFormConfig.getServiceTypeId());
        dto.setFormName(dmsFormConfig.getFormName());
        dto.setDisplayFormName(dmsFormConfig.getDisplayFormName());
        dto.setStageId(dmsFormConfig.getStageId());
        dto.setCreatedAt(dmsFormConfig.getCreatedAt());
        dto.setCreatedBy(dmsFormConfig.getCreatedBy());
        dto.setUpdatedAt(dmsFormConfig.getUpdatedAt());
        dto.setUpdatedBy(dmsFormConfig.getUpdatedBy());
        dto.setActive(dmsFormConfig.getActive());

       
        return dto;
    }

    // Convert DTO to Entity
    public static DmsFormConfig toEntity(DmsFormConfigDto dmsFormConfigDto) {
        DmsFormConfig entity = new DmsFormConfig();

        entity.setOrgId(dmsFormConfigDto.getOrgId());
        entity.setServiceTypeId(dmsFormConfigDto.getServiceTypeId());
        entity.setFormName(dmsFormConfigDto.getFormName());
        entity.setDisplayFormName(dmsFormConfigDto.getDisplayFormName());
        entity.setStageId(dmsFormConfigDto.getStageId());
        entity.setCreatedAt(dmsFormConfigDto.getCreatedAt());
        entity.setCreatedBy(dmsFormConfigDto.getCreatedBy());
        entity.setUpdatedAt(dmsFormConfigDto.getUpdatedAt());
        entity.setUpdatedBy(dmsFormConfigDto.getUpdatedBy());
        entity.setActive(dmsFormConfigDto.getActive());
       
        return entity;     
    }

}
