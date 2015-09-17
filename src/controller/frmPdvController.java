/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

/**
 *
 * @author ander
 */
public class frmPdvController implements Initializable {
    
    private Label label;
    @FXML
    private TextField txfBuscarProd;
    @FXML
    private TableView<?> tbvProductos;
    @FXML
    private Button btnNuevoProd;
    @FXML
    private Button btnEditarProd;
    @FXML
    private Button btnBorrarProd;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
