/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.ProveedoresDao;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import obj.Proveedor;
import static pdv.PDV.*;

/**
 * FXML Controller class
 *
 * @author ander
 */
public class FrmProductosController implements Initializable {

    @FXML
    private TextField txfCodBar;
    @FXML
    private TextField txfDescri;
    @FXML
    private TextField txfStock;
    @FXML
    private TextField txfPrecio;
    @FXML
    private ComboBox<String> cmbProvs;
    @FXML
    private Button btnGuardar;
    @FXML
    private Button btnCancel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {

        // TODO
        cargarProveedores();
        if(operacion=='M'){
            txfCodBar.setText(productoActual.getCod_barras());
            txfDescri.setText(productoActual.getDescripcion());
            txfPrecio.setText(String.valueOf(productoActual.getPrecio()));
            txfStock.setText(String.valueOf(productoActual.getStock()));
            cmbProvs.getSelectionModel().select(productoActual.getId_proveedor());
            
        }
        
    }

    void cargarProveedores() {
        cmbProvs.getItems().clear();
        for (Proveedor p : ProveedoresDao.selectProveedores()) {
            cmbProvs.getItems().add(p.getNombre());
        }
        cmbProvs.getSelectionModel().select(0);
    }

    @FXML
    private void guardarAction(ActionEvent event) {
    }

    @FXML
    private void cancelAction(ActionEvent event) {
        cerrarVentanas();
    }

}
