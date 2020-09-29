/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendedorCRUD implements CRUD{
    int id;
    PreparedStatement ps;
    ResultSet rs;    
    Connection con;
    Conexion cn=new Conexion();
    
    
    public int validar(String usuario, String cedula){
        String sql="select * from proyecto.vendedor where usuario=? and cedula=?";
        try
        {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1,usuario);
            ps.setString(2, cedula);
            rs=ps.executeQuery();
                while(rs.next())
                    return 1;          
        }catch (Exception e){
        } 
        return 0;
    }  
    
    

    @Override
    public List Mostrar() {
        List<Vendedor> lista = new ArrayList<>();
            String sql = "select * from proyecto.vendedor";
            try{
                   con=cn.Conectar();
                   ps= con.prepareStatement(sql);
                   rs=ps.executeQuery();
                   while (rs.next()) {                    
                        Vendedor c = new Vendedor();
                        c.setCod_vendedor(rs.getInt(1));
                        c.setCedula(rs.getString(2));
                        c.setNombres(rs.getString(3));
                        c.setTelefono(rs.getString(4));
                        c.setEstado(rs.getString(5));
                        c.setUsuario(rs.getString(6));
                        lista.add(c);
                    }
            }catch(SQLException e){
                
            }
            return lista;
    }

    @Override
    public int Ingresar(Object[] o) {
        int resultado=0; 
            String  sql= "insert into proyecto.vendedor (cedula,nombres,telefono,estado,usuario) values (?,?,?,?,?)";
            try {
                con= cn.Conectar();
                ps=con.prepareStatement(sql);
                ps.setObject(1, o[0]);
                ps.setObject(2, o[1]);
                ps.setObject(3, o[2]);
                ps.setObject(4, o[3]);
                ps.setObject(5, o[4]);
                resultado=ps.executeUpdate();
            } catch (Exception e) {
            }
        return resultado;
    }

    @Override
    public int Modificar(Object[] o) {
        int resultado=0; 
            String sql="update proyecto.vendedor set cedula=?, nombres=?,telefono=?,estado=?,usuario=? where cod_vendedor=?";
            try {
                con=cn.Conectar();
                ps=con.prepareStatement(sql);
                ps.setObject(1, o[0]);
                ps.setObject(2, o[1]);
                ps.setObject(3, o[2]);
                ps.setObject(4, o[3]);
                ps.setObject(5, o[4]);
                ps.setObject(6, o[5]);     
                ps.executeUpdate();
            } catch (Exception e) {
            }
            return resultado;
    }

    @Override
    public void Eliminar(int id) {
        String sql="delete from proyecto.vendedor where cod_vendedor=?";
            try {
                con=cn.Conectar();
                ps=con.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
            } catch (Exception e) {
            }
    }
}
