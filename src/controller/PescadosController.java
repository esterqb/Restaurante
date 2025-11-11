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
public class PescadosController implements Initializable {
    private List<Plato> ticket = new ArrayList<>();
    private Map<String, Plato> platos;

    @FXML
    private ImageView homeButton;
    @FXML
    private ImageView backButton;
    @FXML
    private ImageView saveButton;
    @FXML
    private Button addCazon;
    @FXML
    private Button deleteCazon;
    @FXML
    private TextArea comentarios;
    @FXML
    private Button commentCazon;
    @FXML
    private Label contador;
    @FXML
    private Button addChipiFritos;
    @FXML
    private Button deleteChipiFritos;
    @FXML
    private TextArea comentarios2;
    @FXML
    private Button commentChipiFritos;
    @FXML
    private Label contador2;
    @FXML
    private Button addVariado;
    @FXML
    private Button deleteVariado;
    @FXML
    private TextArea comentarios1;
    @FXML
    private Button commentVariado;
    @FXML
    private Label contador1;
    @FXML
    private Button addChipiPlancha;
    @FXML
    private Button deleteChipiPlancha;
    @FXML
    private TextArea comentarios3;
    @FXML
    private Button commentChipiPlancha;
    @FXML
    private Label contador3;
    @FXML
    private Button addCalamaresPlancha;
    @FXML
    private Button deleteCalamaresPlancha;
    @FXML
    private TextArea comentarios5;
    @FXML
    private Button commentCalamaresPlancha;
    @FXML
    private Label contador5;
    @FXML
    private Button addCalamaresFritos;
    @FXML
    private Button deleteCalamaresFritos;
    @FXML
    private TextArea comentarios4;
    @FXML
    private Button commentCalamaresFritos;
    @FXML
    private Label contador4;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        platos = new HashMap<>();
        platos.put("Cazon en adobo", new Plato("Cazon en adobo",7.50));
        platos.put("Variado de pescado", new Plato("Variado de pescado",8.00));
        platos.put("Chipirones fritos", new Plato("Chipirones fritos",6.50));
        platos.put("Chipirones a la plancha", new Plato("Chipirones a la plancha",7.00));
        platos.put("Calamares fritos", new Plato("Calamares fritos",6.50));
        platos.put("Calamares a la plancha", new Plato("Calamares a la plancha",7.00));
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
    mostrarInfo("Guardado parcial", "Pescado añadido al ticket.");
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

        if (esBotonDe(event, addCazon)) {
            actualizarContador("Cazon en adobo", contador, +1);
        } else if (esBotonDe(event, addVariado)) {
            actualizarContador("Variado de pescado", contador1, +1);
        } else if (esBotonDe(event, addChipiFritos)) {
            actualizarContador("Chipirones fritos", contador2, +1);
        } else if (esBotonDe(event, addChipiPlancha)) {
            actualizarContador("Chipirones a la plancha", contador3, +1);
        } else if (esBotonDe(event, addCalamaresFritos)) {
            actualizarContador("Calamares fritos", contador4, +1);
        } else if (esBotonDe(event, addCalamaresPlancha)) {
            actualizarContador("Calamares a la plancha", contador5, +1);
        }
    }

    @FXML
    private void delete(MouseEvent event) {
        Object src = event.getSource();
        if (src == null) return;

        if (esBotonDe(event, deleteCazon)) {
            actualizarContador("Cazon en adobo", contador, -1);
        } else if (esBotonDe(event, deleteVariado)) {
            actualizarContador("Variado de pescado", contador1, -1);
        } else if (esBotonDe(event, deleteChipiFritos)) {
            actualizarContador("Chipirones fritos", contador2, -1);
        } else if (esBotonDe(event, deleteChipiPlancha)) {
            actualizarContador("Chipirones a la plancha", contador3, -1);
        } else if (esBotonDe(event, deleteCalamaresFritos)) {
            actualizarContador("Calamares fritos", contador4, -1);
        } else if (esBotonDe(event, deleteCalamaresPlancha)) {
            actualizarContador("Calamares a la plancha", contador5, -1);
        }
    }

    @FXML
    private void comment(MouseEvent event) {
        Object src = event.getSource();
        if (src == null) return;

        if (esBotonDe(event, commentCazon)) { 
            guardarComentario("Cazon en adobo", comentarios);
        } else if (esBotonDe(event, commentVariado)) {
            guardarComentario("Variado de pescado", comentarios1);
        } else if (esBotonDe(event, commentChipiFritos)) {
            guardarComentario("Chipirones fritos", comentarios2);
        } else if (esBotonDe(event, commentChipiPlancha)) {
            guardarComentario("Chipirones a la plancha", comentarios3);
        } else if (esBotonDe(event, commentCalamaresFritos)) {
            guardarComentario("Calamares fritos", comentarios4);
        } else if (esBotonDe(event, commentCalamaresPlancha)) {
            guardarComentario("Calamares a la plancha", comentarios5);
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
