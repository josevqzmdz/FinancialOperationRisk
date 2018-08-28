/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Personas;
import java.awt.FlowLayout;
/**
 *
 * @author jose miguel
 */
public class proveedor extends Persona{
    
    int ID_Pedido;
    String RFC;
    String Tel;//telefono
    String Correo;
    
    public proveedor(String Nombre, String Direccion, String RFC, 
            String Correo, int Dia, int Mes, int Año, String Tel){
        //este es el constructor especial para proveedor
        this.Nombre = Nombre;
        this.Direccion = Direccion;
        this.RFC = RFC;
        this.Correo = Correo;
        this.Dia = Dia;
        this.Mes = Mes;
        this.Año = Año;
        this.Tel = Tel;
        edad = this.calcEdad();
    }
}
