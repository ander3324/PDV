/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.ArrayList;
import java.util.List;
import obj.Proveedor;
import sertec.ConexionBD;

/**
 *
 * @author ander
 */
public class ProveedoresDao {

    private static Proveedor prov;
    private static ArrayList listaProv = new ArrayList<>();

    //Métodos:
    public static void llenarListaProveedores(Object[][] lista) {
        for (int i = 0; i < lista.length; i++) {

            prov = new Proveedor();

            prov.setId(Integer.parseInt(lista[i][0].toString()));
            prov.setNombre(lista[i][1].toString());
            prov.setDireccion(lista[i][2].toString());
            prov.setTelefono(lista[i][3].toString());
            prov.setId_localidad(Integer.parseInt(lista[i][4].toString()));

            listaProv.add(prov);
        }
    }

    public static List<Proveedor> selectProveedores() {

        //Borrar cualquier carga previa:
        listaProv.clear();

        ConexionBD.conectar();
        ConexionBD.ejecutarConsulta("Select id, raz_soc, dir, tel, id_loc From Proveedores");
        llenarListaProveedores(ConexionBD.getDatos());
        ConexionBD.desconectar();

        return listaProv;
    }

    public static Proveedor selectUnicoProveedor(String nombre) {

        int id = 0;
        //Borrar cualquier carga previa:
        listaProv.clear();

        ConexionBD.conectar();
        ConexionBD.ejecutarConsulta("Select id, raz_soc, dir, tel, id_loc From Proveedores"+
                " Where raz_soc Like '" + nombre + "'");
        
        ConexionBD.desconectar();

        return (Proveedor)listaProv.get(0);
    }

}
