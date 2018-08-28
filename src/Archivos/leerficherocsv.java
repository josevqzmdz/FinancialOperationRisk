/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Archivos;

import java.io.*;
import java.util.StringTokenizer;

public class leerficherocsv {
    public static void main(String[] args) {
        BD_Items Items = new BD_Items();
        
        System.out.println("Item\n"+Items.Arr_IDItem.toString());
        System.out.println("Proveedor\n"+Items.Arr_IDProveedor.toString());
    
    }
}
