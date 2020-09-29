package Modelo;


public class Vendedor{
    int cod_vendedor;
    String cedula;
    String nombres;
    String telefono;
    String estado;
    String usuario;

    public Vendedor() {
    }

    public Vendedor(int cod_vendedor, String cedula, String nombres, String telefono, String estado, String usuario) {
        this.cod_vendedor = cod_vendedor;
        this.cedula = cedula;
        this.nombres = nombres;
        this.telefono = telefono;
        this.estado = estado;
        this.usuario = usuario;
    }

    public int getCod_vendedor() {
        return cod_vendedor;
    }

    public void setCod_vendedor(int cod_vendedor) {
        this.cod_vendedor = cod_vendedor;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }      
}