package de.fabiandarga.commands;

import de.fabiandarga.GameState;
import de.fabiandarga.types.Area;
import de.fabiandarga.types.Danger;
import de.fabiandarga.types.Direction;
import de.fabiandarga.types.Location;

import java.util.Random;

public class MoveCommand implements Command {

    private final Direction direction;

    public MoveCommand(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void execute(GameState gs) throws Exception {
        gs.decreaseStepsRemaining();

        Location nextLocation;
        if (this.direction == Direction.LEFT) {
            nextLocation = gs.getNextLeft();
        } else if (this.direction == Direction.RIGHT) {
            nextLocation = gs.getNextRight();
        } else {
            throw new RuntimeException("This direction is not implemented in the MoveCommand");
        }

        gs.setCurrentArea(nextLocation.getArea());

        // We will check for danger and only reward if nothing happens
        // switch-case depending on the kind of danger: Bear/Shark: 30%, BEAR_SHARK: 50%
        Random rnd = new Random();
        int result = rnd.nextInt(100);
        boolean giveReward = true;
        switch (nextLocation.getDanger()) {
            case Danger.BEAR, Danger.SHARK -> {
                if (result < 30) {
                    gs.setEatenBy(nextLocation.getDanger());
                    giveReward = false;
                }
            }
            case BEAR_SHARK -> {
                if (result < 50) {
                    gs.setEatenBy(nextLocation.getDanger());
                    giveReward = false;
                }
            }
            case JELLYFISH -> {
                if (result < 70) {
                    gs.removeScales(1);
                    System.out.println("A Jellyfish stole 1 of your Scales");
                    giveReward = false;
                }
            }
        }
        if (giveReward) {
            gs.addScales(nextLocation.getReward());
        }
    }
}
