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
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Plato;
import model.TicketManager;

/**
 * FXML Controller class
 *
 * @author ester
 */
public class PostresController implements Initializable {
    private List<Plato> ticket = new ArrayList<>();
    private Map<String, Plato> platos;

    @FXML
    private ImageView homeButton;
    @FXML
    private ImageView backButton;
    @FXML
    private ImageView saveButton;
    @FXML
    private Button addCheese;
    @FXML
    private Button deleteCheese;
    @FXML
    private Label contador;
    @FXML
    private Pane entrantes;
    @FXML
    private Button addComadre;
    @FXML
    private Button deleteComadre;
    @FXML
    private Label contador2;
    @FXML
    private Pane entrantes11;
    @FXML
    private Button addAbuela;
    @FXML
    private Button deleteAbuela;
    @FXML
    private Label contador1;
    @FXML
    private Pane entrantes1;
    @FXML
    private Button addChoco;
    @FXML
    private Button deleteChoco;
    @FXML
    private Label contador3;
    @FXML
    private Pane entrantes12;
    @FXML
    private Button addCoulant;
    @FXML
    private Button deleteCoulant;
    @FXML
    private Label contador5;
    @FXML
    private Pane entrantes112;
    @FXML
    private Button addTartaLimon;
    @FXML
    private Button deleteTartaLimon;
    @FXML
    private Label contador4;
    @FXML
    private Pane entrantes111;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        platos = new HashMap<>();
        platos.put("Tarta de queso", new Plato("Tarta de queso",5.00));
        platos.put("Tarta abuela", new Plato("Tarta abuela",5.50));
        platos.put("Tarta comadre", new Plato("Tarta comadre",6.00));
        platos.put("Tarta choco", new Plato("Tarta choco",5.00));
        platos.put("Tarta limon", new Plato("Tarta limon",4.50));
        platos.put("Coulant", new Plato("Coulant",4.00));
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
    mostrarInfo("Guardado parcial", "Postres añadidos al ticket.");
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

        if (esBotonDe(event, addCheese)) {
            actualizarContador("Tarta de queso", contador, +1);
        } else if (esBotonDe(event, addAbuela)) {
            actualizarContador("Tarta abuela", contador1, +1);
        } else if (esBotonDe(event, addComadre)) {
            actualizarContador("Tarta comadre", contador2, +1);
        } else if (esBotonDe(event, addChoco)) {
            actualizarContador("Tarta choco", contador3, +1);
        } else if (esBotonDe(event, addTartaLimon)) {
            actualizarContador("Tarta limon", contador4, +1);
        } else if (esBotonDe(event, addCoulant)) {
            actualizarContador("Coulant", contador5, +1);
        }
    }

    @FXML
    private void delete(MouseEvent event) {
                
        Object src = event.getSource();
        if (src == null) return;

        if (esBotonDe(event, deleteCheese)) {
            actualizarContador("Tarta de queso", contador, -1);
        } else if (esBotonDe(event, deleteAbuela)) {
            actualizarContador("Tarta abuela", contador1, -1);
        } else if (esBotonDe(event, deleteComadre)) {
            actualizarContador("Tarta comadre", contador2, -1);
        } else if (esBotonDe(event, deleteChoco)) {
            actualizarContador("Tarta choco", contador3, -1);
        } else if (esBotonDe(event, deleteTartaLimon)) {
            actualizarContador("Tarta limon", contador4, -1);
        } else if (esBotonDe(event, deleteCoulant)) {
            actualizarContador("Coulant", contador5, -1);
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
