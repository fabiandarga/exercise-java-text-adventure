package de.fabiandarga.commands;

import de.fabiandarga.GameState;
import de.fabiandarga.types.Area;
import de.fabiandarga.types.Danger;
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
        Area areaLeft = availableValuesForLeft[randomLeft];

        int randomRewards1 = rand.nextInt(4);
        Danger dangerLeft = Danger.NONE;
        if (randomRewards1 == 3) {
            dangerLeft = Danger.BEAR_SHARK;
        } else if (randomRewards1 == 2) {
            switch (areaLeft) {
                case Area.LAKE, Area.RIVER -> dangerLeft = Danger.BEAR;
                case Area.OCEAN -> dangerLeft = Danger.SHARK;
            }
        }

        Location nextLeft = new Location(areaLeft, randomRewards1, dangerLeft);
        gs.setNextLeft(nextLeft);

        // Right side
        Area[] availableValuesForRight = Arrays
                .stream(availableValuesForLeft)
                .filter(x -> x != gs.getNextLeft().getArea())
                .toArray(Area[]::new);

        int randomRight = rand.nextInt(availableValuesForRight.length);
        int randomRewards2 = rand.nextInt(4);
        Area areaRight = availableValuesForRight[randomRight];
        Danger dangerRight = Danger.NONE;
        if (randomRewards2 == 3) {
            dangerRight = Danger.BEAR_SHARK;
        } else if (randomRewards2 == 2) {
            switch (areaRight) {
                case Area.LAKE, Area.RIVER -> dangerRight = Danger.BEAR;
                case Area.OCEAN -> dangerRight = Danger.SHARK;
            }
        }
        Location nextRight = new Location(areaRight, randomRewards2, dangerRight);
        gs.setNextRight(nextRight);
    }
    /*
    generateLocation(Areas[] excludeAreas) {
        return new Location() //...
    }
    */

}
