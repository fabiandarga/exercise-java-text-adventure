package de.fabiandarga.commands;

import de.fabiandarga.GameState;
import de.fabiandarga.types.Area;
import de.fabiandarga.types.Location;

import java.util.Arrays;
import java.util.Random;

public class CreateRandomDirectionsCommand implements Command {
    @Override
    public void execute(GameState gs) {
        Random rand = new Random();
        Area[] values = Area.values();

        Area[] availableValuesForLeft = Arrays
                .stream(values)
                .filter(x -> x != Area.SPRING)
                .toArray(Area[]::new);

        int randomLeft = rand.nextInt(availableValuesForLeft.length);
        int randomRewards1 = rand.nextInt(4);
        Location nextLeft = new Location(availableValuesForLeft[randomLeft], randomRewards1);
        gs.setNextLeft(nextLeft);

        Area[] availableValuesForRight = Arrays
                .stream(availableValuesForLeft)
                .filter(x -> x != gs.getNextLeft().getArea())
                .toArray(Area[]::new);

        int randomRight = rand.nextInt(availableValuesForRight.length);
        int randomRewards2 = rand.nextInt(4);
        Location nextRight = new Location(availableValuesForRight[randomRight], randomRewards2);
        gs.setNextRight(nextRight);
    }
}
