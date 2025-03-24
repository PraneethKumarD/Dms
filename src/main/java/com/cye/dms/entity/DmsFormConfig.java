package com.cye.dms.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "dms_form_config")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class DmsFormConfig {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "org_id")
    private Integer orgId;

    @Column(name = "service_type_id")
    private Integer serviceTypeId;

    @Column(name = "form_name")
    private String formName;

    @Column(name = "display_form_name")
    private String displayFormName;

    @Column(name = "stage_id")
    private Integer stageId;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "active")
    private Boolean active;

}
