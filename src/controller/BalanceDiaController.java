/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.nio.file.Files;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ester
 */
public class BalanceDiaController implements Initializable {

    @FXML
    private ImageView homeButton;
    @FXML
    private ImageView backButton;
    @FXML
    private ImageView calcularTotalButton;
    @FXML
    private TextArea ticketsTextArea;

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

 
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mostrarTicketsDelDia();
    }    
    
    private void mostrarTicketsDelDia() {
        ticketsTextArea.clear();
        File carpeta = new File("src/tickets");
        if (!carpeta.exists()) return;

        LocalDate hoy = LocalDate.now();

        for (File ticket : carpeta.listFiles()) {
            try {
                String contenido = Files.readString(ticket.toPath());
                String[] lineas = contenido.split("\n");

                LocalDate fechaTicket = null;
                for (String linea : lineas) {
                    if (linea.startsWith("Fecha/Hora:")) {
                        String fechaStr = linea.substring(11).trim().split(" ")[0]; // dd/MM/yyyy
                        fechaTicket = LocalDate.parse(fechaStr, FORMATO_FECHA);
                        break;
                    }
                }

                if (fechaTicket != null && fechaTicket.equals(hoy)) {
                    ticketsTextArea.appendText(contenido + "\n\n");
                }

            } catch (IOException e) {
                System.err.println("Error leyendo ticket: " + ticket.getName());
            }
        }
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
    private void calcularTotal(MouseEvent event) {
        File carpetaTickets = new File("src/tickets");
        if (!carpetaTickets.exists()) return;

        LocalDate hoy = LocalDate.now();
        int numeroPedidos = 0;
        double totalDinero = 0;

        for (File ticket : carpetaTickets.listFiles()) {
            try {
                String contenido = Files.readString(ticket.toPath());
                String[] lineas = contenido.split("\n");

                LocalDate fechaTicket = null;
                for (String linea : lineas) {
                    if (linea.startsWith("Fecha/Hora:")) {
                        String fechaStr = linea.substring(11).trim().split(" ")[0];
                        fechaTicket = LocalDate.parse(fechaStr, FORMATO_FECHA);
                        break;
                    }
                }

                if (fechaTicket != null && fechaTicket.equals(hoy)) {
                    numeroPedidos++;
                    for (String linea : lineas) {
                        if (linea.startsWith("TOTAL:")) {
                            String montoStr = linea.replace("TOTAL:", "").replace("€", "").trim();
                            montoStr = montoStr.replace(",", ".");
                            double monto = Double.parseDouble(montoStr);
                            totalDinero += monto;
                            break;
                        }
                    }
                }

            } catch (IOException | NumberFormatException e) {
                System.err.println("Error leyendo ticket: " + ticket.getName());
            }
        }

        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Balance del día");
        alerta.setHeaderText("Total de pedidos y dinero del día");
        alerta.setContentText("Número de pedidos: " + numeroPedidos + "\nTotal en caja: " + String.format("%.2f€", totalDinero));
        alerta.showAndWait();

        File carpetaBalance = new File("src/balanceDia");
        if (!carpetaBalance.exists()) carpetaBalance.mkdirs();

        String nombreArchivo = String.format("balancedia_%s.txt", hoy.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")));
        File archivoBalance = new File(carpetaBalance, nombreArchivo);

        String contenidoBalance = "Balance del día " + hoy.format(FORMATO_FECHA) + "\n"
                                + "Número de pedidos: " + numeroPedidos + "\n"
                                + "Total en caja: " + String.format("%.2f€", totalDinero) + "\n";

        try (PrintWriter out = new PrintWriter(archivoBalance)) {
            out.print(contenidoBalance);
            System.out.println("Balance guardado en: " + archivoBalance.getAbsolutePath());
        } catch (IOException e) {
            System.err.println("Error guardando balance: " + e.getMessage());
        }
    }

}
