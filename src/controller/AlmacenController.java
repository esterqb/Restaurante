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
import javafx.stage.Stage;
import model.Producto;

/**
 * FXML Controller class
 *
 * @author ester
 */
public class AlmacenController implements Initializable {
    private List<Producto> listaAlmacen = new ArrayList<>();
    private Map<String, Producto> productos;
    @FXML
    private ImageView homeButton;
    @FXML
    private ImageView backButton;
    @FXML
    private Label contador;
    @FXML
    private Label contador1;
    @FXML
    private Label contador2;
    @FXML
    private Label contador3;
    @FXML
    private Label contador4;
    @FXML
    private Label contador5;
    @FXML
    private ImageView saveButton;
    @FXML
    private Button addTomate;
    @FXML
    private Button deleteTomate;
    @FXML
    private Button addAjo;
    @FXML
    private Button deleteAjo;
    @FXML
    private Button addPan;
    @FXML
    private Button deletePan;
    @FXML
    private Button addPatatas;
    @FXML
    private Button deletePatatas;
    @FXML
    private Button addMayonesa;
    @FXML
    private Button deleteMayonesa;
    @FXML
    private Button addKetchup;
    @FXML
    private Button deleteKetchup;
    @FXML
    private Button addZanahorias;
    @FXML
    private Button deleteZanahorias;
    @FXML
    private Button addHuevos;
    @FXML
    private Button deleteHuevos;
    @FXML
    private Button addSurimi;
    @FXML
    private Button deleteSurimi;
    @FXML
    private Button addAnch;
    @FXML
    private Button deleteAnch;
    @FXML
    private Button addBrava;
    @FXML
    private Button deleteBrava;
    @FXML
    private Button addRallado;
    @FXML
    private Button deleteRallado;
    @FXML
    private Button addYork;
    @FXML
    private Button deleteYork;
    @FXML
    private Button addLomo;
    @FXML
    private Button deleteLomo;
    @FXML
    private Button addPimiento;
    @FXML
    private Button deletePimiento;
    @FXML
    private Button addLagarto;
    @FXML
    private Button deleteLagarto;
    @FXML
    private Label contador6;
    @FXML
    private Label contador7;
    @FXML
    private Label contador8;
    @FXML
    private Label contador9;
    @FXML
    private Label contador10;
    @FXML
    private Label contador11;
    @FXML
    private Label contador12;
    @FXML
    private Label contador13;
    @FXML
    private Label contador14;
    @FXML
    private Label contador15;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        productos = new HashMap<>();
        productos.put("Tomates 3kg", new Producto("Tomates 3kg"));
        productos.put("Ajos", new Producto("Tarta abuela"));
        productos.put("Pan", new Producto("Ajos"));
        productos.put("Patatas 5kg", new Producto("Patatas 5kg"));
        productos.put("Zanahorias 1kg", new Producto("Zanahorias 1kg"));
        productos.put("Huevos 24ud", new Producto("Huevos 24ud"));
        productos.put("Mayonesa", new Producto("Mayonesa"));
        productos.put("Ketchup", new Producto("Ketchup"));
        productos.put("Prep salpicon surimi", new Producto("Prep salpicon surimi"));
        productos.put("Anchoas 500g", new Producto("Anchoas 500g"));
        productos.put("Salsa brava", new Producto("Salsa brava"));
        productos.put("Pan rallado", new Producto("Pan rallado"));
        productos.put("Jamon york 2kg", new Producto("Jamon york 2kg"));
        productos.put("Lomo 5kg", new Producto("Lomo 5kg"));
        productos.put("Pimiento verde 1kg", new Producto("Pimiento verde 1kg"));
        productos.put("Lagartito 8kg", new Producto("Lagartito 8kg"));
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
            cambiarVista.setTitle("Vista 1");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void save(MouseEvent event) {
        for (Producto p : productos.values()) {
        if (p.getCantidad() > 0) {
            boolean existe = false;
            for (Producto t : listaAlmacen) {
                if (t.getNombre().equals(p.getNombre())) {
                    t.setCantidad(p.getCantidad());
                    existe = true;
                    break;
                    }
                }
                if (!existe) {
                Producto nuevo = new Producto(p.getNombre());
                nuevo.setCantidad(p.getCantidad());
                listaAlmacen.add(nuevo);
                }
            }
        }mostrarInfo("Pedido guardado", "Productos añadidos a la lista correctamente.");
        guardarTicketEnArchivo();
    }
    
    //Métodos de guardado: apendar al ticket existente
        private String generarTicket() {
        StringBuilder sb = new StringBuilder();
        sb.append("======== TICKET ========\n");
        for (Producto p : listaAlmacen) {
            if (p.getCantidad() > 0) {
                sb.append(p.toString()).append("\n");
            }
        }
        sb.append("========================\n");
        return sb.toString();
    }
    
