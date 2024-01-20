package com.example.md5bruteforce;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class BruteForceApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(BruteForceApplication.class.getResource("/com/example/md5bruteforce/brute-force-view.fxml"));
        Scene scene = new Scene(loader.load(), 320, 290);

        stage.setTitle("MD5 Brute Force Application");
        stage.setScene(scene);
        stage.setAlwaysOnTop(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}