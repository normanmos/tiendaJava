package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductoCRUD implements CRUD{
    int id;
    PreparedStatement ps;
    ResultSet rs;    
    Connection con;
    Conexion cn=new Conexion();    

    public Producto mostrarCodigo(int codigo){
        Producto c = new Producto();
        String sql="select * from proyecto.producto where cod_producto=?";
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setInt(1, codigo);
            rs=ps.executeQuery();
            while(rs.next()){               
                        c.setCod_producto(rs.getInt(1));
                        c.setNombre(rs.getString(2));
                        c.setPrecio(rs.getFloat(3));
                        c.setStock(rs.getInt(4));
                        c.setEstado(rs.getString(5));
            }
        } catch (Exception e) {
        }
        return c;
    }
    
    @Override
    public List Mostrar() {
        List<Producto> lista = new ArrayList<>();
            String sql = "select * from proyecto.producto";
            try{
                   con=cn.Conectar();
                   ps= con.prepareStatement(sql);
                   rs=ps.executeQuery();
                   while (rs.next()) {                    
                        Producto c = new Producto();
                        c.setCod_producto(rs.getInt(1));
                        c.setNombre(rs.getString(2));
                        c.setPrecio(rs.getFloat(3));
                        c.setStock(rs.getInt(4));
                        c.setEstado(rs.getString(5));
                        lista.add(c);
                    }
            }catch(SQLException e){
                
            }
            return lista;
    }

    @Override
    public int Ingresar(Object[] o) {
        int resultado=0; 
            String  sql= "insert into proyecto.producto (nombre_producto,precio,stock,estado) values(?,?,?,?)";
            try {
                con= cn.Conectar();
                ps=con.prepareStatement(sql);
                ps.setObject(1, o[0]);
                ps.setObject(2, o[1]);
                ps.setObject(3, o[2]);
                ps.setObject(4, o[3]);
                resultado=ps.executeUpdate();
            } catch (Exception e) {
            }
        return resultado;
    }

    @Override
    public int Modificar(Object[] o) {
        int resultado=0; 
            String sql="update proyecto.producto set nombre_producto=?,precio=?,stock=?,estado=? where cod_producto=?";
            try {
                con=cn.Conectar();
                ps=con.prepareStatement(sql);
                ps.setObject(1, o[0]);
                ps.setObject(2, o[1]);
                ps.setObject(3, o[2]);
                ps.setObject(4, o[3]);
                ps.setObject(5, o[4]);  
                ps.executeUpdate();
            } catch (Exception e) {
            }
            return resultado;
    }

    @Override
    public void Eliminar(int id) {
        String sql="delete from proyecto.producto where cod_producto=?";
            try {
                con=cn.Conectar();
                ps=con.prepareStatement(sql);
                ps.setInt(1, id);
                ps.executeUpdate();
            } catch (Exception e) {
            }
    }
}
