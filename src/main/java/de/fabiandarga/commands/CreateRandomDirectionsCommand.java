package de.fabiandarga.commands;

import de.fabiandarga.GameState;
import de.fabiandarga.types.Area;

import java.util.List;
import java.util.Random;

public class CreateRandomDirectionsCommand implements Command {
    @Override
    public void execute(GameState gs) {
        Random rand = new Random();
        Area[] values = Area.values();

        int randomLeft = rand.nextInt(values.length);
        gs.setToLeft(values[randomLeft]);

        int randomRight = rand.nextInt(values.length);
        gs.setToRight(values[randomRight]);
    }
}
