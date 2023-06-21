package com.IEC.SGCDOCS.securingweb.repositorio;

import com.IEC.SGCDOCS.securingweb.modelos.DB.Pats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface PatsRepositorio extends JpaRepository<Pats, Long> {

    List<Pats> findByPat(Float pat);
    List<Pats> findAllByOrderByPatAsc();


}
