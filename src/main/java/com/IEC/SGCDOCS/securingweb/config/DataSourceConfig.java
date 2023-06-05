package com.IEC.SGCDOCS.securingweb.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.util.Properties;

@Getter
@Setter
@Configuration
public class DataSourceConfig {
    private Connection connection;
    private String servidor;
    private String usuario;
    private String puerto;
    private String basededato;
    private String password;
    private String motor;
    private String nameClass;
    private String dbURL;
    private boolean conecta;

    @Bean
    public DataSource getDataSource() {
        try {
            instanciarPro();
        } catch (Exception e){
            e.printStackTrace();
        }

        DataSourceBuilder dataSourceBuilder = DataSourceBuilder.create();
//        dataSourceBuilder.driverClassName(this.getNameClass());
        dataSourceBuilder.url(this.getDbURL());
        dataSourceBuilder.username(this.getUsuario());
        dataSourceBuilder.password(this.getPassword());
        return dataSourceBuilder.build();
    }
    public void instanciarPro() throws FileNotFoundException, IOException {
        try {
            Properties prop = new Properties();
            String home = System.getProperty("user.dir");
            File f = new File(home + "\\dbconfig.properties");
            prop.load(new FileInputStream(f));
            this.setServidor(prop.getProperty("server"));
            this.setBasededato(prop.getProperty("database"));
            this.setUsuario(prop.getProperty("user"));
            this.setPassword(prop.getProperty("password"));
            this.setPuerto(prop.getProperty("port"));
            this.setMotor(prop.getProperty("motor"));
            this.setNameClass(prop.getProperty("nameClass"));

            this.setDbURL(this.getMotor() + this.getServidor() + ":" + this.getPuerto()
                    + ";database=" + this.getBasededato()
                    + ";user=" + this.getUsuario()
                    + ";password=" + this.getPassword()
                    + ";TrustServerCertificate=True"
                    + ";loginTimeout=30");
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }
}
