package com.IEC.SGCDOCS.securingweb.servicios;

import com.IEC.SGCDOCS.securingweb.modelos.Pronosticos;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.IEC.SGCDOCS.SgcDocsApplication.leerPatsDB;


@Service
public class PatServicio {
    private final List<Pronosticos> pronosticos=new ArrayList<>();

    public List<Pronosticos> getAll() {

        return leerPatsDB.leer();
    }

    public void add(Pronosticos pronostico){
        pronosticos.add(pronostico);
    }

}
