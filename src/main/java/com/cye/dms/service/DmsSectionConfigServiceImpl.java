package com.cye.dms.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cye.dms.dto.DmsFieldMasterDataDto;
import com.cye.dms.dto.DmsFormConfigDto;
import com.cye.dms.dto.DmsSectionConfigDto;
import com.cye.dms.entity.DmsFieldMasterData;
import com.cye.dms.entity.DmsFormConfig;
import com.cye.dms.entity.DmsSectionConfig;
import com.cye.dms.exception.DmsFormConfigNotFoundException;
import com.cye.dms.exception.DmsSectionConfigNotFoundException;
import com.cye.dms.mapper.DmsFormConfigMapper;
import com.cye.dms.mapper.DmsSectionConfigMapper;
import com.cye.dms.repository.DmsSectionConfigRepository;

@Service
public class DmsSectionConfigServiceImpl implements DmsSectionConfigService{

     @Autowired
    private DmsSectionConfigRepository dmsSectionConfigRepository;

    public DmsSectionConfigDto create(DmsSectionConfigDto dmsSectionConfigDto) {
        try {
            if (dmsSectionConfigDto.getCreatedAt() == null) {
                dmsSectionConfigDto.setCreatedAt(LocalDateTime.now());
            }

            DmsSectionConfig dmsSectionConfig = DmsSectionConfigMapper.toEntity(dmsSectionConfigDto);
            DmsSectionConfig saveddmsSectionConfig = dmsSectionConfigRepository.save(dmsSectionConfig);

            return DmsSectionConfigMapper.toDto(saveddmsSectionConfig);
        } catch (Exception e) {
            throw new ServiceException("Error while creating DmsFormConfig", e);
        }
    }

    @Override
    public DmsSectionConfigDto findById(Long id) {

        DmsSectionConfig dmsSectionConfig = dmsSectionConfigRepository.findById(id)
                .orElseThrow(() -> new DmsSectionConfigNotFoundException("DmsFormConfig cannot be found with id " + id));

        return DmsSectionConfigMapper.toDto(dmsSectionConfig);
    }

    @Override
    public DmsSectionConfigDto update(Long id, DmsSectionConfigDto dmsSectionConfigDto) {

        DmsSectionConfig dmsSectionConfig = dmsSectionConfigRepository.findById(id)
                .orElseThrow(() -> new DmsFormConfigNotFoundException("DmsFormConfig cannot be found with id " + id));
       
            dmsSectionConfig.setActive(dmsSectionConfigDto.getActive());
            dmsSectionConfig.setDefaultSectionDescription(dmsSectionConfigDto.getDefaultSectionDescription());
            dmsSectionConfig.setDefaultSectionName(dmsSectionConfigDto.getDefaultSectionName());
            dmsSectionConfig.setDisplaySectionName(dmsSectionConfigDto.getDefaultSectionName());
            dmsSectionConfig.setFormId(dmsSectionConfigDto.getFormId());
            dmsSectionConfig.setOrgId(dmsSectionConfigDto.getOrgId());
            dmsSectionConfig.setPosition(dmsSectionConfigDto.getPosition());
            dmsSectionConfig.setServiceTypeId(dmsSectionConfigDto.getServiceTypeId());
            


        if (dmsSectionConfig.getUpdatedAt() == null) {
            dmsSectionConfig.setUpdatedAt(LocalDateTime.now());
        } else {
            dmsSectionConfig.setUpdatedAt(dmsSectionConfigDto.getUpdatedAt());
        }

        dmsSectionConfig.setUpdatedBy(dmsSectionConfigDto.getUpdatedBy());

       
        DmsSectionConfig updatedDmsSectionConfig = dmsSectionConfigRepository.save(dmsSectionConfig);
        return DmsSectionConfigMapper.toDto(updatedDmsSectionConfig);
    }

    @Override
    public void delete(Long id) {
        
        DmsSectionConfig dmsSectionConfig = dmsSectionConfigRepository.findById(id)
                .orElseThrow(() -> new DmsSectionConfigNotFoundException("DmsSectionConfig cannot be found with id " + id));
             dmsSectionConfigRepository.delete(dmsSectionConfig);
                
    }

     @Override
    public List<DmsSectionConfigDto> findall() {
       List<DmsSectionConfig>  dmsSectionconfig = dmsSectionConfigRepository.findAll();
       List<DmsSectionConfigDto> dmsFormConfigDtos = new  ArrayList<>();
       for(DmsSectionConfig dmsSectionConfig2 :  dmsSectionconfig){
        dmsFormConfigDtos.add(DmsSectionConfigMapper.toDto(dmsSectionConfig2));
       }
       return dmsFormConfigDtos;
    }

}
