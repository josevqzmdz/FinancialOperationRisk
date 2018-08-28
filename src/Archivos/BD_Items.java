package Archivos;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.StringTokenizer;



public class BD_Items {
    String linea;         
    int ID_Item, ID_Proveedor, Caducidad, PrecioCompra, PrecioVenta,Cantidad;
    String Descripcion, DescripcionCorta, UnidadMedida;
    ArrayList<String> Arr_Descripcion;
    ArrayList<Integer> Arr_IDItem,Arr_IDProveedor,Arr_Caducidad, Arr_Cantidad, Arr_Precio;    
    
    public BD_Items()
    {
        Arr_IDItem=new ArrayList();
        Arr_IDProveedor=new ArrayList();
        Arr_Descripcion=new ArrayList();
        Arr_Caducidad=new ArrayList();
        Arr_Cantidad=new ArrayList();
        Arr_Precio=new ArrayList();
        
        try{
               BufferedReader entrada =new BufferedReader( 
                       new FileReader("C:\\Users\\Public\\USUARIOS.csv"));

               entrada.readLine();

               //"ID_Item; ID_Proveedor; Descripcion; DescripcionCorta; Caducidad; Cantidad;PrecioCompra;PrecioCompra;UnidadMedida"
               while ((linea=entrada.readLine())!=null) {

                   StringTokenizer str =new StringTokenizer(linea,";");
                   int iditem=Integer.parseInt(str.nextToken());
                   ID_Item=iditem;
                   int idproveedor=Integer.parseInt(str.nextToken());
                   ID_Proveedor=idproveedor;
                   Descripcion=str.nextToken();
                   DescripcionCorta=str.nextToken();
                   int caducidad=Integer.parseInt(str.nextToken());;
                   Caducidad=caducidad;
                   int cantidad=Integer.parseInt(str.nextToken());
                   Cantidad=cantidad;
                   int preciocompra=Integer.parseInt(str.nextToken());
                   PrecioCompra=preciocompra;
                   int precioventa=Integer.parseInt(str.nextToken());
                   PrecioVenta=preciocompra;
                   UnidadMedida=str.nextToken();

                   
                   Arr_IDItem.add(ID_Item);
                   Arr_IDProveedor.add(ID_Proveedor);
                   Arr_Descripcion.add(Descripcion);
                   Arr_Caducidad.add(Caducidad);
                   Arr_Cantidad.add(Cantidad);
                   Arr_Precio.add(PrecioCompra);
                   
                }
               if (entrada!=null) {
                   entrada.close();
               }

           }
           catch(FileNotFoundException ex){
               System.out.println("No existe el fichero");
               ex.printStackTrace();
           }
           catch(IOException ex){
                   System.out.println("Error");
                   ex.printStackTrace();
           } 
        
        
    }

    public ArrayList<String> getArr_Descripcion() {
        return Arr_Descripcion;
    }

    public void setArr_Descripcion(ArrayList<String> Arr_Descripcion) {
        this.Arr_Descripcion = Arr_Descripcion;
    }

    public ArrayList<Integer> getArr_IDItem() {
        return Arr_IDItem;
    }

    public void setArr_IDItem(ArrayList<Integer> Arr_IDItem) {
        this.Arr_IDItem = Arr_IDItem;
    }

    public ArrayList<Integer> getArr_IDProveedor() {
        return Arr_IDProveedor;
    }

    public void setArr_IDProveedor(ArrayList<Integer> Arr_IDProveedor) {
        this.Arr_IDProveedor = Arr_IDProveedor;
    }

    public ArrayList<Integer> getArr_Caducidad() {
        return Arr_Caducidad;
    }

    public void setArr_Caducidad(ArrayList<Integer> Arr_Caducidad) {
        this.Arr_Caducidad = Arr_Caducidad;
    }

    public ArrayList<Integer> getArr_Cantidad() {
        return Arr_Cantidad;
    }

    public void setArr_Cantidad(ArrayList<Integer> Arr_Cantidad) {
        this.Arr_Cantidad = Arr_Cantidad;
    }

    public ArrayList<Integer> getArr_Precio() {
        return Arr_Precio;
    }

    public void setArr_Precio(ArrayList<Integer> Arr_Precio) {
        this.Arr_Precio = Arr_Precio;
    }
}
