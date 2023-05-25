package com.IEC.SGCDOCS.securingweb.controlador;

import com.IEC.SGCDOCS.securingweb.modelos.Pronosticos;
import com.IEC.SGCDOCS.securingweb.servicios.PatServicio;
import org.springframework.stereotype.Component;
import javax.ws.rs.*;
import java.util.List;

@Component
@Path("/pat")
public class PatControlador {

    private final PatServicio patServicio;


    public PatControlador(PatServicio patServicio) {
        this.patServicio = patServicio;

    }


    @GET
    @Path("/pat/lista")
    @Produces("aplication/json")
    public List<Pronosticos> listarTodoPat(){
        System.out.println("lista");
        return patServicio.getAll();
    }

    @GET
    @Path("/pat/lista2")
    @Produces("aplication/json")
    public String textoDevuelto(){
        System.out.println("lista2");
        return "{Mensaje:Hola...}";
    }

}

