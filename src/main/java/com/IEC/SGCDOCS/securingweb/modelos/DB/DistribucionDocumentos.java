package com.IEC.SGCDOCS.securingweb.modelos.DB;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter @Setter
@Data
@Entity
@Table(name = "[Distribución de documentos]")

public class DistribucionDocumentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "[Tipo de documento]")
    private String tipoDeDocumento;
    @Column(name = "[Codificación]")
    private String codificacion;
    @Column(name = "[Título]")
    private String titulo;
    @Column(name = "RDD")
    private String rdd;
    @Column(name = "Cliente")
    private String cliente;
    @Column(name = "[Fecha de distribución]")
    private Date fechaDistribucion;
    @Column(name = "[Fecha de recepción]")
    private Date fechaRecepcion;
    @Column(name = "IOR")
    private String ior;
    @Column(name = "[Respuesta IOR]")
    private String respuestaIor;
    @Column(name = "[Cierre IOR y aviso al autor del documento]")
    private Date cierreIor;
    @Column(name = "Observaciones")
    private String observaciones;
    @Column(name = "Periodo")
    private String periodo;
    @Column(name = "[Registro de envío]")
    private String registroEnvio;

}
