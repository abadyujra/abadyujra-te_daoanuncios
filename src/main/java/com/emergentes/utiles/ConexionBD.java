package com.emergentes.utiles;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConexionBD {
    static public String driver = "com.mysql.cj.jdbc.Driver";
    static public String url = "jdbc:mysql://localhost:3306/bd_seminarios";
    static public String usuario = "root";
    static public String password = "";
    
    protected Connection conn = null;
//CONSTRUCTOR BASICIO
    public ConexionBD() {
        try {
            //DRIVER
            Class.forName(driver);
            conn = DriverManager.getConnection(url, usuario, password);
        } catch (ClassNotFoundException ex) {
            System.out.println("Error en el driver: " + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("Error al realizar la conexion: " + ex.getMessage());
        }
    }
    //METODO PARA CONECTAR
    public Connection conectar(){
        return conn;
    }
    //METODO PARA DESCONECTAR
    public void desconectar(){
        try {
            conn.close();
        } catch (SQLException ex) {
            System.out.println("Error al cerrar la conexión: "+ex.getMessage());
        }
    }
}
