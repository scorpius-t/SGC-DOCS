package com.IEC.SGCDOCS.securingweb.controlador;
import com.IEC.SGCDOCS.securingweb.modelos.DB.DistribucionDocumentos;
import com.IEC.SGCDOCS.securingweb.servicios.DistribucionDocumentosServicio;
import jakarta.annotation.security.RolesAllowed;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j

@RestController
@RequestMapping("/distribDocs/")
public class DistribucionDocumentosControlador {

    @Autowired
    private DistribucionDocumentosServicio distribucionDocumentosServicio;

    @GetMapping("/lista")
    public List<DistribucionDocumentos> getAllPats(){
        log.info("entrando a listaDistribucion");
        log.info(distribucionDocumentosServicio.toString());

        List<DistribucionDocumentos> listadoDistribDocs= distribucionDocumentosServicio.getAll();
        System.out.println(listadoDistribDocs);
        return listadoDistribDocs;
    }


    @RolesAllowed("USER")
    @RequestMapping("/lista2")
    public String textoDevuelto(){
        System.out.println("lista2");
        return "{Mensaje:Hola...}";
    }

}
