package de.fabiandarga;

import de.fabiandarga.types.Area;

public class GameState {
    Area location = Area.SPRING;
    Area toLeft;
    Area toRight;

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
