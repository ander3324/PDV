/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sertec;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ander
 */
public class ConexionBD {
    //Atributos de conexión con BD declarados como CONSTANTES:
    private static final String USU = "root";
    private static final String PASS = "alumno";
    private static final String CC = "jdbc:mysql://localhost:3306/PDV";
   
    private static Connection conexion = null;
    static ResultSet datos = null;  //Acá se guardarán los datos resultantes...

    //Métodos:
    public static Connection conectar() {
        try {

            //Class.forName(DRIVER); //Devolver una instancia del driver MYSQL...
            conexion = DriverManager.getConnection(CC, USU, PASS);
            System.out.println("Conexión exitosa a " + conexion.getCatalog());

            return conexion;

        } catch (Exception e) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }

    public static void desconectar() {
        try {

            conexion.close();
            System.out.println("Desconectado de la BD " + conexion.getCatalog());

        } catch (Exception e) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);

        }
    }

    public static void ejecutarConsulta(String comandoSql) {
        try {

            PreparedStatement st = conexion.prepareStatement(comandoSql);

            //Verificar si es una consulta de selección o de ABM:
            if (comandoSql.toLowerCase().startsWith("select")) {
                datos = st.executeQuery(); //Ejecutar y almacenar...
            } else {
                st.execute();  //Sólo ejecutar...
            }
        } catch (Exception e) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);

        }
    }
    
    //Método que obtiene los datos del ResultSet y los
    //parsea a Object, antes de ser enviados como parámetro de salida.
    public static Object[][] getDatos() {

        Object obj[][] = null;

        try {

            datos.last();

            ResultSetMetaData rsmd = datos.getMetaData();
            int numCols = rsmd.getColumnCount();
            int numFils = datos.getRow();

            obj = new Object[numFils][numCols];
            int j = 0;

            datos.beforeFirst();

            while (datos.next()) {
                for (int i = 0; i < numCols; i++) {

                    obj[j][i] = datos.getObject(i + 1);
                }
                j++;

            }

            return obj;

        } catch (Exception e) {
            Logger.getLogger(ConexionBD.class.getName()).log(Level.SEVERE, null, e);
            return null;
        }
    }
}
