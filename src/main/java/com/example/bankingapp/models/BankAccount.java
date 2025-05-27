/**
 * Modellklasse zur Verwaltung von Bankkontodaten.
 * Speichert Kontostand und Liste der Transaktionen.
 */
package com.example.bankingapp.models;


import java.util.ArrayList;
import java.util.List;


public class BankAccount {
    private double balance = 1000.00;
    private List<String> transactions = new ArrayList<>();


    /** Aktueller Kontostand */
    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: $" + amount);
    }

    public boolean withdraw(double amount) {
        if (amount > balance) return false;
        balance -= amount;
        transactions.add("Withdrew: $" + amount);
        return true;
    }

    /** Liste der ausgeführten Transaktionen */
    public List<String> getTransactions() {
        return transactions;
    }
}
