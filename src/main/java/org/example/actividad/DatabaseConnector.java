package org.example.actividad;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {
    private Connection conexion;

    public Connection conectar() throws ClassNotFoundException, SQLException, IOException {
        Properties configuration = new Properties();
        configuration.load(R.getProperties("database.properties"));
        String host= configuration.getProperty("host");
        String port= configuration.getProperty("port");
        String name= configuration.getProperty("name");
        String username= configuration.getProperty("username");
        String password= configuration.getProperty("password");

        Class.forName("com.mysql.jdbc.Driver");
        conexion= DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+name,username,password);
        return null;
    }
}
