package com.isi.metier.dto;

import java.util.List;

public class SectorDto {

    private Long id;
    private String name;
    private List<ClassDto> classes;

    public SectorDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<ClassDto> getClasses() {
        return classes;
    }

    public void setClasses(List<ClassDto> classes) {
        this.classes = classes;
    }
}