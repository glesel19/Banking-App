/**
 * Controller für die Dashboard-Ansicht der Banking-App.
 * Ermöglicht Transaktionen wie Einzahlung, Auszahlung und zeigt den Kontostand an.
 */
package com.example.bankingapp.controllers;


import javafx.fxml.FXML;
import javafx.scene.control.*;
import com.example.bankingapp.services.BankService;

public class DashboardController {

    @FXML private Label balanceLabel;
    @FXML private TextArea transactionArea;
    @FXML private TextField amountField;

    @FXML
    private void initialize() {
        updateBalance();
    }

    /** Aktualisiert die Anzeige des Kontostandes */
    private void updateBalance() {
        balanceLabel.setText("$" + String.format("%.2f", BankService.getAccount().getBalance()));
    }

    /** Führt eine Einzahlung aus und aktualisiert den Kontostand */
    @FXML
    private void viewBalance() {
        updateBalance();
    }

    @FXML
    private void depositMoney() {
        double amount = Double.parseDouble(amountField.getText());
        BankService.getAccount().deposit(amount);
        updateBalance();
        transactionArea.appendText("Deposited $" + amount + "\n");
    }


    /** Führt eine Auszahlung aus und aktualisiert den Kontostand oder gibt Fehlermeldung bei unzureichendem Guthaben */
    @FXML
    private void withdrawMoney() {
        double amount = Double.parseDouble(amountField.getText());
        if (BankService.getAccount().withdraw(amount)) {
            updateBalance();
            transactionArea.appendText("Withdrew $" + amount + "\n");
        } else {
            transactionArea.appendText("Insufficient funds\n");
        }
    }

    @FXML
    private void viewTransactions() {
        transactionArea.clear();
        for (String t : BankService.getAccount().getTransactions()) {
            transactionArea.appendText(t + "\n");
        }
    }

    @FXML
    private void logout() {
        System.exit(0); // Close app (or return to login screen)
    }
}
