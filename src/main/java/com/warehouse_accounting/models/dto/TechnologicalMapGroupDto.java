package com.warehouse_accounting.models.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
/**
 * This DTO class for {@link com.warehouse_accounting.models.TechnologicalMapGroup}
 *
 * @author pavelsmirnov
 * @version 0.1
 * Created 24.03.2021
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TechnologicalMapGroupDto {

    private Long id;
    private String name;
    private String code;
    private String comment;

    private Long parentTechnologicalMapGroupId;
    private String parentTechnologicalMapGroupName;
}
