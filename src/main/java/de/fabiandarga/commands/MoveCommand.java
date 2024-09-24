package de.fabiandarga.commands;

import de.fabiandarga.GameState;
import de.fabiandarga.types.Area;
import de.fabiandarga.types.Direction;

public class MoveCommand implements Command {

    private final Direction direction;

    public MoveCommand(Direction direction) {
        this.direction = direction;
    }

    @Override
    public void execute(GameState gs) {
        // direction (options)
        if (this.direction == Direction.LEFT) {
            Area next = gs.getToLeft();
            gs.setLocation(next);
        } else if (this.direction == Direction.RIGHT) {
            Area next = gs.getToRight();
            gs.setLocation(next);
        } else {
            throw new RuntimeException("This direction is not implemented in the MoveCommand");
        }
    }
}
