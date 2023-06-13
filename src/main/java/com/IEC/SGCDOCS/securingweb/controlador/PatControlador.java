package com.IEC.SGCDOCS.securingweb.controlador;

import com.IEC.SGCDOCS.securingweb.modelos.DB.Pats;
import com.IEC.SGCDOCS.securingweb.modelos.Pronosticos;
import com.IEC.SGCDOCS.securingweb.repositorio.PatsRepositorio;
import com.IEC.SGCDOCS.securingweb.servicios.PatServicio;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import javax.ws.rs.*;
import java.util.List;
@Slf4j
//@Component
//@Path("/pat")
@RestController
@RequestMapping("/pat/")
public class PatControlador {

    @Autowired
    private PatServicio patServicio;

    @GetMapping("/lista")
    public List<Pats> getAllPats(){
        log.info("entrando a listapats");
        log.info(patServicio.toString());

        List<Pats> listadoPats= patServicio.getAll();
        System.out.println(listadoPats);
        return listadoPats;
    }

//
//    public PatControlador(PatServicio patServicio) {
//        this.patServicio = patServicio;
//
//    }
//
//
//    @RolesAllowed("USER")
////    @GET
//    @RequestMapping("/api2/pat/lista")
////    @Path("/pat/lista")
////    @Produces("aplication/json")
//    public List<Pronosticos> listarTodoPat(){
//        System.out.println("lista");
//        return patServicio.getAll();
//    }

    @RolesAllowed("USER")
//    @GET
    @RequestMapping("/lista2")
//    @Path("/pat/lista2")
//    @Produces("aplication/json")
    public String textoDevuelto(){
        System.out.println("lista2");
        return "{Mensaje:Hola...}";
    }

}

