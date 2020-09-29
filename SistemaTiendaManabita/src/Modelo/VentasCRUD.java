package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import Modelo.Venta;
import com.mysql.jdbc.exceptions.MySQLDataException;

public class VentasCRUD {
    int id;
    PreparedStatement ps;
    ResultSet rs;    
    Connection con;
    Conexion cn=new Conexion();    
    int resultado;
    
    public String serie(){
           String serie=null;
           String sql= "select max(numero_venta)+1 from proyecto.venta";
           try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){               
                serie=rs.getString(1);
            }
        } catch (Exception e) {
        }
        return serie;        
    }
    
    public String idVenta(){
        String idv="0";
        String sql="select max(cod_venta) from proyecto.venta";
        try {
            con=cn.Conectar();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){               
                idv=rs.getString(1);
            }
        }catch (Exception e)
        {
          System.err.println("Got an exception!");
          System.err.println(e.getMessage());
        }
        return idv;
    }
    
    public int crearVenta(Venta v){
        String sql="insert into proyecto.venta (cod_cliente,cod_vendedor,numero_venta,monto,estado) values (?,?,?,?,?)";
        try {
            con= cn.Conectar();
            ps=con.prepareStatement(sql);
                ps.setInt(1, v.getCod_cliente());
                ps.setInt(2, v.getCod_vendedor());
                ps.setString(3, v.getNumero_venta());
                ps.setFloat(4, v.getMonto());
                ps.setString(5, v.getEstado());
                resultado=ps.executeUpdate();
        }catch (Exception e)
        {
          System.err.println("Got an exception!");
          System.err.println(e.getMessage());
        }
        return resultado;
    }
    
    public int crearDetalleVenta(DetalleVenta dv){
        String sql="insert into detalle_venta(id_venta,id_producto,cantidad,precio) values (?,?,?,?);";
        try {
           con= cn.Conectar();
            ps=con.prepareStatement(sql);
            ps.setString(1, dv.getId_venta());
            ps.setInt(2, dv.getId_producto());
            ps.setInt(3, dv.getCantidad());
            ps.setFloat(4, dv.getPrecio());
            resultado=ps.executeUpdate();
        } catch (Exception e)
    {
      System.err.println("Got an exception!");
      System.err.println(e.getMessage());
    }
        return resultado;
    }
}
