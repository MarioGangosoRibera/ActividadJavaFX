package org.example.actividad;

import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class EquipoDAO {
    private Connection conexion;

    public void conectar() throws ClassNotFoundException, SQLException, IOException {
        Properties configuration = new Properties();
        configuration.load(R.getProperties("database.properties"));
        String host= configuration.getProperty("host");
        String port= configuration.getProperty("port");
        String name= configuration.getProperty("name");
        String username= configuration.getProperty("username");
        String password= configuration.getProperty("password");

        Class.forName("com.mysql.jdbc.Driver");
        conexion= DriverManager.getConnection("jdbc:mysql://"+host+":"+port+"/"+name,username,password);
    }

    public void desconectar() throws SQLException{
        conexion.close();
    }

    public void guardarEquipo(Equipo equipo) throws SQLException{
        String sql = "INSERT INTO coches (nombreEquipo, edad, categoria) VALUES (?, ?, ?)";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, equipo.getNombreEquipo());
        sentencia.setString(2, equipo.getEdad());
        sentencia.setString(3, equipo.getCategoria());
        sentencia.executeUpdate();
    }

    public void eliminarEquipo(Equipo equipo) throws SQLException{
        String sql = "DELETE FROM coches WHERE nombreEquipo = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        sentencia.setString(1, equipo.getNombreEquipo());
        sentencia.executeUpdate();
    }

    public List<Equipo> obtenerEquipos() throws SQLException{
        List<Equipo> equipos= new ArrayList<>();
        String sql = "SELECT * FROM coches";

        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();
        while(resultado.next()){
            Equipo equipo = new Equipo();
            equipo.setIdEquipo(resultado.getInt(1));
            equipo.setNombreEquipo(resultado.getString(2));
            equipo.setEdad(resultado.getInt(3));
            equipo.setCategoria(resultado.getString(4));

            equipos.add(equipo);
        }
        return equipos;
    }

    public boolean existeEquipo(String nombreEquipo) throws SQLException{
        String sql = "SELECT * FROM equipo WHERE nombreEquipo = ?";
        PreparedStatement sentencia = conexion.prepareStatement(sql);
        ResultSet resultado = sentencia.executeQuery();

        return resultado.next();
    }
}
