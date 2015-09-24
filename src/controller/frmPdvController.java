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
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import jfx.messagebox.MessageBox;
import obj.Producto;
import static pdv.PDV.*;

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

    boolean dobleClick = false;

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

    private void cargarProductos() {
        llenarTabla(ProductosDao.selectProductos());
    }

    @FXML
    private void buscarProductoAction(ActionEvent event) {
        llenarTabla(ProductosDao.selectProductos(txfBuscarProd.getText().trim()));
    }

    @FXML
    private void nuevoProductoAction(ActionEvent event) {
        crearVentanas("/ui/frmProductos.fxml", "Nuevo Producto");
    }

    @FXML
    private void editarProductoAction(ActionEvent event) {
        editar();
    }

    void editar() {
        try {
            operacion = 'M';
            productoActual = new Producto();
            productoActual = tbvProductos.getSelectionModel().getSelectedItem();

            crearVentanas("/ui/frmProductos.fxml", "Modificar Producto");

            cargarProductos();

        } catch (Exception e) {
            //Capturar la excepción y manejarla:
            MessageBox.show(ventanaActual, "No hay libros seleccionados para modificar.",
                    "Atención", MessageBox.ICON_WARNING | MessageBox.OK);
        }
    }

    @FXML
    private void borrarProductoAction(ActionEvent event) {
    }

    @FXML
    private void buscarDinamico(KeyEvent event) {
        llenarTabla(ProductosDao.selectProductos(txfBuscarProd.getText().trim()));
    }

    @FXML
    private void editarMouseClicked(MouseEvent event) {
        if (event.getButton().equals(MouseButton.PRIMARY)) {
            if (event.getClickCount() == 2) {
                editar();
                dobleClick = true;
            } else if (event.getClickCount() == 1) {
                dobleClick = false;
            }
        }
    }

}
