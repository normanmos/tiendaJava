package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteCRUD implements CRUD{
Connection con;
Conexion cn=new Conexion();
PreparedStatement ps;
ResultSet rs;
    
    public Cliente mostrarCodigo(String cedula){
        Cliente c = new Cliente();
        String sql="select * from proyecto.cliente where cedula=?";
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, cedula);
            rs=ps.executeQuery();
            while(rs.next()){
                c.setId(rs.getInt(1));
                c.setCedula(rs.getString(2));
                c.setNombre(rs.getString(3));
                c.setDireccion(rs.getString(4));
                c.setTelefono(rs.getString(5));
                c.setEstado(rs.getString(6));
            }
            rs=ps.executeQuery();
        } catch (Exception e) {
        }
        return c;
    }

    @Override
    public List Mostrar() {
       List<Cliente> lista = new ArrayList<>();
            String sql = "select * from proyecto.cliente";
            try{
                   con=cn.Conectar();
                   ps= con.prepareStatement(sql);
                   rs=ps.executeQuery();
                   while (rs.next()) {                    
                    Cliente c = new Cliente();
                    c.setId(rs.getInt(1));
                    c.setCedula(rs.getString(2));
                    c.setNombre(rs.getString(3));
                    c.setDireccion(rs.getString(4));
                    c.setTelefono(rs.getString(5));
                    c.setEstado(rs.getString(6));
                    lista.add(c);
                }
            }catch(SQLException e){
                
            }
            return lista;   
    }

    @Override
    public int Ingresar(Object[] o) {
            int resultado=0; 
            String  sql= "insert into proyecto.cliente (cedula,nombres,direccion,telefono,estado) values (?,?,?,?,?)";
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
            String sql="update proyecto.cliente set cedula=?, nombres=?,direccion=?,telefono=?,estado=? where cod_cliente=?";
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
        String sql="delete from proyecto.cliente where cod_cliente=?";
            try {
                con=cn.Conectar();
                ps=con.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
            } catch (Exception e) {
            }
    }
    
}
