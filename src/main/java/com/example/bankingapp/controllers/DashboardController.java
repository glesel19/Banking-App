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

    private void updateBalance() {
        balanceLabel.setText("$" + String.format("%.2f", BankService.getAccount().getBalance()));
    }

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
