/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos;

import java.time.LocalDateTime;

/**
 *
 * @author jose miguel
 */
public class Inventario {
    /*
    Atributos:
        ID_Inventario
        ID_Item
        FechaInicial
        CostoInicial
        Documento
        TipoItem

    */
    
    String Nombre;
    int ID_Inventario;
    int ID_Item;
    LocalDateTime fechaInicial;
    int costoInicial;
    String tipoItem;
    
    public Inventario(
        //parametros
        String Nombre,
        int ID_Inventario,
        int ID_Item,
        int costoInicial,
        String tipoItem  
    ){//empieza this, get & setters
        
        this.ID_Inventario = ID_Inventario;
        this.ID_Item = ID_Item;
        this.fechaInicial = LocalDateTime.now();
        //se crea el inventario con el dia de hoy
        
        this.costoInicial = costoInicial;
        this.tipoItem = tipoItem;
        
    }
    
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getID_Inventario() {
        return ID_Inventario;
    }

    public void setID_Inventario(int ID_Inventario) {
        this.ID_Inventario = ID_Inventario;
    }

    public int getID_Item() {
        return ID_Item;
    }

    public void setID_Item(int ID_Item) {
        this.ID_Item = ID_Item;
    }

    public LocalDateTime getFechaInicial() {
        return fechaInicial;
    }

    public int getCostoInicial() {
        return costoInicial;
    }

    public void setCostoInicial(int costoInicial) {
        this.costoInicial = costoInicial;
    }

    public String getTipoItem() {
        return tipoItem;
    }

    public void setTipoItem(String tipoItem) {
        this.tipoItem = tipoItem;
    }
}
