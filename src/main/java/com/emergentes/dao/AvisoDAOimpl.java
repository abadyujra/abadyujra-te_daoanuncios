package com.emergentes.dao;

import com.emergentes.modelo.Aviso;
import com.emergentes.utiles.ConexionBD;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//1.-extends ConexionBD (conexion usar la clase conexion)
//2.-poner implements AvisoDAO (para implementar metodos especificado en la Interface)

public class AvisoDAOimpl extends ConexionBD implements AvisoDAO{

    @Override
    public void insert(Aviso aviso) throws Exception {
        String sql = "insert into seminarios (titulo,fecha,cupo) values (?,?,?)";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1, aviso.getTitulo());
        ps.setString(2, aviso.getFecha());
        ps.setInt(3, aviso.getCupo());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void update(Aviso aviso) throws Exception {
        String sql = "update seminarios set titulo=?, fecha=?, cupo=? where id = ?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setString(1,aviso.getTitulo());
        ps.setString(2,aviso.getFecha());
        ps.setInt(3, aviso.getCupo());
        ps.setInt(4, aviso.getId());
        ps.executeUpdate();
        this.desconectar();
    }

    @Override
    public void delete(int id) throws Exception {
        String sql = "delete from seminarios where id=?";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ps.setInt(1, id);
        ps.executeUpdate();
        this.desconectar();
    }
    //obtener un conjunto de listado 
    @Override
    public List<Aviso> getAll() throws Exception {
        List<Aviso> lista = null;
        String sql = "select * from seminarios";
        this.conectar();
        PreparedStatement ps = this.conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        
        lista = new ArrayList<Aviso>();
        while(rs.next()){
            Aviso avi = new Aviso();
            
            avi.setId(rs.getInt("id"));
            avi.setTitulo(rs.getString("titulo"));
            avi.setFecha(rs.getString("fecha"));
            avi.setCupo(rs.getInt("cupo"));
            
            
            lista.add(avi);
        }
        this.desconectar();
        return lista;
    }
        //busqueda de un objeto 
    @Override
    public Aviso getById(int id) throws Exception {
        Aviso avi = new Aviso();
        try {
            String sql = "select * from seminarios where id=?";
            PreparedStatement ps = this.conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                avi.setId(rs.getInt("id"));
                avi.setTitulo(rs.getString("titulo"));
                avi.setFecha(rs.getString("fecha"));
                avi.setCupo(rs.getInt("cupo"));
            }
        } catch (SQLException e) {
            throw e;
        } finally{
            this.desconectar();
        }
        return avi;
    }
    
}
