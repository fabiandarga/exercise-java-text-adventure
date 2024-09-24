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
    public void execute(GameState gs) throws Exception {
        gs.decreaseStepsRemaining();

        Area next;
        if (this.direction == Direction.LEFT) {
            next = gs.getToLeft();
        } else if (this.direction == Direction.RIGHT) {
            next = gs.getToRight();
        } else {
            throw new RuntimeException("This direction is not implemented in the MoveCommand");
        }

        gs.setLocation(next);
    }
}
