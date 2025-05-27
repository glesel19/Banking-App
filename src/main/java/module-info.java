module com.example.bankingapp {
    requires javafx.controls;
    requires javafx.fxml;

    // Das brauchst du für Zugriff auf die FXML-Controller
    opens com.example.bankingapp to javafx.fxml;
    opens com.example.bankingapp.controllers to javafx.fxml;

    // Wenn du Klassen exportieren willst (für andere Module)
    exports com.example.bankingapp;
    exports com.example.bankingapp.controllers;
}
