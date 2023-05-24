package com.IEC.SGCDOCS.securingweb.servicios;

import lombok.Getter;
import lombok.Setter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

@Getter @Setter
public class ConexionDB {
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

    public void conectar() throws Exception {
        try {
            instanciarPro();
            //Class.forName(nameClass);
            if (this.getNameClass().equals(".com.microsoft.sqlserver.jdbc.SQLServerDriver")) {
                connection = DriverManager.getConnection(this.getDbURL());
            }
        } catch (Exception e) {
            throw e;
        }
    }

    public void instanciarPro() throws FileNotFoundException, IOException{
        try {
            Properties prop= new Properties();
            String home = System.getProperty("user.dir");
            File f=new File(home+"\\dbconfig.properties");
            prop.load(new FileInputStream(f));
            this.setServidor(prop.getProperty("server"));
            this.setBasededato(prop.getProperty("database"));
            this.setUsuario(prop.getProperty("user"));
            this.setPassword(prop.getProperty("password"));
            this.setPuerto(prop.getProperty("port"));
            this.setMotor(prop.getProperty("motor"));
            this.setNameClass(prop.getProperty("nameClass"));

            this.setDbURL(this.getMotor()+this.getServidor()+":"+this.getPuerto()
                    +";database="+this.getBasededato()
                    +";user="+this.getUsuario()
                    +";password="+this.getPassword()
                    +";TrustServerCertificate=True"
                    + ";loginTimeout=30");
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }

    }


    public Connection getConnectionDB() throws Exception{
        try{
            Class.forName(".com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(this.getDbURL());

        } catch (Exception e){
            e.printStackTrace();
            throw e;
        }
        return connection;
    }
    public void cerrar() throws Exception {
        try {
            if (connection != null) {
                if (connection.isClosed() == false) {
                    connection.close();
                }
            }
        } catch (Exception e) {
        }
    }
}
