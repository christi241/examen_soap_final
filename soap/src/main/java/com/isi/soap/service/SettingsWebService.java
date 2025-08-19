package com.isi.soap.service;

import com.isi.metier.dto.ClassDto;
import com.isi.metier.dto.SectorDto;
import com.isi.metier.entity.Classes;
import com.isi.metier.entity.Sectors;
import com.isi.metier.service.ISettingsService;
import com.isi.metier.service.SettingsServiceImpl;
import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "com.isi.metier.service.ISettingsService")
public class SettingsWebService implements ISettingsService {

    private ISettingsService settingsService = new SettingsServiceImpl();

    @Override
    public void addSector(Sectors sector) {
        settingsService.addSector(sector);
    }

    @Override
    public void addClass(Classes classe) {
        settingsService.addClass(classe);
    }

    @Override
    public List<ClassDto> getClassesBySector(long sectorId) {
        return settingsService.getClassesBySector(sectorId);
    }

    @Override
    public List<SectorDto> getAllSectors() {
        return settingsService.getAllSectors();
    }
}
