package com.IEC.SGCDOCS.securingweb.controlador;

import com.IEC.SGCDOCS.SgcDocsApplication;
import com.IEC.SGCDOCS.securingweb.modelos.Archivos;
import com.IEC.SGCDOCS.securingweb.servicios.ArchivosServicio;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
@RequestMapping("/archivos/")
public class ArchivosControlador {
    ArchivosServicio archivosServicio =new ArchivosServicio();
    @GetMapping("/lista-Formularios")
    List<Archivos> listarFormularios(){
        List<Archivos> lista=archivosServicio.listarArchivos(SgcDocsApplication.conf.getPathFormularios());
    return lista;
    }

    @GetMapping("/lista-Cli1")
    List<Archivos> listarDocsCli1(){
        List<Archivos> lista=archivosServicio.listarArchivos(SgcDocsApplication.conf.getPathDocsCliente1());
        return lista;
    }

    @GetMapping("/lista-Cli2")
    List<Archivos> listarDocsCli2(){
        List<Archivos> lista=archivosServicio.listarArchivos(SgcDocsApplication.conf.getPathDocsCliente2());
        return lista;
    }

    @GetMapping("/lista-Cli3")
    List<Archivos> listarDocsCli3(){
        List<Archivos> lista=archivosServicio.listarArchivos(SgcDocsApplication.conf.getPathDocsCliente3());
        return lista;
    }

    @GetMapping("/lista-Manual1")
    List<Archivos> listarManual1(){
        List<Archivos> lista=archivosServicio.listarArchivos(SgcDocsApplication.conf.getPathManualProc1());
        return lista;
    }

    @GetMapping("/lista-Manual2")
    List<Archivos> listarManual2(){
        List<Archivos> lista=archivosServicio.listarArchivos(SgcDocsApplication.conf.getPathManualProc2());
        return lista;
    }

    @GetMapping("/lista-Manual3")
    List<Archivos> listarManual3(){
        List<Archivos> lista=archivosServicio.listarArchivos(SgcDocsApplication.conf.getPathManualProc3());
        return lista;
    }

}
