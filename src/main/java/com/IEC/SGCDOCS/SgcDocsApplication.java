package com.IEC.SGCDOCS;

import com.IEC.SGCDOCS.securingweb.modelos.Configura;
import com.IEC.SGCDOCS.securingweb.servicios.LeerPatsDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SgcDocsApplication {

//	public static LeerPatsDB leerPatsDB =new LeerPatsDB();
public final static Configura conf= new Configura();
	public static void main(String[] args) {

		SpringApplication.run(SgcDocsApplication.class, args);


		try {
			conf.instanciarConfig();
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("Finalizando ejecucion por error de lectura de config.properties");
			return; // finaliza el programa por error de lectura de configuracion
		}
//		leerPatsDB.leer();

	}

}
