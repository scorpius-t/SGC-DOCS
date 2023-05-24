package com.IEC.SGCDOCS.securingweb.servicios;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

//@SpringBootApplication
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class securityAPP {

    public static void main(String[] args) throws Throwable {
        SpringApplication.run(securityAPP.class, args);

    }

}
