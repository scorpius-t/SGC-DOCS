package com.IEC.SGCDOCS.securingweb.modelos;

import lombok.Getter;
import lombok.Setter;

import java.io.*;
import java.util.Properties;

@Getter @Setter
public class Configura {

    private String pathFormularios;
    private String pathManualProc1;
    private String pathManualProc2;
    private String pathManualProc3;
    private String PathDocsCliente1;
    private String PathDocsCliente2;
    private String PathDocsCliente3;
    private String Resource1Location;

    public void instanciarConfig() throws FileNotFoundException, IOException {
        try {
            Properties prop = new Properties();

//            InputStream inputStream = this.getClass().getResourceAsStream("/config.properties");
//            prop.load(inputStream);

            String home = System.getProperty("user.dir");
            File f = new File(home + "\\config.properties");
            prop.load(new FileInputStream(f));
            this.setPathFormularios(prop.getProperty("pathFormularios"));
            this.setPathManualProc1(prop.getProperty("pathManualProc1"));
            this.setPathManualProc2(prop.getProperty("pathManualProc2"));
            this.setPathManualProc3(prop.getProperty("pathManualProc3"));
            this.setPathDocsCliente1(prop.getProperty("PathDocsCliente1"));
            this.setPathDocsCliente2(prop.getProperty("PathDocsCliente2"));
            this.setPathDocsCliente3(prop.getProperty("PathDocsCliente3"));
            this.setResource1Location(prop.getProperty("Resource1Location"));
            System.out.println(this.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        return "Configura{" +
                "pathFormularios='" + pathFormularios + '\'' +
                ", pathManualProc1='" + pathManualProc1 + '\'' +
                ", pathManualProc2='" + pathManualProc2 + '\'' +
                ", pathManualProc3='" + pathManualProc3 + '\'' +
                ", PathDocsCliente1='" + PathDocsCliente1 + '\'' +
                ", PathDocsCliente2='" + PathDocsCliente2 + '\'' +
                ", PathDocsCliente3='" + PathDocsCliente3 + '\'' +
                ", Resource1Location='" + Resource1Location + '\'' +
                '}';
    }
}
