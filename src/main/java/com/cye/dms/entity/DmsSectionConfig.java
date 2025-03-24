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
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "dms_section_config")
public class DmsSectionConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "org_id")
    private Integer orgId;

    @Column(name = "service_type_id")
    private Integer serviceTypeId;

    @Column(name = "form_id")
    private Integer formId;

    @Column(name = "default_section_name")
    private String defaultSectionName;

    @Column(name = "default_section_description")
    private String defaultSectionDescription;

    @Column(name = "display_section_name")
    private String displaySectionName;

    @Column(name = "position")
    private Integer position;

    @Column(name = "created_at")
    private LocalDateTime createdAt = LocalDateTime.now();

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt = LocalDateTime.now();

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "active")
    private Boolean active;

}
