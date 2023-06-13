package com.IEC.SGCDOCS.securingweb.controlador;
import com.IEC.SGCDOCS.securingweb.modelos.DB.DistribucionDocumentos;
import com.IEC.SGCDOCS.securingweb.modelos.DB.Integrantes;
import com.IEC.SGCDOCS.securingweb.modelos.DB.ReservaDocumentos;
import com.IEC.SGCDOCS.securingweb.servicios.DistribucionDocumentosServicio;
import com.IEC.SGCDOCS.securingweb.servicios.IntegrantesServicio;
import com.IEC.SGCDOCS.securingweb.servicios.ReservaDocumentosServicio;
import jakarta.annotation.security.RolesAllowed;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j

@RestController
@RequestMapping("/reservaDocs/")
public class ReservaDocumentosControlador {

    @Autowired
    private ReservaDocumentosServicio reservaDocumentosServicio;

    @GetMapping("/lista")
    public List<ReservaDocumentos> getAll(){
        log.info("entrando a listadeIntegrantes");
        log.info(reservaDocumentosServicio.toString());

        List<ReservaDocumentos> listaReservaDocs= reservaDocumentosServicio.getAll();
        System.out.println(listaReservaDocs);
        return listaReservaDocs;
    }


    @RolesAllowed("USER")
    @RequestMapping("/lista2")
    public String textoDevuelto(){
        System.out.println("lista2");
        return "{Mensaje:Hola...}";
    }

}