package com.IEC.SGCDOCS.securingweb.servicios;

import com.IEC.SGCDOCS.securingweb.modelos.DB.Pats;
import com.IEC.SGCDOCS.securingweb.repositorio.PatsRepositorio;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
@RequiredArgsConstructor
public class PatServicio {

    @Autowired
    private PatsRepositorio patsRepositorio;

    public List<Pats> getAll() {
//        return this.patsRepositorio.findAll();
        return this.patsRepositorio.findAllByOrderByPatAsc();
    }

    @Override
    public String toString() {
        return "PatServicio{}";
    }


}
