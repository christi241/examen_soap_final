package com.isi.metier.service;

import com.isi.metier.dao.IClassesDAO;
import com.isi.metier.dao.ISectorsDAO;
import com.isi.metier.dao.ClassesDAOImpl;
import com.isi.metier.dao.SectorsDAOImpl;
import com.isi.metier.dto.ClassDto;
import com.isi.metier.dto.SectorDto;
import com.isi.metier.entity.Sectors;
import com.isi.metier.entity.Classes;
import com.isi.metier.mapper.EntityToDtoMapper; // <-- Ajout de l'import du mapper
import java.util.List;
import java.util.stream.Collectors;

public class SettingsServiceImpl implements ISettingsService {
    private ISectorsDAO sectorsDAO = new SectorsDAOImpl();
    private IClassesDAO classesDAO = new ClassesDAOImpl();

    @Override
    public void addSector(Sectors sector) {
        sectorsDAO.addSector(sector);
    }

    @Override
    public void addClass(Classes classe) {
        classesDAO.addClass(classe);
    }

    @Override
    public List<ClassDto> getClassesBySector(long sectorId) {
        List<Classes> classes = classesDAO.getClassesBySectorId(sectorId);
        return classes.stream()
                .map(EntityToDtoMapper::toClassDto) // <-- Utilisation du mapper
                .collect(Collectors.toList());
    }

    @Override
    public List<SectorDto> getAllSectors() {
        List<Sectors> sectors = sectorsDAO.getAllSectors();
        return sectors.stream()
                .map(EntityToDtoMapper::toSectorDto) // <-- Utilisation du mapper
                .collect(Collectors.toList());
    }
}