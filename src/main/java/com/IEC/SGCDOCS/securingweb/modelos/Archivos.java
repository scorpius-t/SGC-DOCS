package com.IEC.SGCDOCS.securingweb.modelos;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class Archivos {
    private String fileName;
    private String path;

    public Archivos(String fileName) {
        this.fileName = fileName;
    }
}
