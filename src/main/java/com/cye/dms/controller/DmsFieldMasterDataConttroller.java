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

import com.cye.dms.dto.DmsFieldMasterDataDto;
import com.cye.dms.service.DmsFieldMasterDataService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/dmsfield")
@Tag(name = "DMS Field Master Data API", description = "Manage DMS Field Master Data")
public class DmsFieldMasterDataConttroller {

    @Autowired
    private DmsFieldMasterDataService dmsFieldMasterDataService;

    @Operation(summary = "Create a new DMS Field Master Data", description = "Adds a new  Master Data to the system and returns the created object.")
    @ApiResponse(responseCode = "201", description = " successfully created.")
    @ApiResponse(responseCode = "500", description = "Internal server error.")
    @PostMapping("/save")
    public ResponseEntity<DmsFieldMasterDataDto>  create(@Valid @RequestBody DmsFieldMasterDataDto dmsFieldMasterDataDto)
    {   
       DmsFieldMasterDataDto savedDmsFieldMasterData= dmsFieldMasterDataService.create(dmsFieldMasterDataDto);
        
       return  new ResponseEntity<>(savedDmsFieldMasterData , HttpStatus.CREATED);
    }


    @Operation(
        summary = "Delete a DMS  Field Master Data",
        description = "Removes a Field Master Data the system by its ID."
    )
    @ApiResponse(responseCode = "201", description = " successfully created.")
    @ApiResponse(responseCode = "500", description = "Internal server error.")
    @DeleteMapping("/delete/id")
    public ResponseEntity<Void> deleteEmployee(@RequestParam Long id) {
        dmsFieldMasterDataService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @Operation(
        summary = "Get a DMS Field Master Data by ID",
        description = "Fetches a form Field data by its unique ID."
    )
    @ApiResponse(responseCode = "201", description = " successfully created.")
    @ApiResponse(responseCode = "500", description = "Internal server error.")
    @GetMapping("/id/{id}")
    public ResponseEntity<DmsFieldMasterDataDto> getbyid(@PathVariable Long id)
    {
        DmsFieldMasterDataDto dmsFieldMasterData =   dmsFieldMasterDataService.findById(id);
       return  new ResponseEntity<>(dmsFieldMasterData, HttpStatus.OK);
    }


    @Operation(
        summary = "Update a DMS Feilds Master Data",
        description = "Updates an existing master data based on the provided ID."
    )
    @ApiResponse(responseCode = "201", description = " successfully created.")
    @ApiResponse(responseCode = "500", description = "Internal server error.")
    @PutMapping("/id")
    public ResponseEntity<DmsFieldMasterDataDto> updateDms(@RequestParam Long id,
            @Valid @RequestBody DmsFieldMasterDataDto dmsFieldMasterDataDto) {
        DmsFieldMasterDataDto updatedDms = dmsFieldMasterDataService.update(id, dmsFieldMasterDataDto);
        return new ResponseEntity<>(updatedDms, HttpStatus.OK);
    }
}
