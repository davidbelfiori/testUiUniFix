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

public class ForgotPasswordController {


    private static String email;
    public TextField emailTextField;
    private Button nextPage;
    @FXML
    public PasswordField newPasswordField;
    @FXML
    public PasswordField newPasswordFieldConfirm;


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
        ControllaCredeenziali check=new ControllaCredeenziali();
        PopUp popUp= new PopUp();

        if (!check.checkMail(emailTextField)) {
            popUp.showErrorPopup("Errore","Dati Mancanti/Errati", """
                Email non inserita o non appartenente all'ateaneo\s
                l'email associata al tuo account unifix segue la tipologia\s
                nome.cognome@uniroma2.eu""");
        }else {
            try {
                // Carica la scena del login
                FXMLLoader loader = new FXMLLoader(getClass().getResource("forgotPw2.fxml"));
                Parent root = loader.load();
                email=emailTextField.getText();
                // Ottieni la finestra corrente e imposta la nuova scena
                Stage stage = (Stage) ((javafx.scene.Node) mouseEvent.getSource()).getScene().getWindow();
                stage.setScene(new Scene(root));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public void handleToChangePassword(MouseEvent mouseEvent){
        ControllaCredeenziali check=new ControllaCredeenziali();
        if (check.doubleCheckPw(newPasswordField, newPasswordFieldConfirm)){
            System.out.println("Email:"+email+"\n"+"Nuova password: "+newPasswordField.getText());
        }
    }

}