package com.IEC.SGCDOCS.securingweb.modelos;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter

public class UsuarioVisualizacion {

    private String nombre;
    private String role;
    private Boolean isActive;

    
    public UsuarioVisualizacion(String nombre, String role, Boolean isActive) {
        this.nombre = nombre;
        this.role = role;
        this.isActive = isActive;
    }

     
}
