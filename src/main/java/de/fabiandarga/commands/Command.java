package de.fabiandarga.commands;

import de.fabiandarga.GameState;

public interface Command {
    void execute (GameState gs) throws Exception;
}
