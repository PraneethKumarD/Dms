package com.cye.dms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/api/dmsFieldMasterData")
@Tag(name = "DMS Field Master Data API", description = "Manage DMS Field Master Data using crud operations")
public class DmsFieldMasterDataConttroller {

    @Autowired
    private DmsFieldMasterDataService dmsFieldMasterDataService;

    @Operation(summary = "Create a new DMS Field Master Data", description = "Adds a new  Master Data to the system and returns the created object.")
    @ApiResponse(responseCode = "201", description = " successfully created.")
    @ApiResponse(responseCode = "500", description = "Internal server error.")
    @PostMapping
    public ResponseEntity<DmsFieldMasterDataDto> create(
            @Valid @RequestBody DmsFieldMasterDataDto dmsFieldMasterDataDto) {
        DmsFieldMasterDataDto savedDmsFieldMasterData = dmsFieldMasterDataService.createDmsFieldMasterData(dmsFieldMasterDataDto);

        return new ResponseEntity<>(savedDmsFieldMasterData, HttpStatus.CREATED);
    }

    @Operation(summary = "Delete a DMS  Field Master Data", description = "Removes a Field Master Data the system by its ID.")
    @ApiResponse(responseCode = "201", description = " successfully created.")
    @ApiResponse(responseCode = "500", description = "Internal server error.")
    @DeleteMapping
    public ResponseEntity<Void> deleteEmployee(@RequestParam Long id) {
        dmsFieldMasterDataService.deleteDmsFieldMasterData(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @Operation(summary = "Get a DMS Field Master Data by ID", description = "Fetches a form Field data by its unique ID.")
    @ApiResponse(responseCode = "201", description = " successfully created.")
    @ApiResponse(responseCode = "500", description = "Internal server error.")
    @GetMapping
    public ResponseEntity<DmsFieldMasterDataDto> getbyid(@RequestParam Long id) {
        DmsFieldMasterDataDto dmsFieldMasterData = dmsFieldMasterDataService.getDmsFieldMasterDataById(id);
        return new ResponseEntity<>(dmsFieldMasterData, HttpStatus.OK);
    }

    @Operation(summary = "Update a DMS Feilds Master Data", description = "Updates an existing master data based on the provided ID.")
    @ApiResponse(responseCode = "201", description = " successfully created.")
    @ApiResponse(responseCode = "500", description = "Internal server error.")
    @PutMapping
    public ResponseEntity<DmsFieldMasterDataDto> updateDms(@RequestParam Long id,
            @Valid @RequestBody DmsFieldMasterDataDto dmsFieldMasterDataDto) {
        DmsFieldMasterDataDto updatedDms = dmsFieldMasterDataService.updateDmsFieldMasterData(id, dmsFieldMasterDataDto);
        return new ResponseEntity<>(updatedDms, HttpStatus.OK);
    }


    @Operation(summary = "Fetching all data of DMS Feild Master data", description = "gets list of data of dms field mastar data from the DB.")
    @ApiResponse(responseCode = "200", description = " successfully fetched all details.")
    @ApiResponse(responseCode = "500", description = "Internal server error.")
    @GetMapping("/findall")
    public ResponseEntity<List<DmsFieldMasterDataDto>> findall() {
        List<DmsFieldMasterDataDto> listofDtos = dmsFieldMasterDataService.getAllDmsFieldMasterData();
        return new ResponseEntity<List<DmsFieldMasterDataDto>>(listofDtos, HttpStatus.OK);
    }
}
