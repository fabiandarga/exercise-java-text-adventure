package de.fabiandarga;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Let's start with a very simple version of a turn based text adventure
        System.out.println("Welcome to the Text Adventure!");
        System.out.println("-----------------------------");

        System.out.println("Enter \"quit\" to quit");


        // We need an input scanner
        Scanner scanner = new Scanner(System.in);

        boolean gameRunning = true;

        // Then we start a loop
        while (gameRunning) {
            System.out.print("> ");
            // Read from  input
            String input = scanner.nextLine();

            // execute some command
            switch (input) {
                case "quit":
                    // quit the loop when "quit" was entered or then the game is over
                    gameRunning = false;
                    break;
                case null, default:
                    System.out.println("Wrong input!");
            }
        }

        System.out.println("Goodbye, see you next time!");
    }
}