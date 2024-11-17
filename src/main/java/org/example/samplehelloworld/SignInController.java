package org.example.samplehelloworld;


import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
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


}