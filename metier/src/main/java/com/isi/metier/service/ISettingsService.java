package com.isi.metier.service;

import com.isi.metier.dto.ClassDto;
import com.isi.metier.dto.SectorDto;
import com.isi.metier.entity.Sectors;
import com.isi.metier.entity.Classes;
import jakarta.jws.WebService;
import java.util.List;

@WebService
public interface ISettingsService {
    void addSector(Sectors sector);
    void addClass(Classes classe);
    List<ClassDto> getClassesBySector(long sectorId); // <-- Modifié
    List<SectorDto> getAllSectors(); // <-- Modifié
}