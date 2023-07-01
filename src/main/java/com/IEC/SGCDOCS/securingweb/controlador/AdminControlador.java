package com.IEC.SGCDOCS.securingweb.controlador;
import com.IEC.SGCDOCS.securingweb.modelos.DB.Attempts;
import com.IEC.SGCDOCS.securingweb.modelos.DB.Pats;
import com.IEC.SGCDOCS.securingweb.modelos.Pronosticos;
import com.IEC.SGCDOCS.securingweb.modelos.UsuarioVisualizacion;
import com.IEC.SGCDOCS.securingweb.repositorio.AttemptsRepository;
import com.IEC.SGCDOCS.securingweb.repositorio.PatsRepositorio;
import com.IEC.SGCDOCS.securingweb.repositorio.UserRepository;
import com.IEC.SGCDOCS.securingweb.servicios.PatServicio;
import com.IEC.SGCDOCS.securingweb.servicios.SecurityUserDetailsService;
import jakarta.annotation.security.RolesAllowed;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/")
public class AdminControlador {

    
    @Autowired private SecurityUserDetailsService securityUserDetailsService;

    @GetMapping("/lista-usuarios")
    public List<UsuarioVisualizacion> getUsuarioVisualizacions(){
        return securityUserDetailsService.getAllUserVis();

    }

    @GetMapping("/lista-log-fails")
    public List<Attempts> getLogFails(){
        return securityUserDetailsService.getAllAttemps();
    }

    @DeleteMapping("/del-attemp/{id}")
    public void deleteAttempId(@PathVariable long id){

        securityUserDetailsService.deleteAttemp(id);
    }

    @DeleteMapping("/reset-all-attemps")
    public void deleteAllAttemps(){
        securityUserDetailsService.deleteAllAttemps();
    }

    
}
