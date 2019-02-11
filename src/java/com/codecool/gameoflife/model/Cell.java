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
        this(x, y, true);
    }

    public Cell(int x, int y, boolean alive) {
        this.alive = alive;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        String status = this.alive ? "Alive" : "Dead";
        return String.format("%s TILE at x: %s, y: %s", status, this.x, this.y);
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }
}
