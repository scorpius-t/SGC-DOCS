package com.IEC.SGCDOCS.securingweb.servicios;

import com.IEC.SGCDOCS.securingweb.modelos.DB.Integrantes;
import com.IEC.SGCDOCS.securingweb.modelos.DB.Pats;
import com.IEC.SGCDOCS.securingweb.repositorio.IntegrantesRepositorio;
import com.IEC.SGCDOCS.securingweb.repositorio.PatsRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class IntegrantesServicio {

    @Autowired
    private IntegrantesRepositorio integrantesRepositorio;

    public List<Integrantes> getAll() {
        return this.integrantesRepositorio.findAll();

    }

    @Override
    public String toString() {
        return "IntegrantesServicio{}";
    }


}
