package com.warehouse_accounting.services.util;

import com.warehouse_accounting.models.Unit;
import com.warehouse_accounting.models.dto.UnitDto;

public class ConverterDto {
    private ConverterDto(){}

    public static Unit convertToModel (UnitDto unitDto){
        return Unit.builder()
                .id(unitDto.getId())
                .shortName(unitDto.getShortName())
                .fullName(unitDto.getFullName())
                .sortNumber(unitDto.getSortNumber())
                .build();
    }
    public static UnitDto convertToDto(Unit unit){
        return UnitDto.builder()
                .id(unit.getId())
                .shortName(unit.getShortName())
                .fullName(unit.getFullName())
                .sortNumber(unit.getSortNumber())
                .build();
    }
}
