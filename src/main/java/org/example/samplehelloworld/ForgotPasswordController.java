package org.example.samplehelloworld;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class ForgotPasswordController {

    private Label handleToLoginLabel;
    private TextField emailTextField;
    private Button nextPage;



    public void handleGoToLogin(MouseEvent mouseEvent) {

        try {
            // Carica la scena del login
            FXMLLoader loader = new FXMLLoader(getClass().getResource("LoginGUI.fxml"));
            Parent root = loader.load();

            // Ottieni la finestra corrente e imposta la nuova scena
            Stage stage = (Stage) ((javafx.scene.Node) mouseEvent.getSource()).getScene().getWindow();
            stage.setScene(new Scene(root));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void handleToNextPage() {
        ControllaCredeenziali check=new ControllaCredeenziali();
        String errorMessage= """
                Email non inserita o non appartenente all'ateaneo\s
                l'email associata al tuo account unifix segue la tipologia\s
                nome.cognome@uniroma2.eu""";
        if (!check.checkMail(emailTextField)) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Errore");
            alert.setHeaderText("Dati Mancanti/Errati");
            alert.setTitle("Errore");
            alert.setHeaderText("Errore critico durante l'elaborazione");
            alert.setContentText("Clicca su 'Dettagli' per maggiori informazioni.");

            // Aggiungere una TextArea per i dettagli
            TextArea textArea = new TextArea(errorMessage);
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

    }
}