    private void guardarTicketEnArchivo() {
        String ticketStr = generarTicket();

        File carpeta = new File("src/listaCompra");
        if (!carpeta.exists()) {
            carpeta.mkdirs();
        }

        int numero = 1;
        File archivo;
        do {
            archivo = new File(carpeta, "lista000" + numero + ".txt");
            numero++;
        } while (archivo.exists());

        try (PrintWriter out = new PrintWriter(archivo)) {
            out.print(ticketStr);
            mostrarInfo("Lista guardada", "Se ha guardado en " + archivo.getName());
        } catch (IOException e) {
            mostrarInfo("Error", "No se pudo guardar: " + e.getMessage());
        }
    }

    @FXML
    private void add(MouseEvent event) {
        Object src = event.getSource();
        if (src == null) return;

        if (esBotonDe(event, addTomate)) {
            actualizarContador("Tomates 3kg", contador, +1);
        } else if (esBotonDe(event, addAjo)) {
            actualizarContador("Ajos", contador1, +1);
        } else if (esBotonDe(event, addPan)) {
            actualizarContador("Pan", contador2, +1);
        } else if (esBotonDe(event, addPatatas)) {
            actualizarContador("Patatas 5kg", contador3, +1);
        } else if (esBotonDe(event, addZanahorias)) {
            actualizarContador("Zanahorias 1kg", contador4, +1);
        }else if (esBotonDe(event, addHuevos)) {
            actualizarContador("Huevos 24ud", contador5, +1);
        } else if (esBotonDe(event, addMayonesa)) {
            actualizarContador("Mayonesa", contador6, +1);
        }else if (esBotonDe(event, addKetchup)) {
            actualizarContador("Ketchup", contador7, +1);
        }else if (esBotonDe(event, addSurimi)) {
            actualizarContador("Prep salpicon surimi", contador8, +1);
        }else if (esBotonDe(event, addAnch)) {
            actualizarContador("Anchoas 500g", contador9, +1);
        }else if (esBotonDe(event, addBrava)) {
            actualizarContador("Salsa brava", contador10, +1);
        }else if (esBotonDe(event, addRallado)) {
            actualizarContador("Pan rallado", contador11, +1);
        }else if (esBotonDe(event, addYork)) {
            actualizarContador("Jamon york 2kg", contador12, +1);
        }else if (esBotonDe(event, addLomo)) {
            actualizarContador("Lomo 5kg", contador13, +1);
        }else if (esBotonDe(event, addPimiento)) {
            actualizarContador("Pimiento verde 1kg", contador14, +1);
        }else if (esBotonDe(event, addLagarto)) {
            actualizarContador("Lagartito 8kg", contador15, +1);
        }
    }

    @FXML
    private void delete(MouseEvent event) {
        Object src = event.getSource();
        if (src == null) return;

        if (esBotonDe(event, deleteTomate)) {
            actualizarContador("Tomates 3kg", contador, -1);
        } else if (esBotonDe(event, deleteAjo)) {
            actualizarContador("Ajos", contador1, -1);
        } else if (esBotonDe(event, deletePan)) {
            actualizarContador("Pan", contador2, -1);
        } else if (esBotonDe(event, deletePatatas)) {
            actualizarContador("Patatas 5kg", contador3, -1);
        } else if (esBotonDe(event, deleteZanahorias)) {
            actualizarContador("Zanahorias 1kg", contador4, -1);
        }else if (esBotonDe(event, deleteHuevos)) {
            actualizarContador("Huevos 24ud", contador5, -1);
        } else if (esBotonDe(event, deleteMayonesa)) {
            actualizarContador("Mayonesa", contador6, -1);
        }else if (esBotonDe(event, deleteKetchup)) {
            actualizarContador("Ketchup", contador7, -1);
        }else if (esBotonDe(event, deleteSurimi)) {
            actualizarContador("Prep salpicon surimi", contador8, -1);
        }else if (esBotonDe(event, deleteAnch)) {
            actualizarContador("Anchoas 500g", contador9, -1);
        }else if (esBotonDe(event, deleteBrava)) {
            actualizarContador("Salsa brava", contador10, -1);
        }else if (esBotonDe(event, deleteRallado)) {
            actualizarContador("Pan rallado", contador11, -1);
        }else if (esBotonDe(event, deleteYork)) {
            actualizarContador("Jamon york 2kg", contador12, -1);
        }else if (esBotonDe(event, deleteLomo)) {
            actualizarContador("Lomo 5kg", contador13, -1);
        }else if (esBotonDe(event, deletePimiento)) {
            actualizarContador("Pimiento verde 1kg", contador14, -1);
        }else if (esBotonDe(event, deleteLagarto)) {
            actualizarContador("Lagartito 8kg", contador15, -1);
        }
    }
    
    
   
    private void actualizarContador(String nombre, Label label, int delta) {
        Producto p = productos.get(nombre);
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
    
}
