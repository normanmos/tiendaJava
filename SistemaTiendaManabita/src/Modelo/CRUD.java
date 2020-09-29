/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.List;

public interface CRUD {

    public List Mostrar();
    public int Ingresar(Object[] o);
    public int Modificar (Object[] o);
    public void Eliminar(int id);    
}
