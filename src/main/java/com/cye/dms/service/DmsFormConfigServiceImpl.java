package com.cye.dms.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cye.dms.dto.DmsFormConfigDto;
import com.cye.dms.entity.DmsFormConfig;
import com.cye.dms.exception.DmsFormConfigNotFoundException;
import com.cye.dms.mapper.DmsFormConfigMapper;
import com.cye.dms.repository.DmsFormConfigRepository;

@Service
public class DmsFormConfigServiceImpl implements DmsFormConfigService {

    @Autowired
    private DmsFormConfigRepository dmsFormConfigRepository;

    public DmsFormConfigDto create(DmsFormConfigDto dmsFormConfigDto) {
        try {
            if (dmsFormConfigDto.getCreatedAt() == null) {
                dmsFormConfigDto.setCreatedAt(LocalDateTime.now());
            }

            DmsFormConfig dmsFormConfig = DmsFormConfigMapper.toEntity(dmsFormConfigDto);
            DmsFormConfig savedDmsFormConfig = dmsFormConfigRepository.save(dmsFormConfig);

            return DmsFormConfigMapper.toDto(savedDmsFormConfig);
        } catch (Exception e) {
            throw new ServiceException("Error while creating DmsFormConfig", e);
        }
    }

    @Override
    public DmsFormConfigDto findById(Long id) {

        DmsFormConfig dmsFormConfig = dmsFormConfigRepository.findById(id)
                .orElseThrow(() -> new DmsFormConfigNotFoundException("DmsFormConfig cannot be found with id " + id));

        return DmsFormConfigMapper.toDto(dmsFormConfig);
    }

    @Override
    public DmsFormConfigDto update(Long id, DmsFormConfigDto dmsFormConfigDto) {

        DmsFormConfig dmsFormConfig = dmsFormConfigRepository.findById(id)
                .orElseThrow(() -> new DmsFormConfigNotFoundException("DmsFormConfig cannot be found with id " + id));
        dmsFormConfig.setOrgId(dmsFormConfigDto.getOrgId());
        dmsFormConfig.setServiceTypeId(dmsFormConfigDto.getServiceTypeId());
        dmsFormConfig.setActive(dmsFormConfigDto.getActive());

        if (dmsFormConfigDto.getUpdatedAt() == null) {
            dmsFormConfig.setUpdatedAt(LocalDateTime.now());
        } else {
            dmsFormConfig.setUpdatedAt(dmsFormConfigDto.getUpdatedAt());
        }

        dmsFormConfig.setUpdatedBy(dmsFormConfigDto.getUpdatedBy());

        dmsFormConfig.setDisplayFormName(dmsFormConfigDto.getDisplayFormName());
        dmsFormConfig.setFormName(dmsFormConfigDto.getFormName());
        dmsFormConfig.setStageId(dmsFormConfigDto.getStageId());
        DmsFormConfig updatedDmsFormConfig = dmsFormConfigRepository.save(dmsFormConfig);
        return DmsFormConfigMapper.toDto(updatedDmsFormConfig);
    }

    @Override
    public void delete(Long id) {
        
        DmsFormConfig dmsFormConfig = dmsFormConfigRepository.findById(id)
                .orElseThrow(() -> new DmsFormConfigNotFoundException("DmsFormConfig cannot be found with id " + id));
            
                dmsFormConfigRepository.delete(dmsFormConfig);
                
    }

    @Override
    public List<DmsFormConfigDto> findall() {
       List<DmsFormConfig>  dmsFormconfig = dmsFormConfigRepository.findAll();
       List<DmsFormConfigDto> dmsFormConfigDtos = new  ArrayList<>();
       for(DmsFormConfig dmsFormConfig2 :  dmsFormconfig){
        dmsFormConfigDtos.add(DmsFormConfigMapper.toDto(dmsFormConfig2));
       }
       return dmsFormConfigDtos;
    }

     
}
