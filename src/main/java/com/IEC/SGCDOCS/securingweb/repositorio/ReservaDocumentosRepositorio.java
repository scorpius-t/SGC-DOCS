package com.IEC.SGCDOCS.securingweb.repositorio;

import com.IEC.SGCDOCS.securingweb.modelos.DB.Pats;
import com.IEC.SGCDOCS.securingweb.modelos.DB.ReservaDocumentos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ReservaDocumentosRepositorio extends JpaRepository<ReservaDocumentos, Long> {

//    List<ReservaDocumentos> findByPat(Float reservaDocumentos);

}