package com.IEC.SGCDOCS.securingweb.repositorio;

import com.IEC.SGCDOCS.securingweb.modelos.DB.DistribucionDocumentos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface DistribucionDocumentosRepositorio extends JpaRepository<DistribucionDocumentos, Long> {

//    List<DistribucionDocumentos> findByCodificacion(Float distribucionDocumentos);

}