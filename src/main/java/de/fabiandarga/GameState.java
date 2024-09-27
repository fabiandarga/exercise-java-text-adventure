package de.fabiandarga;

import de.fabiandarga.types.Area;
import de.fabiandarga.types.Danger;
import de.fabiandarga.types.Location;

public class GameState {
    Area currentArea = Area.SPRING;
    Location nextLeft;
    Location nextRight;
    int stepsRemaining = 10;
    int scalesCollected = 0;
    Danger eatenBy;

    public Danger getEatenBy() {
        return eatenBy;
    }

    public void setEatenBy(Danger eatenBy) {
        this.eatenBy = eatenBy;
    }

    public void addScales(int amount) {
        this.scalesCollected += amount;
    }

    public void removeScales(int amount) {
        this.scalesCollected -= amount;
    }

    public int getScalesCollected() {
        return scalesCollected;
    }

    public void decreaseStepsRemaining() throws Exception {
        if (this.stepsRemaining == 0) {
            throw new Exception("Can not reducce stepsRemaining below 0");
        }
        this.stepsRemaining -= 1;
    }

    public int getStepsRemaining() {
        return stepsRemaining;
    }

    public Location getNextLeft() {
        return nextLeft;
    }

    public void setNextLeft(Location nextLeft) {
        this.nextLeft = nextLeft;
    }

    public Location getNextRight() {
        return nextRight;
    }

    public void setNextRight(Location nextRight) {
        this.nextRight = nextRight;
    }

    public Area getCurrentArea() {
        return currentArea;
    }

    public void setCurrentArea(Area currentArea) {
        this.currentArea = currentArea;
    }
}
