package de.fabiandarga;

import de.fabiandarga.commands.Command;
import de.fabiandarga.commands.CreateRandomDirectionsCommand;
import de.fabiandarga.commands.MoveCommand;
import de.fabiandarga.types.Direction;

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
        new CreateRandomDirectionsCommand().execute(gs);

        // Then we start a loop
        while (gameRunning) {
            System.out.println("Where do you want to go?");
            System.out.println("[left] for " + gs.getToLeft() + " | [right] for " + gs.getToRight() );
            System.out.print("> ");
            // Read from  input
            String input = scanner.nextLine();

            // execute some command
            switch (input) {
                case "left":
                    Command moveLeft = new MoveCommand(Direction.LEFT);
                    moveLeft.execute(gs);
                    new CreateRandomDirectionsCommand().execute(gs);
                    System.out.println("You swam into the " + gs.getLocation());
                    break;
                case "right":
                    Command moveRight = new MoveCommand(Direction.RIGHT);
                    moveRight.execute(gs);
                    new CreateRandomDirectionsCommand().execute(gs);
                    System.out.println("You swam into the " + gs.getLocation());
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