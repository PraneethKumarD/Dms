package com.cye.dms.service;

import java.time.LocalDateTime;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cye.dms.dto.DmsFieldMasterDataDto;
import com.cye.dms.entity.DmsFieldMasterData;
import com.cye.dms.exception.DmsFieldMasterDataNotFoundException;
import com.cye.dms.exception.DmsFormConfigNotFoundException;
import com.cye.dms.mapper.DmsFieldMasterDataMapper;
import com.cye.dms.repository.DmsFieldMasterDataRepository;

@Service
public class DmsFieldMasterDataServiceImpl implements DmsFieldMasterDataService {

    @Autowired
    private DmsFieldMasterDataRepository dmsFieldMasterDataRepository;

    @Override
    public DmsFieldMasterDataDto create(DmsFieldMasterDataDto dmsFieldMasterDataDto) {
        try {
            if (dmsFieldMasterDataDto.getCreatedAt() == null) {
                dmsFieldMasterDataDto.setCreatedAt(LocalDateTime.now());
            }

            DmsFieldMasterData dmsFieldMasterData = DmsFieldMasterDataMapper.toEntity(dmsFieldMasterDataDto);
            DmsFieldMasterData savedDmsFieldMasterData = dmsFieldMasterDataRepository.save(dmsFieldMasterData);

            return DmsFieldMasterDataMapper.toDto(savedDmsFieldMasterData);
        } catch (Exception e) {
            throw new ServiceException("Error while creating DmsFieldMasterData", e);
        }
        }

    @Override
     public DmsFieldMasterDataDto findById(Long id) {
    return dmsFieldMasterDataRepository.findById(id)
        .map(DmsFieldMasterDataMapper::toDto)
        .orElseThrow(() -> new DmsFormConfigNotFoundException("DmsFormConfig with ID " + id + " not found."));
}
       
    

    @Override
    public DmsFieldMasterDataDto update(Long id, DmsFieldMasterDataDto dmsFieldMasterDataDto) {
       
        DmsFieldMasterData dmsFieldMasterData = dmsFieldMasterDataRepository.findById(id)
                .orElseThrow(() -> new DmsFieldMasterDataNotFoundException("DmsFieldMasterData not found with id " + id));
    
        dmsFieldMasterData.setActive(dmsFieldMasterDataDto.getActive());
        dmsFieldMasterData.setCategoryId(dmsFieldMasterDataDto.getCategoryId());
        dmsFieldMasterData.setColumnName(dmsFieldMasterDataDto.getColumnName());
        dmsFieldMasterData.setDataSourceName(dmsFieldMasterDataDto.getDataSourceName());
        dmsFieldMasterData.setDateType(dmsFieldMasterDataDto.getDateType());
        dmsFieldMasterData.setDefaultLabelDescription(dmsFieldMasterDataDto.getDefaultLabelDescription());
        dmsFieldMasterData.setDefaultLabelName(dmsFieldMasterDataDto.getDefaultLabelName());
        dmsFieldMasterData.setDisplayLabelName(dmsFieldMasterDataDto.getDisplayLabelName());
        dmsFieldMasterData.setFieldType(dmsFieldMasterDataDto.getFieldType());
        dmsFieldMasterData.setIsChangeAllowed(dmsFieldMasterDataDto.getIsChangeAllowed());
        dmsFieldMasterData.setIsRequired(dmsFieldMasterDataDto.getIsRequired());
        dmsFieldMasterData.setIsVisible(dmsFieldMasterDataDto.getIsVisible());
        dmsFieldMasterData.setMaxLength(dmsFieldMasterDataDto.getMaxLength());
        dmsFieldMasterData.setOrgId(dmsFieldMasterDataDto.getOrgId());
        dmsFieldMasterData.setPosition(dmsFieldMasterData.getPosition());
        dmsFieldMasterData.setServiceTypeId(dmsFieldMasterDataDto.getServiceTypeId());
        dmsFieldMasterData.setTableName(dmsFieldMasterDataDto.getTableName());
       
        dmsFieldMasterData.setValidation(dmsFieldMasterDataDto.getValidation());
        
      
        if (dmsFieldMasterDataDto.getUpdatedAt() == null) {
            dmsFieldMasterData.setUpdatedAt(LocalDateTime.now());
        } else {
            dmsFieldMasterData.setUpdatedAt(dmsFieldMasterDataDto.getUpdatedAt());
        }    
        dmsFieldMasterData.setUpdatedBy(dmsFieldMasterDataDto.getUpdatedBy());
    
        
        DmsFieldMasterData updatedDmsFieldMasterData = dmsFieldMasterDataRepository.save(dmsFieldMasterData);
        return DmsFieldMasterDataMapper.toDto(updatedDmsFieldMasterData);
    }
    

    @Override
    public void delete(Long id) {
        
        DmsFieldMasterData dmsFieldMasterData = dmsFieldMasterDataRepository.findById(id)
                .orElseThrow(() -> new DmsFormConfigNotFoundException("DmsFormConfig cannot be found with id " + id));
             dmsFieldMasterDataRepository.delete(dmsFieldMasterData);
    }

   

}
