package de.fabiandarga.commands;

import de.fabiandarga.GameState;
import de.fabiandarga.types.Area;

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
        gs.setToLeft(availableValuesForLeft[randomLeft]);

        Area[] availableValuesForRight = Arrays
                .stream(availableValuesForLeft)
                .filter(x -> x != gs.getToLeft())
                .toArray(Area[]::new);

        int randomRight = rand.nextInt(availableValuesForRight.length);
        gs.setToRight(availableValuesForRight[randomRight]);
    }
}
