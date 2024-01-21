package com.example.md5bruteforce;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BruteForceController {
    @FXML
    private TextField md5HashInput;

    @FXML
    private Label resultText;

    private File dictionaryFile;

    @FXML
    private Label fileName;

    @FXML
    protected void onChooseFile() {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select a dictionary file:");
        dictionaryFile = fileChooser.showOpenDialog(md5HashInput.getScene().getWindow());
        fileName.setText(dictionaryFile.getName());
    }

    @FXML
    private void onStartBruteForce() {
        if (dictionaryFile == null || md5HashInput.getText().isEmpty()) {
            resultText.setText("Please select a file and enter an MD5 hash.");
        }

        try {
            String result = bruteForceMD5(md5HashInput.getText(), dictionaryFile);
            if (result != null) {
                resultText.setText("Found match: " + result);
            } else {
                resultText.setText("No matching string found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
            resultText.setText("An exception was thrown.");
        }
    }

    private String bruteForceMD5(String hash, File file) throws NoSuchAlgorithmException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (generateMD5Hash(line).equals(hash)) {
                    return line;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "An exception was thrown";
        }
        return null;
    }

    private String generateMD5Hash(String input) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(input.getBytes());
        byte[] digest = md.digest();
        StringBuilder stringBuilder = new StringBuilder();
        for (byte b : digest) {
            stringBuilder.append(String.format("%02x", b));
        }
        return stringBuilder.toString();
    }


}