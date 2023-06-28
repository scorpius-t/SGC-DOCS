package com.IEC.SGCDOCS;

import com.IEC.SGCDOCS.securingweb.modelos.Configura;
import com.IEC.SGCDOCS.securingweb.servicios.LeerPatsDB;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class SgcDocsApplication extends SpringBootServletInitializer {

//	public static LeerPatsDB leerPatsDB =new LeerPatsDB();
public final static Configura conf= new Configura();
	public static void main(String[] args) {
		try {
			conf.instanciarConfig();
		} catch (Exception e){
			e.printStackTrace();
			System.out.println("Finalizando ejecucion por error de lectura de config.properties");
			return; // finaliza el programa por error de lectura de configuracion
		}
		SpringApplication.run(SgcDocsApplication.class, args);



//		leerPatsDB.leer();

	}

}
