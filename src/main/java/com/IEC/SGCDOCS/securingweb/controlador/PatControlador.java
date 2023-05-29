package com.IEC.SGCDOCS.securingweb.controlador;

import com.IEC.SGCDOCS.securingweb.modelos.Pronosticos;
import com.IEC.SGCDOCS.securingweb.servicios.PatServicio;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import javax.ws.rs.*;
import java.util.List;

//@Component
//@Path("/pat")
@RestController
public class PatControlador {

    private final PatServicio patServicio;


    public PatControlador(PatServicio patServicio) {
        this.patServicio = patServicio;

    }
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
    @RequestMapping("/api2/pat/lista")
//    @Path("/pat/lista2")
//    @Produces("aplication/json")
    public String textoDevuelto(){
        System.out.println("lista2");
        return "{Mensaje:Hola...}";
    }

}

