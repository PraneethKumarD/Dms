package com.cye.dms.mapper;

import com.cye.dms.dto.DmsFieldMasterDataDto;
import com.cye.dms.entity.DmsFieldMasterData;

public class DmsFieldMasterDataMapper {
    // Convert Entity to DTO
    public static DmsFieldMasterDataDto toDto(DmsFieldMasterData entity) {
        if (entity == null) {
            return null;
        }

        DmsFieldMasterDataDto dto = new DmsFieldMasterDataDto();

        dto.setOrgId(entity.getOrgId());
        dto.setServiceTypeId(entity.getServiceTypeId());
        dto.setCategoryId(entity.getCategoryId());
        dto.setPosition(entity.getPosition());
        dto.setColumnName(entity.getColumnName());
        dto.setTableName(entity.getTableName());
        dto.setDefaultLabelName(entity.getDefaultLabelName());
        dto.setDefaultLabelDescription(entity.getDefaultLabelDescription());
        dto.setDisplayLabelName(entity.getDisplayLabelName());
        dto.setDateType(entity.getDateType());
        dto.setFieldType(entity.getFieldType());
        dto.setDataSourceName(entity.getDataSourceName());
        dto.setMaxLength(entity.getMaxLength());
        dto.setIsVisible(entity.getIsVisible());
        dto.setIsRequired(entity.getIsRequired());
        dto.setValidation(entity.getValidation());
        dto.setIsChangeAllowed(entity.getIsChangeAllowed());
        dto.setCreatedAt(entity.getCreatedAt());
        dto.setCreatedBy(entity.getCreatedBy());
        dto.setUpdatedAt(entity.getUpdatedAt());
        dto.setUpdatedBy(entity.getUpdatedBy());
        dto.setActive(entity.getActive());

        return dto;
    }

    // Convert DTO to Entity
    public static DmsFieldMasterData toEntity(DmsFieldMasterDataDto dto) {
        if (dto == null) {
            return null;
        }

        DmsFieldMasterData entity = new DmsFieldMasterData();

        entity.setOrgId(dto.getOrgId());
        entity.setServiceTypeId(dto.getServiceTypeId());
        entity.setCategoryId(dto.getCategoryId());
        entity.setPosition(dto.getPosition());
        entity.setColumnName(dto.getColumnName());
        entity.setTableName(dto.getTableName());
        entity.setDefaultLabelName(dto.getDefaultLabelName());
        entity.setDefaultLabelDescription(dto.getDefaultLabelDescription());
        entity.setDisplayLabelName(dto.getDisplayLabelName());
        entity.setDateType(dto.getDateType());
        entity.setFieldType(dto.getFieldType());
        entity.setDataSourceName(dto.getDataSourceName());
        entity.setMaxLength(dto.getMaxLength());
        entity.setIsVisible(dto.getIsVisible());
        entity.setIsRequired(dto.getIsRequired());
        entity.setValidation(dto.getValidation());
        entity.setIsChangeAllowed(dto.getIsChangeAllowed());
        entity.setCreatedAt(dto.getCreatedAt());
        entity.setCreatedBy(dto.getCreatedBy());
        entity.setUpdatedAt(dto.getUpdatedAt());
        entity.setUpdatedBy(dto.getUpdatedBy());
        entity.setActive(dto.getActive());

        return entity;
    }
}
