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
import javafx.stage.Stage;
import model.Plato;
import model.TicketManager;

/**
 * FXML Controller class
 *
 * @author ester
 */
public class CarnesController implements Initializable {
    private List<Plato> ticket = new ArrayList<>();
    private Map<String, Plato> platos;
    
    @FXML
    private ImageView homeButton;
    @FXML
    private ImageView backButton;
    @FXML
    private ImageView saveButton;
    @FXML
    private Button addFlamenquin;
    @FXML
    private Button deleteFlamenquin;
    @FXML
    private TextArea comentarios;
    @FXML
    private Button commentFlamenquin;
    @FXML
    private Label contador;
    @FXML
    private Button addLagartito;
    @FXML
    private Button deleteLagartito;
    @FXML
    private TextArea comentarios2;
    @FXML
    private Button commentLagartito;
    @FXML
    private Label contador2;
    @FXML
    private Button addCroquetas;
    @FXML
    private Button deleteCroquetas;
    @FXML
    private TextArea comentarios1;
    @FXML
    private Button commentCroquetas;
    @FXML
    private Label contador1;
    @FXML
    private Button addSolomillo;
    @FXML
    private Button deleteSolomillo;
    @FXML
    private TextArea comentarios3;
    @FXML
    private Button commentSolomillo;
    @FXML
    private Label contador3;
    @FXML
    private Button addEntrecot;
    @FXML
    private Button deleteEntrecot;
    @FXML
    private TextArea comentarios5;
    @FXML
    private Button commentEntrecot;
    @FXML
    private Label contador5;
    @FXML
    private Button addPresa;
    @FXML
    private Button deletePresa;
    @FXML
    private TextArea comentarios4;
    @FXML
    private Button commentPresa;
    @FXML
    private Label contador4;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        platos = new HashMap<>();
        platos.put("Flamenquin cordobes", new Plato("Flamenquin cordobes",9.50));
        platos.put("Surtido de croquetas", new Plato("Surtido de croquetas",5.50));
        platos.put("Lagartito iberico", new Plato("Lagartito iberico",8.50));
        platos.put("Solomillo roquefort", new Plato("Solomillo roquefort",8.70));
        platos.put("Presa iberica", new Plato("Presa iberica",10.30));
        platos.put("Entrecot", new Plato("Entrecot",9.50));
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
    mostrarInfo("Guardado parcial", "Carnes añadidas al ticket.");
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

        if (esBotonDe(event, addFlamenquin)) {
            actualizarContador("Flamenquin cordobes", contador, +1);
        } else if (esBotonDe(event, addCroquetas)) {
            actualizarContador("Surtido de croquetas", contador1, +1);
        } else if (esBotonDe(event, addLagartito)) {
            actualizarContador("Lagartito iberico", contador2, +1);
        } else if (esBotonDe(event, addSolomillo)) {
            actualizarContador("Solomillo roquefort", contador3, +1);
        } else if (esBotonDe(event, addPresa)) {
            actualizarContador("Presa iberica", contador4, +1);
        } else if (esBotonDe(event, addEntrecot)) {
            actualizarContador("Entrecot", contador5, +1);
        }
    }

    @FXML
    private void delete(MouseEvent event) {
        Object src = event.getSource();
        if (src == null) return;

        if (esBotonDe(event, deleteFlamenquin)) {
            actualizarContador("Flamenquin cordobes", contador, -1);
        } else if (esBotonDe(event, deleteCroquetas)) {
            actualizarContador("Surtido de croquetas", contador1, -1);
        } else if (esBotonDe(event, deleteLagartito)) {
            actualizarContador("Lagartito iberico", contador2, -1);
        } else if (esBotonDe(event, deleteSolomillo)) {
            actualizarContador("Solomillo roquefort", contador3, -1);
        } else if (esBotonDe(event, deletePresa)) {
            actualizarContador("Presa iberica", contador4, -1);
        } else if (esBotonDe(event, deleteEntrecot)) {
            actualizarContador("Entrecot", contador5, -1);
        }
    }

    @FXML
    private void comment(MouseEvent event) {
        Object src = event.getSource();
        if (src == null) return;

        if (esBotonDe(event, commentFlamenquin)) { 
            guardarComentario("Flamenquin cordobes", comentarios);
        } else if (esBotonDe(event, commentCroquetas)) {
            guardarComentario("Surtido de croquetas", comentarios1);
        } else if (esBotonDe(event, commentLagartito)) {
            guardarComentario("Lagartito iberico", comentarios2);
        } else if (esBotonDe(event, commentSolomillo)) {
            guardarComentario("Solomillo roquefort", comentarios3);
        } else if (esBotonDe(event, commentPresa)) {
            guardarComentario("Presa iberica", comentarios4);
        } else if (esBotonDe(event, commentEntrecot)) {
            guardarComentario("Entrecot", comentarios5);
        }
    }
    
    private void actualizarContador(String nombre, Label label, int delta) {
        Plato p = platos.get(nombre);
        if (p == null) return;

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
    
}
