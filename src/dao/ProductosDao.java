/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import obj.Producto;
import sertec.ConexionBD;

/**
 *
 * @author ander
 */
public class ProductosDao {
    //Declarar objetos:
    private static Producto pro;
    private static ArrayList listaPro = new ArrayList<>();
    
    
    //Métodos:
    public static void llenarListaProductos(Object[][] lista){
        for(int i = 0; i < lista.length; i++){
            
            //Crear un nuevo prodcuto por cada iteración
            //y guardar sus datos obtenidos de la bd:
            pro = new Producto();
            
            pro.setId(Integer.parseInt(lista[i][0].toString()));
            pro.setCod_barras(lista[i][1].toString());
            pro.setDescripcion(lista[i][2].toString());
            pro.setPrecio(Double.parseDouble(lista[i][3].toString()));
            pro.setStock(Integer.parseInt(lista[i][4].toString()));
            pro.setId_proveedor(Integer.parseInt(lista[i][5].toString()));
            
            //Añadir persona a la lista:
            listaPro.add(pro);
        }
    }

    public static List<Producto> selectProductos(){
        
        //Borrar cualquier carga previa:
        listaPro.clear();
        
        ConexionBD.conectar();
        ConexionBD.ejecutarConsulta("Select id, cod_bar, descri, pre, cant, id_pro From Productos");
        llenarListaProductos(ConexionBD.getDatos());
        ConexionBD.desconectar();
        
        return listaPro;
    }
}
