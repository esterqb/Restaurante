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
public class EnsaladasController implements Initializable {
    private List<Plato> ticket = new ArrayList<>();
    private Map<String, Plato> platos;

    @FXML
    private ImageView homeButton;
    @FXML
    private ImageView backButton;
    @FXML
    private ImageView saveButton;
    @FXML
    private Button addCherry;
    @FXML
    private Button deleteCherry;
    @FXML
    private TextArea comentarios;
    @FXML
    private Button commentCherry;
    @FXML
    private Label contador;
    @FXML
    private Button addCabrales;
    @FXML
    private Button deleteCabrales;
    @FXML
    private TextArea comentarios2;
    @FXML
    private Button commentCabrales;
    @FXML
    private Label contador2;
    @FXML
    private Button addPistacho;
    @FXML
    private Button deletePistacho;
    @FXML
    private TextArea comentarios1;
    @FXML
    private Button commentPistacho;
    @FXML
    private Label contador1;
    @FXML
    private Button addCesar;
    @FXML
    private Button deleteCesar;
    @FXML
    private TextArea comentarios3;
    @FXML
    private Button commentCesar;
    @FXML
    private Label contador3;
    @FXML
    private Button addFrutos;
    @FXML
    private Button deleteFrutos;
    @FXML
    private TextArea comentarios5;
    @FXML
    private Button commentFrutos;
    @FXML
    private Label contador5;
    @FXML
    private Button addMezclum;
    @FXML
    private Button deleteMezclum;
    @FXML
    private TextArea comentarios4;
    @FXML
    private Button commentMezclum;
    @FXML
    private Label contador4;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        platos = new HashMap<>();
        platos.put("Ensalada cherry", new Plato("Ensalada cherry",4.50));
        platos.put("Ensalada pistacho", new Plato("Ensalada pistacho",6.00));
        platos.put("Ensalada cabrales", new Plato("Ensalada cabrales",5.50));
        platos.put("Ensalada Cesar", new Plato("Ensalada Cesar",4.50));
        platos.put("Ensalada mezclum", new Plato("Ensalada mezclum",4.00));
        platos.put("Ensalada frutos secos", new Plato("Ensalada frutos secos",4.00));
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
    mostrarInfo("Guardado parcial", "Ensaladas añadidas al ticket.");
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

        if (esBotonDe(event, addCherry)) {
            actualizarContador("Ensalada cherry", contador, +1);
        } else if (esBotonDe(event, addPistacho)) {
            actualizarContador("Ensalada pistacho", contador1, +1);
        } else if (esBotonDe(event, addCabrales)) {
            actualizarContador("Ensalada cabrales", contador2, +1);
        } else if (esBotonDe(event, addCesar)) {
            actualizarContador("Ensalada Cesar", contador3, +1);
        } else if (esBotonDe(event, addMezclum)) {
            actualizarContador("Ensalada mezclum", contador4, +1);
        } else if (esBotonDe(event, addFrutos)) {
            actualizarContador("Ensalada frutos secos", contador5, +1);
        }
    }

    @FXML
    private void delete(MouseEvent event) {
        Object src = event.getSource();
        if (src == null) return;

        if (esBotonDe(event, deleteCherry)) {
            actualizarContador("Ensalada cherry", contador, -1);
        } else if (esBotonDe(event, deletePistacho)) {
            actualizarContador("Ensalada pistacho", contador1, -1);
        } else if (esBotonDe(event, deleteCabrales)) {
            actualizarContador("Ensalada cabrales", contador2, -1);
        } else if (esBotonDe(event, deleteCesar)) {
            actualizarContador("Ensalada Cesar", contador3, -1);
        } else if (esBotonDe(event, deleteMezclum)) {
            actualizarContador("Ensalada mezclum", contador4, -1);
        } else if (esBotonDe(event, deleteFrutos)) {
            actualizarContador("Ensalada frutos secos", contador5, -1);
        }
    }

    @FXML
    private void comment(MouseEvent event) {
        Object src = event.getSource();
        if (src == null) return;

        if (esBotonDe(event, commentCherry)) { 
            guardarComentario("Ensalada cherry", comentarios);
        } else if (esBotonDe(event, commentPistacho)) {
            guardarComentario("Ensalada pistacho", comentarios1);
        } else if (esBotonDe(event, commentCabrales)) {
            guardarComentario("Ensalada cabrales", comentarios2);
        } else if (esBotonDe(event, commentCesar)) {
            guardarComentario("Ensalada Cesar", comentarios3);
        } else if (esBotonDe(event, commentMezclum)) {
            guardarComentario("Ensalada mezclum", comentarios4);
        } else if (esBotonDe(event, commentFrutos)) {
            guardarComentario("Ensalada frutos secos", comentarios5);
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
