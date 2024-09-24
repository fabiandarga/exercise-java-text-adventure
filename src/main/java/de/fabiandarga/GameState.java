package de.fabiandarga;

import de.fabiandarga.types.Area;

public class GameState {
    Area location = Area.SPRING;
    Area toLeft;
    Area toRight;
    int stepsRemaining = 10;


    public void decreaseStepsRemaining() throws Exception {
        if (this.stepsRemaining == 0) {
            throw new Exception("Can not reducce stepsRemaining below 0");
        }
        this.stepsRemaining -= 1;
    }

    public int getStepsRemaining() {
        return stepsRemaining;
    }

    public void setStepsRemaining(int stepsRemaining) {
        this.stepsRemaining = stepsRemaining;
    }

    public Area getToLeft() {
        return toLeft;
    }

    public void setToLeft(Area toLeft) {
        this.toLeft = toLeft;
    }

    public Area getToRight() {
        return toRight;
    }

    public void setToRight(Area toRight) {
        this.toRight = toRight;
    }

    public Area getLocation() {
        return location;
    }

    public void setLocation(Area location) {
        this.location = location;
    }

    // items
    // point
    // steps
}
