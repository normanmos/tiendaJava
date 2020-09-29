package Modelo;

import java.sql.Date;

public class Venta {
    int id;
    int cod_cliente;
    int cod_vendedor;
    String numero_venta;
    float monto;
    String estado;

    public Venta() {
    }

    public Venta(int id, int cod_cliente, int cod_vendedor, String numero_venta, float monto, String estado) {
        this.id = id;
        this.cod_cliente = cod_cliente;
        this.cod_vendedor = cod_vendedor;
        this.numero_venta = numero_venta;
        this.monto = monto;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCod_cliente() {
        return cod_cliente;
    }

    public void setCod_cliente(int cod_cliente) {
        this.cod_cliente = cod_cliente;
    }

    public int getCod_vendedor() {
        return cod_vendedor;
    }

    public void setCod_vendedor(int cod_vendedor) {
        this.cod_vendedor = cod_vendedor;
    }

    public String getNumero_venta() {
        return numero_venta;
    }

    public void setNumero_venta(String numero_venta) {
        this.numero_venta = numero_venta;
    }

    public float getMonto() {
        return monto;
    }

    public void setMonto(float monto) {
        this.monto = monto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    
}
