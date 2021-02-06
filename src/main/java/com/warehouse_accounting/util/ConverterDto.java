package com.warehouse_accounting.util;

import com.warehouse_accounting.models.Image;
import com.warehouse_accounting.models.Role;
import com.warehouse_accounting.models.dto.ImageDto;
import com.warehouse_accounting.models.dto.RoleDto;


public class ConverterDto {

    private ConverterDto() {
    }

    public static Image convertToModel (ImageDto imageDto){
        return Image.builder()
                .id(imageDto.getId())
                .imageUrl(imageDto.getImageUrl())
                .sortNumber(imageDto.getSortNumber())
                .build();
    }
    public static ImageDto convertToDto(Image image){
        return ImageDto.builder()
                .id(image.getId())
                .imageUrl(image.getImageUrl())
                .sortNumber(image.getSortNumber())
                .build();
    }

    public static RoleDto convertToDto(Role role) {
        return RoleDto.builder()
                .id(role.getId())
                .name(role.getName())
                .sortNumber(role.getSortNumber())
                .build();
    }

    public static Role convertToModel(RoleDto roleDto) {
        return Role.builder()
                .id(roleDto.getId())
                .name(roleDto.getName())
                .sortNumber(roleDto.getSortNumber())
                .build();
    }



}
