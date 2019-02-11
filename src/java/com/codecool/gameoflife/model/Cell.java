package com.codecool.gameoflife.model;

public class Cell {

    private boolean alive;

    public boolean isAlive() {
        return alive;
    }

    public Cell() {
        this(false);
    }

    public Cell(boolean alive) {
        this.alive = alive;
    }

    @Override
    public String toString() {
        String status = this.alive ? "Alive" : "Dead";
        return String.format("%s TILE", status);
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

    public void toggleAlive() {
        this.alive = !this.alive;
    }
}
