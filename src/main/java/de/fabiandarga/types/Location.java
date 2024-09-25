package de.fabiandarga.types;

public class Location {
    private final Area area;
    private final int reward;
    private final Danger danger;

    public Location(Area area, int reward, Danger danger) {
        this.area = area;
        this.reward = reward;
        this.danger = danger;
    }

    public Area getArea() {
        return area;
    }

    public int getReward() {
        return reward;
    }

    public Danger getDanger() {
        return danger;
    }

    @Override
    public String toString() {
        // Add the Danger to the output if there is some
        return this.area + " with " + this.reward + " sparkling scales (" + this.danger+ ")";
    }
}
