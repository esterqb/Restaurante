/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
    
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
/**
 *
 * @author ester
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

            Parent root = FXMLLoader.load(getClass().getResource("/view/VistaMain.fxml"));

            // Cargo el scene
            
            Scene scene = new Scene(root);
            
            // Seteo la scene y la muestro
            primaryStage.setScene(scene);
            primaryStage.show();
            
            
    }

    public static void main(String[] args) {
        launch(args);
        
    }

}
