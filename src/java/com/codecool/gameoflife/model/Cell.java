package com.codecool.gameoflife.model;

public class Cell {

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

    public Cell(int x, int y) {
        this.alive = true;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        String status = this.alive ? "Alive" : "Dead";
        return String.format("%s TILE at x: %s, y: %s", status, this.x, this.y);
    }
}
