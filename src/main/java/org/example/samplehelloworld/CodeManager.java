package org.example.samplehelloworld;

import java.security.SecureRandom;

public class CodeManager {
    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 6;
    private static CodeManager instance;
    private String generatedCode;

    // Costruttore privato per impedire l'uso diretto
    private CodeManager() {}

    // Metodo per ottenere l'istanza unica
    public static CodeManager getInstance() {
        if (instance == null) {
            instance = new CodeManager();
        }
        return instance;
    }

    // Metodo per generare un codice randomico
    public String generateCode() {
        SecureRandom random = new SecureRandom();
        StringBuilder code = new StringBuilder(CODE_LENGTH);
        for (int i = 0; i < CODE_LENGTH; i++) {
            code.append(CHARACTERS.charAt(random.nextInt(CHARACTERS.length())));
        }
        generatedCode = code.toString();
        return generatedCode;
    }

    // Metodo per verificare il codice
    public boolean verifyCode(String inputCode) {
        return inputCode != null && inputCode.equals(generatedCode);
    }
}
