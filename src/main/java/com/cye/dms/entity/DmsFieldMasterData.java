package com.cye.dms.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "dms_field_master_data")
public class DmsFieldMasterData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "org_id", nullable = false)
    private Integer orgId;

    @Column(name = "service_type_id")
    private Integer serviceTypeId;

    @Column(name = "category_id")
    private Integer categoryId;

    @Column(name = "position")
    private Integer position;

    @Column(name = "column_name")
    private String columnName;

    @Column(name = "table_name")
    private String tableName;

    @Column(name = "default_label_name")
    private String defaultLabelName;

    @Column(name = "default_label_description")
    private String defaultLabelDescription;

    @Column(name = "display_label_name")
    private String displayLabelName;

    @Column(name = "date_type")
    private String dateType;

    @Column(name = "field_type")
    private String fieldType;

    @Column(name = "data_source_name")
    private String dataSourceName;

    @Column(name = "max_lenght")
    private Integer maxLength; 

    @Column(name = "is_visible")
    private Boolean isVisible;

    @Column(name = "is_required")
    private Boolean isRequired;

    @Column(name = "validation" )
    private String validation;

    @Column(name = "is_change_allowed")
    private Boolean isChangeAllowed;

    @Column(name = "created_at")
    private LocalDateTime createdAt ;

    @Column(name = "created_by")
    private Integer createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt ;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "active")
    private Boolean active;
}

