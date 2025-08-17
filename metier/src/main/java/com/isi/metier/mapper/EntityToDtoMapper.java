package com.isi.metier.mapper;

import com.isi.metier.dto.ClassDto;
import com.isi.metier.dto.SectorDto;
import com.isi.metier.entity.Classes;
import com.isi.metier.entity.Sectors;

import java.util.stream.Collectors;

public class EntityToDtoMapper {

    public static SectorDto toSectorDto(Sectors sector) {
        if (sector == null) {
            return null;
        }
        SectorDto dto = new SectorDto();
        dto.setId(sector.getId());
        dto.setName(sector.getName());
        if (sector.getClasses() != null) {
            dto.setClasses(sector.getClasses().stream()
                    .map(EntityToDtoMapper::toClassDto)
                    .collect(Collectors.toList()));
        }
        return dto;
    }

    public static ClassDto toClassDto(Classes aClass) {
        if (aClass == null) {
            return null;
        }
        ClassDto dto = new ClassDto();
        dto.setId(aClass.getId());
        dto.setClassName(aClass.getClassName());
        dto.setDescription(aClass.getDescription());
        if (aClass.getSector() != null) {
            SectorDto sectorDto = new SectorDto();
            sectorDto.setId(aClass.getSector().getId());
            sectorDto.setName(aClass.getSector().getName());
            dto.setSector(sectorDto);
        }
        return dto;
    }
}