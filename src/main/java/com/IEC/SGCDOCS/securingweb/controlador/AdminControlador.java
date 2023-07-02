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
import jakarta.servlet.http.HttpServletResponse;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
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

    @RequestMapping(value = "/del-attemp", method = {RequestMethod.GET, RequestMethod.POST})
    public void deleteAttempId(Model model, @RequestParam String usuario, HttpServletResponse httpServletResponse){
        httpServletResponse.setHeader("Location", "/administrator.html");
        httpServletResponse.setStatus(302);
        securityUserDetailsService.deleteAttemp(usuario);
    }

//    @DeleteMapping("/reset-all-attemps")
    @RequestMapping(value = "/reset-all-attemps", method = {RequestMethod.GET, RequestMethod.POST})
    public void deleteAllAttemps(HttpServletResponse httpServletResponse) {
        securityUserDetailsService.deleteAllAttemps();
        httpServletResponse.setHeader("Location", "/administrator.html");
        httpServletResponse.setStatus(302);


    }



//    @GetMapping("/reset-all-attemps")/
//    @RequestMapping(value = "/reset-all-attemps", method = RequestMethod.GET)
////    @RequestMapping(value = "/reset-all-attemps", method = {RequestMethod.GET, RequestMethod.POST})
//    public void deleteAllAttempsRedirect(HttpServletResponse httpServletResponse) {
//        httpServletResponse.setHeader("Location", "/administrator.html");
//        httpServletResponse.setStatus(302);
//
//    }
//
}
