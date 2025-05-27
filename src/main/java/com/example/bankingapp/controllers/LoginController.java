package com.example.bankingapp.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import com.example.bankingapp.services.AuthService;

public class LoginController {

    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;

    @FXML
    private void handleLogin() {
        String user = usernameField.getText();
        String pass = passwordField.getText();

        if (AuthService.login(user, pass)) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/bankingapp/dashboard.fxml"));
                Scene dashboardScene = new Scene(loader.load());
                Stage stage = (Stage) usernameField.getScene().getWindow();
                stage.setScene(dashboardScene);
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Login failed. Try 'admin' / '1234'");
            alert.show();
        }
    }
}
