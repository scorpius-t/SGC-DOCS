package com.IEC.SGCDOCS.securingweb.servicios;

import com.IEC.SGCDOCS.securingweb.modelos.DB.Pats;
import com.IEC.SGCDOCS.securingweb.modelos.Pronosticos;
import com.IEC.SGCDOCS.securingweb.repositorio.PatsRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//import static com.IEC.SGCDOCS.SgcDocsApplication.leerPatsDB;


@Service
@RequiredArgsConstructor
public class PatServicio {

    @Autowired
    private PatsRepositorio patsRepositorio;

    public List<Pats> getAllPats() {
        return this.patsRepositorio.findAll();

    }

    @Override
    public String toString() {
        return "PatServicio{}";
    }

    //    private final List<Pronosticos> pronosticos=new ArrayList<>();
//
//    public List<Pronosticos> getAll() {
//
//        return leerPatsDB.leer();
//    }
//
//    public void add(Pronosticos pronostico){
//        pronosticos.add(pronostico);
//    }
//
}
