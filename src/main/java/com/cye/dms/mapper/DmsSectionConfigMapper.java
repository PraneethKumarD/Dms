package com.cye.dms.mapper;

import com.cye.dms.dto.DmsSectionConfigDto;
import com.cye.dms.entity.DmsSectionConfig;

public class DmsSectionConfigMapper {

     public static DmsSectionConfigDto toDto(DmsSectionConfig entity) {
        if (entity == null) {
            return null;
        }

        DmsSectionConfigDto dto = new DmsSectionConfigDto();

        
        dto.setOrgId(entity.getOrgId());
        dto.setServiceTypeId(entity.getServiceTypeId());
        dto.setFormId(entity.getFormId());
        dto.setDefaultSectionName(entity.getDefaultSectionName());
        dto.setDefaultSectionDescription(entity.getDefaultSectionDescription());
        dto.setDisplaySectionName(entity.getDisplaySectionName());
        dto.setPosition(entity.getPosition());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setUpdatedBy(entity.getUpdatedBy());
        dto.setActive(entity.getActive());

        return dto;
    }

    // Convert DTO to Entity
    public static DmsSectionConfig toEntity(DmsSectionConfigDto dto) {
        if (dto == null) {
            return null;
        }

        DmsSectionConfig entity = new DmsSectionConfig();

       
        entity.setOrgId(dto.getOrgId());
        entity.setServiceTypeId(dto.getServiceTypeId());
        entity.setFormId(dto.getFormId());
        entity.setDefaultSectionName(dto.getDefaultSectionName());
        entity.setDefaultSectionDescription(dto.getDefaultSectionDescription());
        entity.setDisplaySectionName(dto.getDisplaySectionName());
        entity.setPosition(dto.getPosition());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setUpdatedBy(dto.getUpdatedBy());
        entity.setActive(dto.getActive());

        return entity;
    }

}
