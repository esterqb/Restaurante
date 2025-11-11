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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ester
 */
public class CalculadoraController implements Initializable {

    @FXML
    private ImageView homeButton;
    @FXML
    private ImageView backButton;
    @FXML
    private Pane pantalla;
    @FXML
    private Label label;

    private double num1=0;
    private String operador="";
    private boolean calc=true;
    
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
            cambiarVista.setTitle("Vista 2");


            // Seteo la scene y la muestro
            cambiarVista.setScene(scene);

            cambiarVista.show();


            
        } catch (IOException ex) {
            System.getLogger(VistaMainController.class.getName()).log(System.Logger.Level.ERROR, (String) null, ex);
        }
    }

    @FXML
    private void click(MouseEvent event) {
        Button boton=(Button) event.getSource();
        String texto=boton.getText();
        
        switch (texto){
            case "C":
                limpiar();
                break;
            case "+":
            case "-":
            case "/":
            case "x":
                operar(texto);
                break;
            case "=":
                calcular();
                break;
            default:
                numeros(texto);
                break;
        }
    }
    private void numeros(String texto){
        if(calc){
            label.setText("");
            calc=false;
        }
        if (label.getText().equals("0")){
            label.setText(texto);
        }else{
            label.setText(label.getText()+texto);
        }
    }
    private void operar(String texto){
        operador=texto;
        num1=Double.parseDouble(label.getText());
        label.setText("");
    }
    private void limpiar(){
        label.setText("0");
        operador="0";
        num1=0;
        calc=true;
    }
    
    private void calcular(){
        double num2=Double.parseDouble(label.getText());
        double resultado=0;
        switch (operador){            
            case"+":
                resultado=num1+num2;
                break;
            case"-":
                resultado=num1-num2;
                break;
            case"x":
                resultado=num1*num2;
                break;
            case"/":
                if(num2==0){
                    label.setText("Err");
                    operador="";
                    calc=true;
                    return;
                }
                resultado=num1/num2;
                break;
        }
        label.setText(String.valueOf(resultado));
        operador="";
        calc=true;
    }
    
}
