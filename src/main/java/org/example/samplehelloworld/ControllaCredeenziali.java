package org.example.samplehelloworld;

import javafx.scene.control.TextField;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ControllaCredeenziali {

    public boolean checkMail(TextField emailTextField) {
        String email = emailTextField.getText();
        if (email == null || email.isEmpty()){
            return false;
        }
        String emailRegex = "^[a-zA-Z]+\\.[a-zA-Z]+@uniroma2\\.eu$";

        // Creare il pattern e confrontare
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(email);

        return matcher.matches();

    }
}
