package com.isi.metier.dao;
import com.isi.metier.entity.Sectors;

import java.util.List;

public interface ISectorsDAO {
    void addSector(Sectors sector);
    Sectors getSectorById(long id);
    List<Sectors> getAllSectors();
}
