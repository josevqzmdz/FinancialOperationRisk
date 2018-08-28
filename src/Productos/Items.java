/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Productos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author jose miguel
 */
public class Items {
    /*
    Atributos:
        > ID_Item: tipo NUMBER(4)
    
        > ID_Proveedor
    
        > Descripcion: NVARCHAR2(40)
    
        > DescripcionCorta: NVARCHAR2(40)
    
        > Caducidad: DATE
    
        > UnidadMedida: NVARCHAR2(40) (puede ser una caja, bolsa, paquete, etc)
    
        > PrecioCompra: FLOAT
    
        > PrecioVenta: FLOAT
    
        > Cantidad: INT
    
        > Activo: si esta activo el sistema , BIT
    */
    
    int ID_Item;
    int ID_Proveedor;
    String Descripcion;
    String DescripcionCorta;
    int Caducidad;
    String UnidadMedidad;
    int PrecioCompra;
    int PrecioVenta;
    int Cantidad;
    boolean activo;
            
    public void archivocsv(String nombrefichero, boolean agregar)
    {
        File f;
        f=new File (nombrefichero);
        boolean encabezado = false;
            if(f.exists() && !agregar)
            {
                f.delete();
                encabezado=true;
            }
            if (!f.exists()) {
                encabezado=true;
            }
            FileWriter flujosalida=null;
            BufferedWriter salida=null;

        try{
            flujosalida=new FileWriter(f,agregar);
            salida=new BufferedWriter(flujosalida);
            if (encabezado) {
                salida.write("ID_Item; ID_Proveedor; Descripcion; DescripcionCorta; Caducidad; Cantidad;PrecioCompra;PrecioVenta;UnidadMedida");
                salida.newLine();
            }
            String iditem=String.valueOf(this.ID_Item);
            salida.write(iditem+";");
            salida.write(this.ID_Proveedor+";");
            salida.write(this.Descripcion+";");
            salida.write(this.DescripcionCorta+";");
            salida.write(this.Caducidad+";");
            salida.write(this.Cantidad+";");
            salida.write(this.PrecioCompra+";");
            salida.write(this.PrecioVenta+";");
            salida.write(this.UnidadMedidad+";");
            salida.newLine();
            System.out.println(this.ID_Item+" "+this.ID_Proveedor+" "+this.Descripcion);
            salida.close();
            flujosalida.close();
        }
        catch(IOException ex){
            System.out.println("Error de Salida");
            ex.printStackTrace();
        }
        finally{
            try{
            salida.close();
            flujosalida.close();
            }
            catch(IOException ex){
            System.out.println("Error al cerrar fichero");
            ex.printStackTrace();
        }
        } 
    }
    
    public Items(
        int ID_Item,
        int ID_Proveedor, 
        String Descripcion,
        String DescripcionCorta,
        int caducidad,
        String unidadMedidad,
        int precioCompra,
        int precioVenta,
        int cantidad,
         boolean activo
        ){//inicio de gets & sets
        this.ID_Item = ID_Item;
        this.ID_Proveedor = ID_Proveedor;
        this.Descripcion = Descripcion;
        this.DescripcionCorta = DescripcionCorta;
        this.Caducidad = caducidad;
        this.UnidadMedidad = unidadMedidad;
        this.PrecioCompra = precioCompra;
        this.PrecioVenta = precioVenta;
        this. Cantidad = cantidad;
        this.activo = activo;
        
        archivocsv("C:\\Users\\Public\\ITEMS.csv",true);
    }

    public int getID_Item() {
        return ID_Item;
    }

    public void setID_Item(int ID_Item) {
        this.ID_Item = ID_Item;
    }

    public int getID_Proveedor() {
        return ID_Proveedor;
    }

    public void setID_Proveedor(int ID_Proveedor) {
        this.ID_Proveedor = ID_Proveedor;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getDescripcionCorta() {
        return DescripcionCorta;
    }

    public void setDescripcionCorta(String DescripcionCorta) {
        this.DescripcionCorta = DescripcionCorta;
    }

    public int getCaducidad() {
        return Caducidad;
    }

    public void setCaducidad(int caducidad) {
        this.Caducidad = caducidad;
    }

    public String getUnidadMedidad() {
        return UnidadMedidad;
    }

    public void setUnidadMedidad(String unidadMedidad) {
        this.UnidadMedidad = unidadMedidad;
    }

    public int getPrecioCompra() {
        return PrecioCompra;
    }

    public void setPrecioCompra(int precioCompra) {
        this.PrecioCompra = precioCompra;
    }

    public int getPrevioVenta() {
        return PrecioVenta;
    }

    public void setPrevioVenta(int previoVenta) {
        this.PrecioVenta = previoVenta;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int cantidad) {
        this.Cantidad = cantidad;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    /*Inicio y creacion de archivo */
    
    
}
