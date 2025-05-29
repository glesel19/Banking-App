package com.example.bankingapp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/bankingapp/login.fxml"));
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("/com/example/bankingapp/style.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("Modern Banking App");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

