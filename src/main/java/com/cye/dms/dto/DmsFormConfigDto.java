package com.cye.dms.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class DmsFormConfigDto {


     
    
    @NotNull(message = "Organization ID cannot be null")
    private Integer orgId;

    
    private Integer serviceTypeId;

    @Size(max = 100, message = "Form name must not exceed 100 characters")
    private String formName;

    @Size(max = 100, message = "Display form name must not exceed 100 characters")
    private String displayFormName;

    
    private Integer stageId;

   
    private LocalDateTime createdAt;

   
    private Integer createdBy;

   
    private LocalDateTime updatedAt;

   
    private Integer updatedBy;

    
    private Boolean active;

}
