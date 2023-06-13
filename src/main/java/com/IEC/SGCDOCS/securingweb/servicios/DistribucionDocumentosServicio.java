package com.IEC.SGCDOCS.securingweb.servicios;

import com.IEC.SGCDOCS.securingweb.modelos.DB.DistribucionDocumentos;

import com.IEC.SGCDOCS.securingweb.repositorio.DistribucionDocumentosRepositorio;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class DistribucionDocumentosServicio {

    @Autowired
    private DistribucionDocumentosRepositorio distribucionDocumentosRepositorio;

    public List<DistribucionDocumentos> getAll() {
        return this.distribucionDocumentosRepositorio.findAll();

    }

    @Override
    public String toString() {
        return "DistribucionDocumentosServicio{}";
    }


}