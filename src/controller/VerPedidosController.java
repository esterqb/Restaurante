package controller;

import java.io.File;
import java.io.IOException;
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
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class VerPedidosController implements Initializable {

    @FXML private ImageView homeButton;
    @FXML private ImageView backButton;
    @FXML private DatePicker fechaPicker;
    @FXML private VBox ticketsVBox;
    @FXML private Label resumenLabel;

    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        fechaPicker.setValue(LocalDate.now());
    }
    
    @FXML
    private void verPedidos() {
        LocalDate fechaSeleccionada = fechaPicker.getValue();
        if (fechaSeleccionada == null) {
            mostrarAlerta("Selecciona una fecha antes de buscar.");
            return;
        }

        File carpeta = new File("src/tickets");
        if (!carpeta.exists()) {
            mostrarAlerta("No hay tickets almacenados.");
            return;
        }

        ticketsVBox.getChildren().clear(); // Limpiar los tickets anteriores
        int numeroPedidos = 0;
        double totalDinero = 0;

        for (File ticket : carpeta.listFiles()) {
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

                if (fechaTicket != null && fechaTicket.equals(fechaSeleccionada)) {
                    // Crear la etiqueta para cada ticket
                    Label ticketLabel = new Label(contenido);
                    ticketLabel.setWrapText(true); // Permitir que el texto se ajuste en varias líneas
                    ticketLabel.setStyle("-fx-border-color: gray; -fx-background-color: #f9f9f9; -fx-padding: 10;");
                    ticketLabel.setMaxWidth(Double.MAX_VALUE);  // Asegura que la etiqueta ocupe todo el ancho disponible
                    ticketLabel.setMinHeight(Region.USE_PREF_SIZE); // Permite que la altura de la etiqueta se ajuste automáticamente

                    // Agregar la etiqueta al VBox
                    ticketsVBox.getChildren().add(ticketLabel);

                    numeroPedidos++;

                    // Obtener el total de cada ticket
                    for (String linea : lineas) {
                        if (linea.startsWith("TOTAL:")) {
                            String montoStr = linea.replace("TOTAL:", "").replace("€", "").trim();
                            montoStr = montoStr.replace(",", ".");
                            totalDinero += Double.parseDouble(montoStr);
                            break;
                        }
                    }
                }

            } catch (IOException e) {
                System.err.println("Error leyendo ticket: " + ticket.getName());
            }
        }

        if (numeroPedidos == 0) {
            resumenLabel.setText("No hay pedidos para la fecha seleccionada.");
        } else {
            resumenLabel.setText("Pedidos: " + numeroPedidos + " | Total: " + String.format("%.2f€", totalDinero));
        }
    }



    private void mostrarAlerta(String mensaje) {
        Alert alerta = new Alert(Alert.AlertType.INFORMATION);
        alerta.setTitle("Información");
        alerta.setHeaderText(null);
        alerta.setContentText(mensaje);
        alerta.showAndWait();
    }

    @FXML
    private void goHome(MouseEvent event) {
        Stage cambiarVista = (Stage) homeButton.getScene().getWindow();
        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/VistaMain.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista Principal");
            cambiarVista.setScene(scene);
            cambiarVista.show();
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName())
                  .log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void goBack(MouseEvent event) {
        Stage cambiarVista = (Stage) backButton.getScene().getWindow();
        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/VistaMain.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista Principal");
            cambiarVista.setScene(scene);
            cambiarVista.show();
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName())
                  .log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
}
