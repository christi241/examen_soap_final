package com.isi.metier.dao;

import com.isi.metier.entity.Classes;
import java.util.List;

public interface IClassesDAO {
    void addClass(Classes classe);
    List<Classes> getClassesBySectorId(long sectorId);
    List<Classes> getAllClasses();
}