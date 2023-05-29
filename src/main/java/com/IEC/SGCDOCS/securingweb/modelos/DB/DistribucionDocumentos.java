package com.IEC.SGCDOCS.securingweb.modelos.DB;

import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter @Setter

public class DistribucionDocumentos {
    private int id;
    private String tipoDeDocumento;
    private String codificacion;
    private String titulo;
    private String rdd;
    private String cliente;
    private Date fechaDistribucion;
    private Date fechaRecepcion;
    private String ior;
    private String respuestaIor;
    private String cierreIor;
    private String observaciones;
    private String periodo;
    private String registroEnvio;

}
