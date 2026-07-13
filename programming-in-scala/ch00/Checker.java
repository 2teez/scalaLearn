package com.example.ch00;

import static java.lang.System.out;
import java.io.Console;
public class Checker {

    public static void main(String[] args) {
        String name = User.input("Enter a name: ");
        if (name == null) {
            return;
        }
        out.println(name.chars().anyMatch(Character::isUpperCase));
    }

    static class User {
        private static final Console scanner = System.console();

        static String input(String prompt) {
            if (scanner == null) {
                out.println("No console available");
                return null;
            }
            return scanner.readLine(prompt);
        }
    }
}
