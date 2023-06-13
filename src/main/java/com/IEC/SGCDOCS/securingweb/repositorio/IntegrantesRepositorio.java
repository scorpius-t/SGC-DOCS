package com.IEC.SGCDOCS.securingweb.repositorio;

import com.IEC.SGCDOCS.securingweb.modelos.DB.Integrantes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IntegrantesRepositorio extends JpaRepository<Integrantes, Long> {

//    List<Integrantes> findByApellidos(Float integrantes);

}