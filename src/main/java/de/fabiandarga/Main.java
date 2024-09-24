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
        GameState gs = new GameState();

        System.out.println("Where do you want to go?");
        System.out.println("[left] to green room | [right] to blue room");

        // Then we start a loop
        while (gameRunning) {
            System.out.print("> ");
            // Read from  input
            String input = scanner.nextLine();

            // execute some command
            switch (input) {
                case "left":
                    gs.setLocation(Area.AQUIFER);
                    System.out.println("You swam into the " + Area.AQUIFER);
                    break;
                case "right":
                    gs.setLocation(Area.OCEAN);
                    System.out.println("You swam into the " + Area.OCEAN);
                    break;
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