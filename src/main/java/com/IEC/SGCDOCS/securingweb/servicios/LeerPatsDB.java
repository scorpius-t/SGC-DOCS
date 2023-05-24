package com.IEC.SGCDOCS.securingweb.servicios;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.IEC.SGCDOCS.securingweb.modelos.Pronosticos;
public class LeerPatsDB extends ConexionDB {

    public List<Pronosticos> leer() {
        List<Pronosticos> listaPronostico= new ArrayList<>();
        ResultSet reader;


        try {
            this.conectar();
            PreparedStatement st= this.getConnection().prepareStatement(
                    "SELECT apostador, equipoL, golesL, equipoV, golesV FROM " +
                            "pronosticos"
            );
            reader=st.executeQuery();
            while(reader.next()){
                Pronosticos objPronostico=new Pronosticos();
                objPronostico.agregar(
                        reader.getInt("numeroApuesta"),
                        reader.getString("apostador"),
                        reader.getString("equipoL"),
                        reader.getString("golesL"),
                        reader.getString("equipoV"),
                        reader.getString("golesV")
                );
                System.out.println(objPronostico);
            }

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                this.cerrar();
            }catch (Exception e){
                e.printStackTrace();
            }
        }

        return listaPronostico;
    }
}
