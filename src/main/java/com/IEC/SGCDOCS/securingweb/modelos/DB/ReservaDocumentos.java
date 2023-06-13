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
@Table(name = "[Reserva de documentos]")
public class ReservaDocumentos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "[Tipo de documento]")
    private String tipoDoc;
    @Column(name = "[Codificación/N°]", nullable = false)
    private String codificacion;
    @Column(name = "[Título/referencia]")
    private String tituloReferencia;
    @Column(name = "[Asignado a]")
    private Long asignadoA;
    @Column(name = "Fecha de reserva")
    private String fechaReserva;
    @Column(name = "PAT")
    private String pat;
    @Column(name = "Observaciones")
    private String observaciones;

}
