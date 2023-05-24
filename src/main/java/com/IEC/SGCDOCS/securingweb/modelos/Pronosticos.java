package com.IEC.SGCDOCS.securingweb.modelos;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Pronosticos {
    private int numeroApuesta;
    private String apostador;
    private String equipoL;
    private String golesL;
    private String equipoV;
    private String golesV;

    protected Pronosticos (int numeroApuesta, String apostador, String equipoL,String golesL, String equipoV, String golesV){
        this.setNumeroApuesta(numeroApuesta);
        this.setApostador(apostador);
        this.setEquipoL(equipoL);
        this.setGolesL(golesL);
        this.setEquipoV(equipoV);
        this.setGolesV(golesV);
    }
    public void agregar(int numeroApuesta, String apostador, String equipoL,String golesL, String equipoV, String golesV){
        this.setNumeroApuesta(numeroApuesta);
        this.setApostador(apostador);
        this.setEquipoL(equipoL);
        this.setGolesL(golesL);
        this.setEquipoV(equipoV);
        this.setGolesV(golesV);
    }
    public Pronosticos(){}


}
