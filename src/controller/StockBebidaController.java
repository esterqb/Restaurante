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

/**
 * FXML Controller class
 *
 * @author ester
 */
public class StockBebidaController implements Initializable {
    private List<Plato> ticket = new ArrayList<>();
    private Map<String, Plato> platos;

    @FXML
    private ImageView homeButton;
    @FXML
    private ImageView backButton;
    @FXML
    private ImageView saveButton;
    private Button addCoke;
    private Button deleteCoke;
    private Label contador;
    private Button addNaranja;
    private Button deleteNaranja;
    private Label contador2;
    private Button addCokeZero;
    private Button deleteCokeZero;
    private Label contador1;
    private Button addLimon;
    private Button deleteLimon;
    private Label contador3;
    private Button addAgua;
    private Button deleteAgua;
    private Label contador5;
    private Button addNestea;
    private Button deleteNestea;
    private Label contador4;
    private Button addCerveza;
    private Button deleteCerveza;
    private Label contador6;
    private Button addVino;
    private Button deleteVino;
    private Label contador7;

    /**
     * Initializes the controller class.
     */
@Override
    public void initialize(URL url, ResourceBundle rb) {
        platos = new HashMap<>();
        platos.put("Coca-Cola pack 24", new Plato("Coca-Cola pack 24",18.00));
        platos.put("Cola Zero pack 24", new Plato("Cola Zero pack 24",18.00));
        platos.put("Fanta naranja pack 24", new Plato("Fanta naranja  pack 24",18.00));
        platos.put("Fanta limon pack 24", new Plato("Fanta limon  pack 24",18.00));
        platos.put("Nestea pack 24", new Plato("Nestea pack 24",20.00));
        platos.put("Agua 1,5l pack 6", new Plato("Agua 1,5l pack 6",2.00));
        platos.put("Cerveza pack 24", new Plato("Cerveza pack 24",21.00));
        platos.put("Vino botella unidades", new Plato("Vino botella unidades",4.50));
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
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/VistaMain.fxml"));
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
    private void save(MouseEvent event) {
        for (Plato p : platos.values()) {
        if (p.getCantidad() > 0) {
            boolean existe = false;
            for (Plato t : ticket) {
                if (t.getNombre().equals(p.getNombre())) {
                    t.setCantidad(p.getCantidad());
                    t.setComentario(p.getComentario());
                    existe = true;
                    break;
                    }
                }
                if (!existe) {
                Plato nuevo = new Plato(p.getNombre(),p.getPrecio());
                nuevo.setCantidad(p.getCantidad());
                nuevo.setComentario(p.getComentario());
                ticket.add(nuevo);
                }
            }
        }mostrarInfo("Pedido guardado", "Bebidas añadidas a la lista correctamente.");
        guardarTicketEnArchivo();
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
    
    private void guardarTicketEnArchivo() {
        String ticketStr = generarTicket();

        File carpeta = new File("src/tickets");
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        int numero = 1;
        File archivo;
        do {
            archivo = new File(carpeta, "ticket" + numero + ".txt");
            numero++;
        } while (archivo.exists());

        try (PrintWriter out = new PrintWriter(archivo)) {
            out.print(ticketStr);
            mostrarInfo("Ticket guardado", "La lista se ha guardado en " + archivo.getName());
        } catch (IOException e) {
            mostrarInfo("Error", "No se pudo guardar ticket: " + e.getMessage());
        }
    }

    private void add(MouseEvent event) {
        Object src = event.getSource();
        if (src == null) return;

        if (esBotonDe(event, addCoke)) {
            actualizarContador("Coca-Cola pack 24", contador, +1);
        } else if (esBotonDe(event, addCokeZero)) {
            actualizarContador("Cola Zero pack 24", contador1, +1);
        } else if (esBotonDe(event, addNaranja)) {
            actualizarContador("Fanta naranja pack 24", contador2, +1);
        } else if (esBotonDe(event, addLimon)) {
            actualizarContador("Fanta limon pack 24", contador3, +1);
        } else if (esBotonDe(event, addNestea)) {
            actualizarContador("Nestea pack 24", contador4, +1);
        } else if (esBotonDe(event, addAgua)) {
            actualizarContador("Agua 1,5l pack 6", contador5, +1);
        }else if (esBotonDe(event, addCerveza)) {
            actualizarContador("Cerveza pack 24", contador6, +1);
        }else if (esBotonDe(event, addVino)) {
            actualizarContador("Vino botella unidades", contador7, +1);
        }
    }

    private void delete(MouseEvent event) {
        Object src = event.getSource();
        if (src == null) return;

        if (esBotonDe(event, deleteCoke)) {
            actualizarContador("Coca-Cola pack 24", contador, -1);
        } else if (esBotonDe(event, deleteCokeZero)) {
            actualizarContador("Cola Zero pack 24", contador1, -1);
        } else if (esBotonDe(event, deleteNaranja)) {
            actualizarContador("Fanta naranja pack 24", contador2, -1);
        } else if (esBotonDe(event, deleteLimon)) {
            actualizarContador("Fanta limon pack 24", contador3, -1);
        } else if (esBotonDe(event, deleteNestea)) {
            actualizarContador("Nestea pack 24", contador4, -1);
        } else if (esBotonDe(event, deleteAgua)) {
            actualizarContador("Agua 1,5l pack 6", contador5, -1);
        }else if (esBotonDe(event, deleteCerveza)) {
            actualizarContador("Cerveza pack 24", contador6, -1);
        }else if (esBotonDe(event, deleteVino)) {
            actualizarContador("Vino botella unidades", contador7, -1);
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
