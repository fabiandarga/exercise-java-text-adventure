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
        // generate left Location
        Area[] availableAreasForLeft = this.getFilteredAreas(Area.values(), Area.SPRING);
        Location nextLeft = this.generateRandomLocation(availableAreasForLeft);
        gs.setNextLeft(nextLeft);
        // generate right Location
        Area[] availableAreasForRight = this.getFilteredAreas(
                availableAreasForLeft,
                gs.getNextLeft().getArea()
        );
        Location nextRight = this.generateRandomLocation(availableAreasForRight);
        gs.setNextRight(nextRight);
    }

    private Area[] getFilteredAreas(Area[] values, Area toExclude) {
        return Arrays
                .stream(values)
                .filter(x -> x != toExclude)
                .toArray(Area[]::new);
    }

    private Location generateRandomLocation(Area[] availableAreas) {
        Random rand = new Random();
        int areaIndex = rand.nextInt(availableAreas.length);
        Area area = availableAreas[areaIndex];

        int rewards = rand.nextInt(4);

        Danger danger = Danger.NONE;
        if (rewards == 3) {
            danger = Danger.BEAR_SHARK;
        } else if (rewards == 2) {
            switch (area) {
                case LAKE, RIVER -> danger = Danger.BEAR;
                case OCEAN -> danger = Danger.SHARK;
                case AQUIFER, SEA, CANAL -> danger = Danger.JELLYFISH;
            }
        } else if (rewards == 1) {
            switch (area) {
                case LAKE, RIVER, OCEAN, AQUIFER, SEA, CANAL -> danger = Danger.JELLYFISH;
            }
        }

        return new Location(area, rewards, danger);
    }
}
