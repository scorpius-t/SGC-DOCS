package com.IEC.SGCDOCS.securingweb.config;

import com.IEC.SGCDOCS.securingweb.controlador.GenericExceptionMapper;
import com.IEC.SGCDOCS.securingweb.controlador.PatControlador;
import jakarta.annotation.PostConstruct;
import jakarta.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.boot.autoconfigure.jersey.JerseyProperties;
import org.springframework.stereotype.Component;



@ApplicationPath("/api")
@Component
public class JerseyConfig extends ResourceConfig {

    public JerseyConfig(){
//        register(PatControlador.class);
//        register(GenericExceptionMapper.class);
//        this.packages("com.IEC.SGCDOCS.securingweb.controlador")

        ;
    }
}
