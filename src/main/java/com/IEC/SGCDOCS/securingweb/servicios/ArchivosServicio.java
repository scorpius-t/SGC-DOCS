package com.IEC.SGCDOCS.securingweb.servicios;

import com.IEC.SGCDOCS.securingweb.modelos.Archivos;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Slf4j
public class ArchivosServicio {

    public List<Archivos> listarArchivos(String path) {

        List<Archivos> archivos = Stream.of(new File(path).listFiles())
                .filter(file -> !file.isDirectory())
                .map(file -> new Archivos(file.getName()))
                .collect(Collectors.toList());
        archivos.forEach(a->a.setPath(path));
        log.info(archivos.toString());
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