package org.example.samplehelloworld;


import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
public class SignInController {


    @FXML
    public Label handleToForgotPassword;
    @FXML
    public Label loginLabel;

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
        controllaCredenziali check=new controllaCredenziali();
        String email =emailField.getText();
        String password = passwordField.getText();

        String errorMessage= """
                Email non inserita o non appartenente all'ateaneo\s
                l'email associata al tuo account unifix segue la tipologia\s
                nome.cognome@uniroma2.eu""";
        if (!check.checkMail(emailField)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setHeaderText("Dati Mancanti/Errati");
            alert.setTitle("Errore");
            alert.setHeaderText("Errore critico durante l'elaborazione");
            alert.setContentText("Clicca su 'Dettagli' per maggiori informazioni.");

            // Aggiungere una TextArea per i dettagli
            javafx.scene.control.TextArea textArea = new TextArea(errorMessage);
            textArea.setEditable(false);
            textArea.setWrapText(true);

            // Impostare la dimensione della TextArea
            textArea.setMaxWidth(Double.MAX_VALUE);
            textArea.setMaxHeight(Double.MAX_VALUE);

            // Impostare la TextArea nel pannello espandibile dell'Alert
            VBox vbox = new VBox();
            vbox.getChildren().add(textArea);

            alert.getDialogPane().setExpandableContent(vbox);
            alert.getDialogPane().setExpanded(true);

            // Mostrare l'Alert
            alert.showAndWait();
        }


        System.out.println("Email: " + email);
        System.out.println("Password: " + password);

    }

    public void handleGoToForgotPw(MouseEvent mouseEvent) {
        try {
        // Carica la scena di registrazione
        FXMLLoader loader = new FXMLLoader(getClass().getResource("forgotPassword.fxml"));
        Parent root = loader.load();

        // Ottieni la finestra corrente e imposta la nuova scena
        Stage stage = (Stage) ((javafx.scene.Node) mouseEvent.getSource()).getScene().getWindow();
        stage.setScene(new Scene(root));
    } catch (IOException e) {
        e.printStackTrace();
    }
    }
}