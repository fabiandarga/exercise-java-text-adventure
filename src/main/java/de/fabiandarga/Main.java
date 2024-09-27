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
        GameState gs = new GameState(); // try load from db
        new CreateRandomDirectionsCommand().execute(gs);

        // Then we start a loop
        while (gameRunning) {
            System.out.println("Where do you want to swim? (You have " + gs.getStepsRemaining() + " step left)");
            System.out.println("[left] for " + gs.getNextLeft() + " | [right] for " + gs.getNextRight() );
            System.out.print("> ");
            // Read from  input
            String input = scanner.nextLine();

            // execute some command
            try {
                switch (input) {
                    case "left":
                        Command moveLeft = new MoveCommand(Direction.LEFT);
                        moveLeft.execute(gs);
                        new CreateRandomDirectionsCommand().execute(gs);
                        System.out.println("You swam into the " + gs.getCurrentArea());
                        System.out.println("You have "+ gs.getScalesCollected() +" Scales now.");
                        break;
                    case "right":
                        Command moveRight = new MoveCommand(Direction.RIGHT);
                        moveRight.execute(gs);
                        new CreateRandomDirectionsCommand().execute(gs);
                        System.out.println("You swam into the " + gs.getCurrentArea());
                        System.out.println("You have "+ gs.getScalesCollected() +" Scales now.");
                        break;
                    case "quit":
                        // quit the loop when "quit" was entered or then the game is over
                        gameRunning = false;
                        break;
                    case null, default:
                        System.out.println("Wrong input!");
                }
                if (gs.getEatenBy() != null) {
                    gameRunning = false;
                    System.out.println("You got eaten by a " + gs.getEatenBy() + "!");
                } else if (gs.getScalesCollected() >= 10) {
                    gameRunning = false;
                    System.out.println("You have Found Nemo. You swim off together happily!");
                } else if (gs.stepsRemaining < 1) {
                    gameRunning = false;
                    System.out.println("You have exhausted yourself. Try to find Nemo tomorrow. Game Over!");
                }
                // if gameRunning == false -> remove from db
                // saving game here
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Goodbye, see you next time!");
    }
}