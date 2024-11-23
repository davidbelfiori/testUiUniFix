package org.example.samplehelloworld;

import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import org.example.samplehelloworld.PopUp;

import java.util.regex.Pattern;

public class ControllaCredeenziali{

    public boolean checkMail(TextField emailTextField) {
        String email = emailTextField.getText();
        if (email == null || email.isEmpty()) {
            return false;
        }
        String emailRegex = "^[a-zA-Z]+\\.[a-zA-Z]+@uniroma2\\.eu$";

        // Creare il pattern e confrontare
        return Pattern.matches(emailRegex, email);
    }

    public boolean doubleCheckPw(PasswordField newPasswordField, PasswordField newPasswordFieldConfirm) {
        String newPw = newPasswordField.getText().trim();
        String newPwConf = newPasswordFieldConfirm.getText().trim();
        PopUp popUp = new PopUp();

        if (!newPw.equals(newPwConf)) {
            popUp.showErrorPopup("Credenziali Errate", "Le password non corrispondono", null);
            return false;
        }

        if (!isPasswordStrong(newPw)) {
            popUp.showErrorPopup("Credenziali Errate", "La password non rispetta i requisiti:", """
                    - Minimo 8 caratteri
                    - Almeno una lettera maiuscola
                    - Almeno una lettera minuscola
                    - Almeno un numero
                    - Almeno un carattere speciale
                    """);
            return false;
        }

        popUp.showSuccessPopup("Successo", "Le password sono valide e corrispondono!");
        return true;
    }

    private boolean isPasswordStrong(String password) {
        // Controlla se la password rispetta i requisiti di complessità
        return password.length() >= 8 &&
                password.matches(".*[A-Z].*") &&    // Almeno una maiuscola
                password.matches(".*[a-z].*") &&    // Almeno una minuscola
                password.matches(".*\\d.*") &&      // Almeno un numero
                password.matches(".*[!@#$%^&*(),.?\":{}|<>].*"); // Almeno un carattere speciale
    }
}
