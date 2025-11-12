/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ester
 */
public class VistaMainController implements Initializable {

    @FXML
    private ImageView homeButton;
    @FXML
    private ImageView backButton;
    @FXML
    private Pane hacerPedido;
    @FXML
    private ImageView pedidoPic;
    @FXML
    private Pane almacen;
    @FXML
    private ImageView almacenPic;
    @FXML
    private Pane stockBebida;
    @FXML
    private ImageView stockBebidaPic;
    @FXML
    private Pane calculadora;
    @FXML
    private ImageView calculadoraPic;
    @FXML
    private Pane balance;
    @FXML
    private ImageView balancePic;
    @FXML
    private Pane verPedidos;
    @FXML
    private ImageView verPedidosPic;

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
    private void hacerPedidoPic(MouseEvent event) {
        Stage cambiarVista = (Stage) pedidoPic.getScene().getWindow();


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
    private void hacerPedido(MouseEvent event) {
        Stage cambiarVista = (Stage) hacerPedido.getScene().getWindow();


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
    private void goToAlmacenPic(MouseEvent event) {
        Stage cambiarVista = (Stage) almacenPic.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/Almacen.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 9");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void goToAlmacen(MouseEvent event) {
        Stage cambiarVista = (Stage) almacen.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/Almacen.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 9");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void goToStockBebidaPic(MouseEvent event) {
        Stage cambiarVista = (Stage) stockBebidaPic.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/StockBebida.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 10");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void goToStockBebida(MouseEvent event) {
                        Stage cambiarVista = (Stage) stockBebida.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/StockBebida.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 10");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void goToCalculadoraPic(MouseEvent event) {
        Stage cambiarVista = (Stage) calculadoraPic.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/Calculadora.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 12");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void goToCalculadora(MouseEvent event) {
        Stage cambiarVista = (Stage) calculadora.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/Calculadora.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 12");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void goToBalancePic(MouseEvent event) {
        Stage cambiarVista = (Stage) balancePic.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/BalanceDia.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 13");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void goToBalance(MouseEvent event) {
        Stage cambiarVista = (Stage) balance.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/BalanceDia.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 13");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void goToVerPedidosPic(MouseEvent event) {
        Stage cambiarVista = (Stage) verPedidosPic.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/VerPedidos.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 14");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void goToVerPedidos(MouseEvent event) {
        Stage cambiarVista = (Stage) verPedidos.getScene().getWindow();


        try {
            Parent nroot = FXMLLoader.load(getClass().getResource("/view/VerPedidos.fxml"));
            Scene scene = new Scene(nroot);
            cambiarVista.setTitle("Vista 14");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }
    
}
