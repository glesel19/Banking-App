/**
 * @author Enes Haxhaja
 * Serviceklasse für die Authentifizierung von Benutzern.
 * Führt eine einfache Prüfung von Benutzername und Passwort durch.
 */

package com.example.bankingapp.services;

import com.example.bankingapp.models.User;

public class AuthService {
    private static User loggedInUser;


/**
* @param: username und password
* @return true or false
*
*/
    public static boolean login(String username, String password) {
        // Mock check
        if (username.equals("admin") && password.equals("1234")) {
            loggedInUser = new User(username, password);
            return true;
        }
        return false;
    }

    public static User getLoggedInUser() {
        return loggedInUser;
    }
}


