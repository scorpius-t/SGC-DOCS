package com.IEC.SGCDOCS.securingweb.modelos.DB;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.sql.Date;

@Getter
@Setter
@Data
@Entity
@Table(name = "PATS")
public class Pats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "PAT", nullable = false)
    private Float pat;
    @Column(name = "Prioridad")
    private String prioridad;
    @Column(name = "Estado", nullable = false)
    private String estado;
    @Column(name = "[% completado]")
    private Float porcCompletado;
    @Column(name = "[Asignado a]")
    private Integer asignadoA;
    @Column(name = "Título")
    private String titulo;
    @Column(name = "[Fecha de apertura]")
    private Date fechaDeApertura;
    @Column(name = "[Fecha de cierre]")
    private Date fechaDeCierre;
    @Column(name = "[Periodo]")
    private String periodo;
    @Column(name = "[Hs resolución]")
    private String hsResolucion;
    @Column(name = "[Categoría]")
    private String categoria;
    @Column(name = "[Tipo doc 1]")
    private String tipoDoc1;
    @Column(name = "[Codif 1]")
    private String codif1;
    @Column(name = "[Estado 1]")
    private String estado1;
    @Column(name = "[Fecha 1]")
    private Date fecha1;
    @Column(name = "[Tipo doc 2]")
    private String tipoDoc2;
    @Column(name = "[Codif 2]")
    private String codif2;
    @Column(name = "[Estado 2]")
    private String estado2;
    @Column(name = "[Fecha 2]")
    private Date fecha2;
    @Column(name = "[Tipo doc 3]")
    private String tipoDoc3;
    @Column(name = "[Codif 3]")
    private String codif3;
    @Column(name = "[Estado 3]")
    private String estado3;
    @Column(name = "[Fecha 3]")
    private Date fecha3;
    @Column(name = "[Tipo doc 4]")
    private String tipoDoc4;
    @Column(name = "[Codif 4]")
    private String codif4;
    @Column(name = "[Estado 4]")
    private String estado4;
    @Column(name = "[Fecha 4]")
    private Date fecha4;
    @Column(name = "[Tipo doc 5]")
    private String tipoDoc5;
    @Column(name = "[Codif 5]")
    private String codif5;
    @Column(name = "[Estado 5]")
    private String estado5;
    @Column(name = "[Fecha 5]")
    private Date fecha5;
    @Column(name = "Observaciones")
    private String observaciones;

//    private Pats (){}


}
