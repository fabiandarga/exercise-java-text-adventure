package de.fabiandarga.commands;

import de.fabiandarga.GameState;

public interface Command {
    public void execute (GameState gs);
}
