/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProductosDao;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import obj.Producto;

/**
 *
 * @author ander
 */
public class frmPdvController implements Initializable {

    private Label label;
    @FXML
    private TextField txfBuscarProd;
    @FXML
    private TableView<Producto> tbvProductos;
    @FXML
    private Button btnNuevoProd;
    @FXML
    private Button btnEditarProd;
    @FXML
    private Button btnBorrarProd;

    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cargarProductos();
    }

    //Métodos que cargar los productos en la TABLA:
    //Método que llena el TableView:
    private void llenarTabla(List<Producto> lista) {
        ObservableList<Producto> datos = tbvProductos.getItems();

        //Borrar cargas previas...
        datos.clear();

        //Recorrer la lista y cargar en TableView:
        for (Producto p : lista) {
            datos.add(p);   //Añadir a la lista...
        }
    }
    
    private void cargarProductos(){
        llenarTabla(ProductosDao.selectProductos());
    }

    @FXML
    private void buscarProductoAction(ActionEvent event) {
    }

    @FXML
    private void nuevoProductoAction(ActionEvent event) {
    }

    @FXML
    private void editarProductoAction(ActionEvent event) {
    }

    @FXML
    private void borrarProductoAction(ActionEvent event) {
    }

}
