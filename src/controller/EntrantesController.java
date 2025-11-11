package controller;

import java.io.File;
import model.Plato;
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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import model.Plato;
import model.TicketManager;

public class EntrantesController implements Initializable {
    private List<Plato> ticket = new ArrayList<>();
    private Map<String, Plato> platos;

    @FXML
    private Label contador;// Salmorejo
    @FXML
    private Label contador1;//Ensaladilla rusa
    @FXML
    private Label contador2;// Salpicón de marisco
    @FXML
    private Label contador3;// Anchoas
    @FXML
    private Label contador4;// Patatas fritas
    @FXML
    private Label contador5;// Patatas bravas

    @FXML
    private ImageView homeButton;
    @FXML
    private ImageView backButton;
    @FXML
    private ImageView saveButton;
    @FXML
    private TextArea comentarios;
    @FXML
    private TextArea comentarios1;
    @FXML
    private TextArea comentarios2;
    @FXML
    private TextArea comentarios3;
    @FXML
    private TextArea comentarios4;
    @FXML
    private TextArea comentarios5;
    @FXML
    private Button addSalmorejo;
    @FXML
    private Button deleteSalmorejo;
    @FXML
    private Button commentSalmorejo;
    @FXML
    private Button addSalpicon;
    @FXML
    private Button deleteSalpicon;
    @FXML
    private Button commentSalpicon;
    @FXML
    private Button addEnsaladilla;
    @FXML
    private Button deleteEnsaladilla;
    @FXML
    private Button commentEnsaladilla;
    @FXML
    private Button addAnchoas;
    @FXML
    private Button deleteAnchoas;
    @FXML
    private Button commentAnchoas;
    @FXML
    private Button addBravas;
    @FXML
    private Button deleteBravas;
    @FXML
    private Button commentBravas;
    @FXML
    private Button addPatatas;
    @FXML
    private Button deletePatatas;
    @FXML
    private Button commentPatatas;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        platos = new HashMap<>();
        platos.put("Salmorejo cordobes", new Plato("Salmorejo cordobes",3.50));
        platos.put("Ensaladilla rusa", new Plato("Ensaladilla rusa",3.50));
        platos.put("Salpicon de marisco", new Plato("Salpicon de marisco",4.00));
        platos.put("Anchoas", new Plato("Anchoas",3.50));
        platos.put("Patatas fritas", new Plato("Patatas fritas",3.00));
        platos.put("Patatas bravas", new Plato("Patatas bravas",3.50));
    }

    @FXML
    private void add(MouseEvent event) {
        Object src = event.getSource();
        if (src == null) return;

        if (esBotonDe(event, addSalmorejo)) {
            actualizarContador("Salmorejo cordobes", contador, +1);
        } else if (esBotonDe(event, addEnsaladilla)) {
            actualizarContador("Ensaladilla rusa", contador1, +1);
        } else if (esBotonDe(event, addSalpicon)) {
            actualizarContador("Salpicon de marisco", contador2, +1);
        } else if (esBotonDe(event, addAnchoas)) {
            actualizarContador("Anchoas", contador3, +1);
        } else if (esBotonDe(event, addPatatas)) {
            actualizarContador("Patatas fritas", contador4, +1);
        } else if (esBotonDe(event, addBravas)) {
            actualizarContador("Patatas bravas", contador5, +1);
        }
    }


    @FXML
    private void delete(MouseEvent event) {
        Object src = event.getSource();
        if (src == null) return;

        if (esBotonDe(event, deleteSalmorejo)) {
            actualizarContador("Salmorejo cordobes", contador, -1);
        } else if (esBotonDe(event, deleteEnsaladilla)) {
            actualizarContador("Ensaladilla rusa", contador1, -1);
        } else if (esBotonDe(event, deleteSalpicon)) {
            actualizarContador("Salpicon de marisco", contador2, -1);
        } else if (esBotonDe(event, deleteAnchoas)) {
            actualizarContador("Anchoas", contador3, -1);
        } else if (esBotonDe(event, deletePatatas)) {
            actualizarContador("Patatas fritas", contador4, -1);
        } else if (esBotonDe(event, deleteBravas)) {
            actualizarContador("Patatas bravas", contador5, -1);
        }
    }

    @FXML
    private void comment(MouseEvent event) {
        Object src = event.getSource();
        if (src == null) return;

        if (esBotonDe(event, commentSalmorejo)) { 
            guardarComentario("Salmorejo cordobes", comentarios);
        } else if (esBotonDe(event, commentEnsaladilla)) {
            guardarComentario("Ensaladilla rusa", comentarios1);
        } else if (esBotonDe(event, commentSalpicon)) {
            guardarComentario("Salpicon de marisco", comentarios2);
        } else if (esBotonDe(event, commentAnchoas)) {
            guardarComentario("Anchoas", comentarios3);
        } else if (esBotonDe(event, commentPatatas)) {
            guardarComentario("Patatas fritas", comentarios4);
        } else if (esBotonDe(event, commentBravas)) {
            guardarComentario("Patatas bravas", comentarios5);
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
    mostrarInfo("Guardado parcial", "Entrantes añadidos al ticket.");
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
}
