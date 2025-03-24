package com.cye.dms.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DmsSectionConfigDto {

    @NotNull(message = "Organization ID cannot be null")
    private Integer orgId;

    private Integer serviceTypeId;
    private Integer formId;

    @NotBlank(message = "Default section name cannot be blank")
    @Size(max = 100, message = "Default section name must not exceed 100 characters")
    private String defaultSectionName;

    @Size(max = 100, message = "Default section description must not exceed 100 characters")
    private String defaultSectionDescription;

    @NotBlank(message = "Display section name cannot be blank")
    @Size(max = 100, message = "Display section name must not exceed 100 characters")
    private String displaySectionName;

    @Min(value = 1, message = "Position must be at least 1")
    private Integer position;

    private LocalDateTime createdAt;

    private Integer createdBy;

    private LocalDateTime updatedAt;

    private Integer updatedBy;

    @NotNull(message = "Active status cannot be null")
    private Boolean active;
}
