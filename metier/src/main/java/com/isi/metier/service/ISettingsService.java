package com.isi.metier.service;

import com.isi.metier.dto.ClassDto;
import com.isi.metier.dto.SectorDto;
import com.isi.metier.entity.Sectors;
import com.isi.metier.entity.Classes;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ISettingsService {

    @WebMethod
    void addSector(Sectors sector);

    @WebMethod
    void addClass(Classes classe);

    @WebMethod
    List<ClassDto> getClassesBySector(long sectorId);

    @WebMethod
    List<SectorDto> getAllSectors();
}
