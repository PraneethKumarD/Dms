package com.cye.dms.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cye.dms.dto.DmsSectionConfigDto;
import com.cye.dms.entity.DmsSectionConfig;
import com.cye.dms.exception.DmsFormConfigNotFoundException;
import com.cye.dms.exception.DmsSectionConfigNotFoundException;
import com.cye.dms.mapper.DmsSectionConfigMapper;
import com.cye.dms.repository.DmsSectionConfigRepository;

@Service
public class DmsSectionConfigServiceImpl implements DmsSectionConfigService{

     @Autowired
    private DmsSectionConfigRepository dmsSectionConfigRepository;

    public DmsSectionConfigDto createDmsSectionConfig(DmsSectionConfigDto dmsSectionConfigDto) {
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
    public DmsSectionConfigDto getDmsSectionConfigById(Long id) {

        DmsSectionConfig dmsSectionConfig = dmsSectionConfigRepository.findById(id)
                .orElseThrow(() -> new DmsSectionConfigNotFoundException("DmsFormConfig cannot be found with id " + id));

        return DmsSectionConfigMapper.toDto(dmsSectionConfig);
    }

    @Override
    public DmsSectionConfigDto updateDmsSectionConfig(Long id, DmsSectionConfigDto dmsSectionConfigDto) {

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
    public void deleteDmsSectionConfig(Long id) {
        
        DmsSectionConfig dmsSectionConfig = dmsSectionConfigRepository.findById(id)
                .orElseThrow(() -> new DmsSectionConfigNotFoundException("DmsSectionConfig cannot be found with id " + id));
             dmsSectionConfigRepository.delete(dmsSectionConfig);
                
    }

     @Override
    public List<DmsSectionConfigDto> getAllDmsSectionConfig() {
       List<DmsSectionConfig>  dmsSectionconfig = dmsSectionConfigRepository.findAll();
       List<DmsSectionConfigDto> dmsFormConfigDtos = new  ArrayList<>();
       for(DmsSectionConfig dmsSectionConfig2 :  dmsSectionconfig){
        dmsFormConfigDtos.add(DmsSectionConfigMapper.toDto(dmsSectionConfig2));
       }
       return dmsFormConfigDtos;
    }

}
