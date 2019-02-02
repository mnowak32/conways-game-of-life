package com.codecool.gameoflife.model;

public class Tile {

    private int x;
    private int y;
    private boolean alive;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isAlive() {
        return alive;
    }

    public Tile(int x, int y) {
        this.alive = true;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return String.format("Tile at x: %s, y: %s", this.x, this.y);
    }
}
