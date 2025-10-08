package org.example.topicos_avanzadosrep2.Practica10Javafx;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Interfaz2 extends Application {
    @Override
    public void start(Stage stage){
        Label title = new Label("Formulario de Usuario");
        title.setStyle("-fx-font-size: 20px; -fx-text-fill: darkblue; -fx-font-weight: bold;");

        TextField nameField = new TextField();
        nameField.setPromptText("Ingresa tu nombre");
        nameField.setStyle("-fx-background-color: lightyellow; -fx-border-color: gray; -fx-border-radius: 5;");

        TextField ageField = new TextField();
        ageField.setPromptText("Ingresa tu edad");
        ageField.setStyle("-fx-background-color: lightyellow; -fx-border-color: gray; -fx-border-radius: 5;");

        Label result = new Label();
        result.setStyle("-fx-text-fill: green; -fx-font-size: 14px;");

        Button submit = new Button("Enviar");
        submit.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white; -fx-font-weight: bold;");

        submit.setOnAction(e -> {
            String nombre = nameField.getText();
            String edad = ageField.getText();
            result.setText("Hola " + nombre + ", tienes " + edad + " años.");
        });

        submit.setOnMouseEntered(e -> submit.setStyle("-fx-background-color: #45a049; -fx-text-fill: white;"));
        submit.setOnMouseExited(e -> submit.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;"));

        VBox layout = new VBox(15, title, nameField, ageField, submit, result);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: #f0f8ff;");

        Scene scene = new Scene(layout, 400, 300);
        stage.setScene(scene);
        stage.setTitle("Prueba con Estilos");
        stage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}