/**
 * Serviceklasse, die Zugriff auf das Bankkonto bietet.
 */
package com.example.bankingapp.services;


import com.example.bankingapp.models.BankAccount;


public class BankService {
    private static BankAccount account = new BankAccount();

    public static BankAccount getAccount() {
        return account;
    }
}



