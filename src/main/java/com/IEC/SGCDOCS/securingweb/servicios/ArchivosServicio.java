package com.IEC.SGCDOCS.securingweb.servicios;

import com.IEC.SGCDOCS.securingweb.modelos.Archivos;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ArchivosServicio {

    public List<Archivos> listarArchivos(String path) {

        List<Archivos> archivos = Stream.of(new File(path).listFiles())
                .filter(file -> !file.isDirectory())
                .map(file -> new Archivos(file.getName()))
                .collect(Collectors.toList());
        return archivos;
    }
}
//
//    public List<Archivos> listarArchivos(String path) {
//
//        List<Archivos> archivos = Stream.of(new File(path).listFiles())
//                .filter(file -> !file.isDirectory())
//                .map(File::getName)
//                .collect(Collectors.toList());
//        return archivos;
//    }