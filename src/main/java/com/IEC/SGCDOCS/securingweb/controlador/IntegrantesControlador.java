package com.IEC.SGCDOCS.securingweb.controlador;
import com.IEC.SGCDOCS.securingweb.modelos.DB.DistribucionDocumentos;
import com.IEC.SGCDOCS.securingweb.modelos.DB.Integrantes;
import com.IEC.SGCDOCS.securingweb.servicios.DistribucionDocumentosServicio;
import com.IEC.SGCDOCS.securingweb.servicios.IntegrantesServicio;
import jakarta.annotation.security.RolesAllowed;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@Slf4j

@RestController
@RequestMapping("/integrantes/")
public class IntegrantesControlador {

    @Autowired
    private IntegrantesServicio integrantesServicio;

    @GetMapping("/lista")
    public List<Integrantes> getAll(){
        log.info("entrando a listaIntegrantes");
        log.info(integrantesServicio.toString());

        List<Integrantes> listaIntegrantes= integrantesServicio.getAll();
        System.out.println(listaIntegrantes);
        return listaIntegrantes;
    }


    @RolesAllowed("USER")
    @RequestMapping("/lista2")
    public String textoDevuelto(){
        System.out.println("lista2");
        return "{Mensaje:Hola...}";
    }

}
