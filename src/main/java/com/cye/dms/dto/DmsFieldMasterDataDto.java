package com.cye.dms.dto;

import java.time.LocalDateTime;


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
public class DmsFieldMasterDataDto {

    
 @NotNull(message = "Organization ID cannot be null")
    private Integer orgId;

    private Integer serviceTypeId;

    private Integer categoryId;

    private Integer position;

    @NotBlank(message = "Column Name cannot be blank")
    @Size(max = 100, message = "Column Name must be at most 100 characters")
    private String columnName;

    @NotBlank(message = "Table Name cannot be blank")
    @Size(max = 100, message = "Table Name must be at most 100 characters")
    private String tableName;

    @NotBlank(message = "Default Label Name cannot be blank")
    @Size(max = 100, message = "Default Label Name must be at most 100 characters")
    private String defaultLabelName;

    @Size(max = 45, message = "Default Label Description must be at most 45 characters")
    private String defaultLabelDescription;

    @NotBlank(message = "Display Label Name cannot be blank")
    @Size(max = 100, message = "Display Label Name must be at most 100 characters")
    private String displayLabelName;

    @Size(max = 100, message = "Date Type must be at most 100 characters")
    private String dateType;

    @NotBlank(message = "Field Type cannot be blank")
    @Size(max = 100, message = "Field Type must be at most 100 characters")
    private String fieldType;

    @Size(max = 100, message = "Data Source Name must be at most 100 characters")
    private String dataSourceName;

    @Min(value = 1, message = "Max Length must be at least 1")
    private Integer maxLength;

    private Boolean isVisible;

    private Boolean isRequired;

    @Size(max = 500, message = "Validation rules must be at most 500 characters")
    private String validation;

    private Boolean isChangeAllowed;

    private LocalDateTime createdAt;

    private Integer createdBy;

    private LocalDateTime updatedAt;

    private Integer updatedBy;

    private Boolean active;


}
