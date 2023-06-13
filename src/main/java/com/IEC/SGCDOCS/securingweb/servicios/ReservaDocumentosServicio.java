package com.IEC.SGCDOCS.securingweb.servicios;

import com.IEC.SGCDOCS.securingweb.modelos.DB.Pats;
import com.IEC.SGCDOCS.securingweb.modelos.DB.ReservaDocumentos;
import com.IEC.SGCDOCS.securingweb.repositorio.PatsRepositorio;
import com.IEC.SGCDOCS.securingweb.repositorio.ReservaDocumentosRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class ReservaDocumentosServicio {

    @Autowired
    private ReservaDocumentosRepositorio reservaDocumentosRepositorio;

    public List<ReservaDocumentos> getAll() {
        return this.reservaDocumentosRepositorio.findAll();

    }

    @Override
    public String toString() {
        return "ReservaDocumentosServicio{}";
    }


}

