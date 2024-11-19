package org.example.samplehelloworld;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
public class SignInController {



    public void handleGoToRegistrazione(javafx.scene.input.MouseEvent event) {
        try {
            // Carica la scena di registrazione
            FXMLLoader loader = new FXMLLoader(getClass().getResource("signUpGui.fxml"));
            Parent root = loader.load();

            // Ottieni la finestra corrente e imposta la nuova scena
            Stage stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    public void handleLogIn() {

        String email =emailField.getText();
        String password = passwordField.getText();

        if(email.isEmpty() || password.isEmpty()){
            // Mostra un messaggio di errore
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore di Login");
            alert.setHeaderText("Dati Mancanti");
            alert.setContentText("Inserire sia l'email che la password.");
            alert.showAndWait();
            return;
        }

        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

    }
}