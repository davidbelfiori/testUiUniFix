package org.example.samplehelloworld;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ForgotPasswordController {

    private static String email;
    @FXML
    private TextField emailTextField;
    @FXML
    private TextField codeTextField;
    @FXML
    private PasswordField newPasswordField;
    @FXML
    private PasswordField newPasswordFieldConfirm;

     // Variabile per memorizzare l'email dell'utente

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


    public void handleToNextPage(MouseEvent mouseEvent) {
        ControllaCredeenziali check = new ControllaCredeenziali();
        if (!check.checkMail(emailTextField)) {
            PopUp popUp = new PopUp();
            popUp.showErrorPopup("Errore", "Email non valida", "Inserisci un'email corretta.");
        } else {
            // Genera e "invia" il codice
            String generatedCode = CodeManager.getInstance().generateCode();
            System.out.println("Codice generato per l'email " + email + ": " + generatedCode);
            // Passa alla pagina successiva
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ForgotPwCode.fxml"));
                Parent root = loader.load();
                email=emailTextField.getText();
                Stage stage = (Stage) ((javafx.scene.Node) mouseEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

  // TODO: andrebbe implelemtato che il codice viene mandato via mail
    public void handleVerifyCode(MouseEvent mouseEvent) {
        String inputCode = codeTextField.getText();
        if (CodeManager.getInstance().verifyCode(inputCode)) {
            PopUp popUp = new PopUp();
            popUp.showSuccessPopup("Successo", "Codice verificato con successo!");

            // Passa alla pagina di modifica password
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("ForgotPwChange.fxml"));
                Parent root = loader.load();

                Stage stage = (Stage) ((javafx.scene.Node) mouseEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            PopUp popUp = new PopUp();
            popUp.showErrorPopup("Errore", "Codice non valido", "Inserisci il codice corretto.");
        }
    }

    public void handleToChangePassword(MouseEvent mouseEvent) {
        ControllaCredeenziali check = new ControllaCredeenziali();
        if (check.doubleCheckPw(newPasswordField, newPasswordFieldConfirm)) {
            System.out.println("Email: " + email);
            System.out.println("Nuova password: " + newPasswordField.getText());
        }
    }


}
