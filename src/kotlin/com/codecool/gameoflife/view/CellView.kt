package com.codecool.gameoflife.view

import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.scene.shape.StrokeType

class CellView(cell: Boolean) : Rectangle(DisplayConfig.CELL_SIDE, DisplayConfig.CELL_SIDE) {

    init {
        strokeType = StrokeType.INSIDE
        setOnMouseEntered { this.fill = Color.BLUE }
        update(cell, false)
    }

    fun update(cell: Boolean, gridOn: Boolean) {
        val color = if (cell) DisplayConfig.ALIVE_COLOR else DisplayConfig.DEAD_COLOR
        stroke = if (gridOn) Color.BLACK else Color.TRANSPARENT
        fill = color
        setOnMouseExited { fill = color }
    }
}
