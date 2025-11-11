/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextInputDialog;
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
public class HacerPedidoController implements Initializable {

    @FXML
    private ImageView homeButton;
    @FXML
    private ImageView backButton;
    @FXML
    private Pane carnes;
    @FXML
    private ImageView carnesPic;
    @FXML
    private Pane entrantes;
    @FXML
    private ImageView entrantesPic;
    @FXML
    private Pane bebidas;
    @FXML
    private ImageView bebidasPic;
    @FXML
    private Pane ensaladas;
    @FXML
    private ImageView ensaladasPic;
    @FXML
    private Pane pescados;
    @FXML
    private ImageView pescadosPic;
    @FXML
    private Pane postres;
    @FXML
    private ImageView postresPic;
    @FXML
    private ImageView saveButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
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
    private void goToCarnesPic(MouseEvent event) {
        Stage cambiarVista = (Stage) carnesPic.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/Carnes.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 4");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void goToCarnes(MouseEvent event) {
        Stage cambiarVista = (Stage) carnes.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/Carnes.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 4");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void goToEntrantesPic(MouseEvent event) {
        Stage cambiarVista = (Stage) entrantesPic.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/Entrantes.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 3");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void goToEntrantes(MouseEvent event) {
        Stage cambiarVista = (Stage) entrantes.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/Entrantes.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 3");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void goToBebidasPic(MouseEvent event) {
        Stage cambiarVista = (Stage) bebidasPic.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/Bebidas.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 7");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void goToBebidas(MouseEvent event) {
        Stage cambiarVista = (Stage) bebidas.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/Bebidas.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 7");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void goToEnsaladasPic(MouseEvent event) {
        Stage cambiarVista = (Stage) ensaladasPic.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/Ensaladas.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 6");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void goToEnsaladas(MouseEvent event) {
        Stage cambiarVista = (Stage) ensaladas.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/Ensaladas.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 6");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void goToPescadosPic(MouseEvent event) {
        Stage cambiarVista = (Stage) pescadosPic.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/Pescados.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 5");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void goToPescados(MouseEvent event) {
        Stage cambiarVista = (Stage) pescados.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/Pescados.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 5");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void goToPostresPic(MouseEvent event) {
        Stage cambiarVista = (Stage) postresPic.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/Postres.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 8");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void goToPostres(MouseEvent event) {
        Stage cambiarVista = (Stage) postres.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/Postres.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 8");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void save(MouseEvent event) {
        List<Plato> pedidoCompleto = TicketManager.getInstance().getPedido();

        if (pedidoCompleto.isEmpty()) {
            mostrarInfo("Pedido vacío", "No hay platos en el pedido para guardar.");
            return;
        }

        // Input para linkear la mesa con la comanda y así no tengo que hacer otra vista y tal
        TextInputDialog dialogoMesa = new TextInputDialog();
        dialogoMesa.setContentText("Número de mesa:");
        Optional<String> resultado = dialogoMesa.showAndWait(); //comprobar que se introduce algo o se cancela
        if (resultado.isEmpty() || resultado.get().trim().isEmpty()) {
            mostrarInfo("Sin mesa", "No se ha introducido número de mesa. Pedido no guardado.");
            return;
        }

        String numeroMesa = resultado.get().trim();

        try {
            int num = Integer.parseInt(numeroMesa);
            if (num <= 0) throw new NumberFormatException();
        } catch (NumberFormatException e) {
            mostrarInfo("Error", "Por favor, introduce un número de mesa válido.");
            return;
        }

        StringBuilder sb = new StringBuilder();
        sb.append("============== TICKET MESA "+numeroMesa+"==============\n");
        sb.append("--------------------------------------------------------------------\n");

        for (Plato p : pedidoCompleto) {
            if (p.getCantidad() > 0) {
                sb.append(p.toString()).append("\n");
            }
        }
        sb.append("=========================================\n");

        File carpeta = new File("src/tickets");
        if (!carpeta.exists()) carpeta.mkdirs();

        int numero = 1;
        File archivo;
        do {
            archivo = new File(carpeta, "mesa" + numeroMesa + "_ticket00" + numero + ".txt");
            numero++;
        } while (archivo.exists());

        try (PrintWriter out = new PrintWriter(archivo)) {
            out.print(sb.toString());
            mostrarInfo("Pedido guardado", "Pedido de la mesa " + numeroMesa + " se ha guardado en " + archivo.getName());
            TicketManager.getInstance().clear(); 
        } catch (IOException e) {
            mostrarInfo("Error", "No se pudo guardar el pedido: " + e.getMessage());
        }
    }

    private void mostrarInfo(String titulo, String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle(titulo);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }
    
}
