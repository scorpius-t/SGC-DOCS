package com.IEC.SGCDOCS;

import com.IEC.SGCDOCS.securingweb.modelos.Configura;
import com.IEC.SGCDOCS.securingweb.servicios.LeerPatsDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SgcDocsApplication {

	public static LeerPatsDB leerPronosticosDB=new LeerPatsDB();
	public static void main(String[] args) {

		SpringApplication.run(SgcDocsApplication.class, args);

		Configura conf= new Configura();
		try {
			conf.instanciarConfig();
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("Finalizando ejecucion por error de lectura de config.properties");
			return; // finaliza el programa por error de lectura de configuracion
		}
		leerPronosticosDB.leer();

	}

}
