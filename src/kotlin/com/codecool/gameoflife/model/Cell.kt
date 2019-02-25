package com.codecool.gameoflife.model

class Cell(var isAlive: Boolean = false) {

    override fun toString() = "${if (isAlive) "Alive" else "Dead"} TILE"

    fun toggleAlive() {
        isAlive = !isAlive
    }
}
