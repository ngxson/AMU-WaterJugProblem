package com.ngxson.programmation;

public class Bottle {
    private int capacity;
    private int waterLevel;
    private String name;

    public Bottle(int capacity, int waterLevel, String name) {
        this.capacity = capacity;
        this.waterLevel = waterLevel;
        this.name = name;
    }

    public void pourAllTo(Bottle bottle) {
        int rest = bottle.pourIn(this.waterLevel);
        this.makeEmpty();
        this.pourIn(rest);
    }

    /**
     *
     * @param amount
     * @return if the bottle is already full,
     * return the rest amount which cannot be poured into this bottle
     */
    public int pourIn(int amount) {
        waterLevel += amount;
        if (waterLevel < 0) waterLevel = 0;
        if (waterLevel >= capacity) {
            // the bottle is full
            int rest = waterLevel - capacity;
            waterLevel = capacity;
            return rest;
        } else {
            // the bottle is not full
            return 0;
        }
    }

    public boolean equals(Bottle bottle) {
        return (bottle.getCapacity() == this.getCapacity()
            && bottle.getWaterLevel() == this.getWaterLevel()
            && bottle.getName() == this.getName());
    }

    /**
     * make the bottle empty
     * @return amount of water to make it empty (negative number)
     */
    public int makeEmpty() {
        int amount = -waterLevel;
        waterLevel = 0;
        return amount;
    }

    /**
     * make the bottle full
     * @return amount of water to make it full
     */
    public int makeFull() {
        int amount = capacity - waterLevel;
        waterLevel = capacity;
        return amount;
    }

    public boolean isEmpty() {
        return waterLevel == 0;
    }

    public boolean isFull() {
        return waterLevel == capacity;
    }

    public int getCapacity() {
        return capacity;
    }

    public int getWaterLevel() {
        return waterLevel;
    }

    public String getName() {
        return name;
    }
}
