package com.cye.dms.controller;

import java.util.List;

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

import com.cye.dms.dto.DmsFormConfigDto;
import com.cye.dms.service.DmsFormConfigService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/dmsformconfg")
@Tag(name = "DMS Form Config API", description = "Manage DMS Form Configurations")
public class DmsFormConfigController {

    @Autowired
    private DmsFormConfigService dmsFormConfigService;

    @Operation(summary = "Create a new DMS Form Config", description = "Adds a new form configuration to the system and returns the created object.")
    @ApiResponse(responseCode = "201", description = " successfully created.")
    @ApiResponse(responseCode = "500", description = "Internal server error.")
    @PostMapping("/save")
    public ResponseEntity<DmsFormConfigDto> saveDmsFormConfig(@Valid @RequestBody DmsFormConfigDto dmsFormConfigDto) {
        DmsFormConfigDto saveDmsFormConfig = dmsFormConfigService.create(dmsFormConfigDto);

        return new ResponseEntity<>(saveDmsFormConfig, HttpStatus.CREATED);
    }

    @Operation(summary = "Get a DMS Form Config by ID", description = "Fetches a form configuration by its unique ID.")
    @ApiResponse(responseCode = "201", description = " successfully fetched by id.")
    @ApiResponse(responseCode = "500", description = "Internal server error.")
    @GetMapping("/id/{id}")
    public ResponseEntity<DmsFormConfigDto> getbyid(@PathVariable Long id) {
        DmsFormConfigDto gotDmsFormConfig = dmsFormConfigService.findById(id);
        return new ResponseEntity<>(gotDmsFormConfig, HttpStatus.OK);
    }

    @Operation(summary = "Update a DMS Form Config", description = "Updates an existing form configuration based on the provided ID.")
    @ApiResponse(responseCode = "20", description = " successfully updated.")
    @ApiResponse(responseCode = "500", description = "Internal server error.")
    @PutMapping("/id")
    public ResponseEntity<DmsFormConfigDto> updateDms(@RequestParam Long id,
            @Valid @RequestBody DmsFormConfigDto dmsFormConfigDto) {
        DmsFormConfigDto updatedDms = dmsFormConfigService.update(id, dmsFormConfigDto);
        return new ResponseEntity<>(updatedDms, HttpStatus.OK);
    }

    @Operation(summary = "Delete a DMS Form Config", description = "Removes a form configuration from the system by its ID.")
    @ApiResponse(responseCode = "204", description = " Content NotFound")
    @ApiResponse(responseCode = "500", description = "Internal server error.")
    @DeleteMapping("/delete/id")
    public ResponseEntity<Void> deleteEmployee(@RequestParam Long id) {
        dmsFormConfigService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Fetching all data of DMS Form Config", description = "gets list of data of dms form  configuration from the DB.")
    @ApiResponse(responseCode = "200", description = " successfully fetched all details.")
    @ApiResponse(responseCode = "500", description = "Internal server error.")
    @GetMapping("/findall")
    public ResponseEntity<List<DmsFormConfigDto>> findall() {
        List<DmsFormConfigDto> listofDtos = dmsFormConfigService.findall();
        return new ResponseEntity<List<DmsFormConfigDto>>(listofDtos, HttpStatus.OK);
    }
}
