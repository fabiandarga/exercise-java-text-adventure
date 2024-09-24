package de.fabiandarga.types;

public class Location {
    private final Area area;
    private final int reward;

    public Location(Area area, int reward) {
        this.area = area;
        this.reward = reward;
    }

    public Area getArea() {
        return area;
    }

    public int getReward() {
        return reward;
    }

    @Override
    public String toString() {
        return this.area + " with " + this.reward + " sparkling scales";
    }
}
