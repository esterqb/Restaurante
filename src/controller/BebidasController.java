/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Plato;
import model.StockManager;
import model.TicketManager;

/**
 * FXML Controller class
 *
 * @author ester
 */
public class BebidasController implements Initializable {
    private List<Plato> ticket = new ArrayList<>();
    private Map<String, Plato> platos;

    @FXML
    private ImageView homeButton;
    @FXML
    private ImageView backButton;
    @FXML
    private ImageView saveButton;
    @FXML
    private Button addCoke;
    @FXML
    private Button deleteCoke;
    @FXML
    private Label contador;
    @FXML
    private Pane entrantes;
    @FXML
    private Label contador2;
    @FXML
    private Pane entrantes11;
    @FXML
    private Label contador1;
    @FXML
    private Pane entrantes1;
    @FXML
    private Label contador3;
    @FXML
    private Pane entrantes12;
    @FXML
    private Label contador5;
    @FXML
    private Pane entrantes112;
    @FXML
    private Label contador4;
    @FXML
    private Pane entrantes111;
    @FXML
    private Pane entrantes1111;
    @FXML
    private Pane entrantes1112;
    @FXML
    private Button addNaranja;
    @FXML
    private Button deleteNaranja;
    @FXML
    private Button addCokeZero;
    @FXML
    private Button deleteCokeZero;
    @FXML
    private Button addLimon;
    @FXML
    private Button addAgua;
    @FXML
    private Button deleteAgua;
    @FXML
    private Button addNestea;
    @FXML
    private Button deleteNestea;
    @FXML
    private Button addCerveza;
    @FXML
    private Button deleteCerveza;
    @FXML
    private Label contador6;
    @FXML
    private Button addVino;
    @FXML
    private Button deleteVino;
    @FXML
    private Label contador7;
    @FXML
    private Button deleteLimon;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        platos = new HashMap<>();
        platos.put("Coca-Cola", new Plato("Coca-Cola", 1.80));
        platos.put("Cola Zero", new Plato("Cola Zero", 1.80));
        platos.put("Fanta naranja", new Plato("Fanta naranja", 1.80));
        platos.put("Fanta limon", new Plato("Fanta limon", 1.80));
        platos.put("Nestea", new Plato("Nestea",2.00));
        platos.put("Agua 1,5l", new Plato("Agua 1,5l",1.50));
        platos.put("Cerveza", new Plato("Cerveza", 1.80));
        platos.put("Vino", new Plato("Vino", 5.30));
    }    

    @FXML
    private void goHome(MouseEvent event) {
        Stage cambiarVista = (Stage) homeButton.getScene().getWindow();

        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/VistaMain.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 1");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void goBack(MouseEvent event) {
        Stage cambiarVista = (Stage) backButton.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/HacerPedido.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 2");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void save(MouseEvent event) {for (Plato p : platos.values()) {
        if (p.getCantidad() > 0) {
            Plato nuevo = new Plato(p.getNombre(),p.getPrecio());
            nuevo.setCantidad(p.getCantidad());
            nuevo.setComentario(p.getComentario());
            TicketManager.getInstance().addPlato(nuevo);
        }
    }
    mostrarInfo("Guardado parcial", "Bebidas añadidas al ticket.");
    }
    
    //Métodos de guardado: apendar al ticket existente
        private String generarTicket() {
        StringBuilder sb = new StringBuilder();
        sb.append("======== TICKET ========\n");
        for (Plato p : ticket) {
            if (p.getCantidad() > 0) {
                sb.append(p.toString()).append("\n");
            }
        }
        sb.append("========================\n");
        return sb.toString();
    }
    
    @FXML
    private void add(MouseEvent event) {
        Object src = event.getSource();
        if (src == null) return;

        if (esBotonDe(event, addCoke)) {
            actualizarContador("Coca-Cola", contador, +1);
        } else if (esBotonDe(event, addCokeZero)) {
            actualizarContador("Cola Zero", contador1, +1);
        } else if (esBotonDe(event, addNaranja)) {
            actualizarContador("Fanta naranja", contador2, +1);
        } else if (esBotonDe(event, addLimon)) {
            actualizarContador("Fanta limon", contador3, +1);
        } else if (esBotonDe(event, addNestea)) {
            actualizarContador("Nestea", contador4, +1);
        } else if (esBotonDe(event, addAgua)) {
            actualizarContador("Agua 1,5l", contador5, +1);
        }else if (esBotonDe(event, addCerveza)) {
            actualizarContador("Cerveza", contador6, +1);
        }else if (esBotonDe(event, addVino)) {
            actualizarContador("Vino", contador7, +1);
        }
    }

    @FXML
    private void delete(MouseEvent event) {
        Object src = event.getSource();
        if (src == null) return;

        if (esBotonDe(event, deleteCoke)) {
            actualizarContador("Coca-Cola", contador, -1);
        } else if (esBotonDe(event, deleteCokeZero)) {
            actualizarContador("Cola Zero", contador1, -1);
        } else if (esBotonDe(event, deleteNaranja)) {
            actualizarContador("Fanta naranja", contador2, -1);
        } else if (esBotonDe(event, deleteLimon)) {
            actualizarContador("Fanta limon", contador3, -1);
        } else if (esBotonDe(event, deleteNestea)) {
            actualizarContador("Nestea", contador4, -1);
        } else if (esBotonDe(event, deleteAgua)) {
            actualizarContador("Agua 1,5l", contador5, -1);
        }else if (esBotonDe(event, deleteCerveza)) {
            actualizarContador("Cerveza", contador6, -1);
        }else if (esBotonDe(event, deleteVino)) {
            actualizarContador("Vino", contador7, -1);
        }
    }

   /*
   *Método para conectar el almacén de bebidas StockBebidaController.java con las bebidas que se van pidiendo.
    *Permite controlar que no se puedan pedir bebidas si no hay stock: 
    *Delta positivio: stock--, si no hay suficiente, no aumenta.
    *Si delta negativo: se elimina del ticker, la bebida vuelve al stock++
   */
    private void actualizarContador(String nombre, Label label, int delta) { 
        Plato p = platos.get(nombre);
        if (p == null) return;

        if (delta > 0) {
            if (!StockManager.getInstance().restarStock(nombre, delta)) {
                mostrarInfo("Stock insuficiente", "No hay suficiente stock de " + nombre);
                return; 
            }
        } else { 
            StockManager.getInstance().sumarStock(nombre, -delta);
        }

    int nuevaCantidad = p.getCantidad() + delta;
    if (nuevaCantidad < 0) nuevaCantidad = 0;
    p.setCantidad(nuevaCantidad);
    label.setText(String.valueOf(nuevaCantidad));
}

    private void guardarComentario(String nombre, TextArea area) {
        Plato p = platos.get(nombre);
        if (p == null) return;

        p.setComentario(area.getText());
        mostrarInfo("Comentario guardado", "Comentario para " + nombre + " actualizado.");
    }

    private boolean esBotonDe(MouseEvent event, Node nodo) {
        return event.getSource() == nodo;
    }

    private void mostrarInfo(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @FXML
    private void goToEntrantes(MouseEvent event) {
    }
    
}
