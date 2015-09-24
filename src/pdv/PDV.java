/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pdv;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import obj.Producto;
import obj.Proveedor;

/**
 *
 * @author ander
 */
public class PDV extends Application {
    
    //Instancia de stage:
    public static Stage ventanaActual;
    
    //VAriable que identifica la operación a realizar:
    public static char operacion = '\0';
    
    //Instancias estaticas de Objetos en memoria:
    public static Producto productoActual;
    public static Proveedor proveedorActual;
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/ui/frmPdv.fxml"));
        
        Scene scene = new Scene(root);
        stage.setTitle("Aplicación de Punto de Venta");
        stage.setMaximized(false);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
    //Método que crean y cierran las ventanas FXML:
    public static void crearVentanas(String recursoFXML, String titulo){
        try{ 
            FXMLLoader loader = new FXMLLoader(PDV.class.getResource(recursoFXML));
            AnchorPane abm = (AnchorPane) loader.load();
             Stage ventana = new Stage();
            ventana.setTitle(titulo);
          
            Scene scene = new Scene(abm);
            ventana.setScene(scene);

            ventana.initModality(Modality.APPLICATION_MODAL);
            
            ventanaActual = ventana;
  
            ventana.showAndWait();  //Comportamiento de los winforms...   
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public static void cerrarVentanas(){
        ventanaActual.close();
    }
    

    
}
