package com.cye.dms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cye.dms.dto.DmsSectionConfigDto;
import com.cye.dms.service.DmsSectionConfigService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
@RestController
@RequestMapping("/api/dmssection")
@Tag(name = "DMS Section Config API", description = "Manage DMS Section Configurations")
public class DmsSectionConfigController {

    @Autowired
     private DmsSectionConfigService dmsSectionConfigService;

    @Operation(summary = "Create a new DMS Section Config", description = "Adds a new Section configuration to the system and returns the created object.")
    @ApiResponse(responseCode = "201", description = " successfully created.")
    @ApiResponse(responseCode = "500", description = "Internal server error.")
    @PostMapping("/save")
    public ResponseEntity<DmsSectionConfigDto> saveDmsFormConfig(@Valid @RequestBody DmsSectionConfigDto dmsSectionConfigDto)
    {
        DmsSectionConfigDto saveDmsSectionConfig = dmsSectionConfigService.create(dmsSectionConfigDto);

        return new ResponseEntity<>(saveDmsSectionConfig, HttpStatus.CREATED);
    }


    @Operation(
        summary = "Get a DMS Section Config by ID",
        description = "Fetches a section configuration by its unique ID."
    )
    @ApiResponse(responseCode = "201", description = " successfully created.")
    @ApiResponse(responseCode = "500", description = "Internal server error.")
    @GetMapping("/id/{id}")
    public ResponseEntity<DmsSectionConfigDto> getbyid(@PathVariable Long id)
    {
        DmsSectionConfigDto gotDmsSectionConfig =   dmsSectionConfigService.findById(id);
       return  new ResponseEntity<>(gotDmsSectionConfig, HttpStatus.OK);
    }
    

    @Operation(
        summary = "Update a DMS section Config",
        description = "Updates an existing section configuration based on the provided ID."
    )
    @ApiResponse(responseCode = "201", description = " successfully created.")
    @ApiResponse(responseCode = "500", description = "Internal server error.")
    @PutMapping("/id")
    public ResponseEntity<DmsSectionConfigDto> updateDms(@RequestParam Long id,
            @Valid @RequestBody DmsSectionConfigDto dmsSectionConfigDto) {
                DmsSectionConfigDto updatedDms = dmsSectionConfigService.update(id, dmsSectionConfigDto);
        return new ResponseEntity<>(updatedDms, HttpStatus.OK);
    }

    @Operation(
        summary = "Delete a DMS section Config",
        description = "Removes a section configuration from the system by its ID."
    )
    @ApiResponse(responseCode = "201", description = " successfully created.")
    @ApiResponse(responseCode = "500", description = "Internal server error.")
    @DeleteMapping("/delete/id")
    public ResponseEntity<Void> deleteEmployee(@RequestParam Long id) {
        dmsSectionConfigService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
