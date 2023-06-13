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
@Table(name = "[integrantes SF]")
public class Integrantes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Apellidos")
    private String apellidos;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Sector")
    private String sector;
    @Column(name = "Cargo")
    private String cargo;
    @Column(name = "[e-mail]")
    private String email;
    @Column(name = "interno")
    private String interno;
    @Column(name = "[Teléfono particular]")
    private String telParticular;
    @Column(name = "Celular")
    private String telCelular;
    @Column(name = "[Número de fax]")
    private String numFax;
    @Column(name = "[Dirección]")
    private String direccion;
    @Column(name = "Ciudad")
    private String ciudad;
    @Column(name = "[Estado/Provincia]")
    private String estadoProvincia;
    @Column(name = "[Código Postal]")
    private String codigoPostal;
    @Column(name = "[País o región]")
    private String pais;
    @Column(name = "[Página Web]")
    private String paginaWeb;
    @Column(name = "Notas")
    private String notas;
}
