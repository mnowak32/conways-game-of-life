package com.codecool.gameoflife.view

import com.codecool.gameoflife.model.Cell
import javafx.scene.paint.Color
import javafx.scene.shape.Rectangle
import javafx.scene.shape.StrokeType

class CellView(cell: Cell) : Rectangle(DisplayConfig.CELL_SIDE, DisplayConfig.CELL_SIDE) {

    init {
        strokeType = StrokeType.INSIDE
        setOnMouseEntered { this.fill = Color.BLUE }
        update(cell, false)
    }

    fun update(cell: Cell, gridOn: Boolean) {
        val color = if (cell.isAlive) DisplayConfig.ALIVE_COLOR else DisplayConfig.DEAD_COLOR
        stroke = if (gridOn) Color.BLACK else Color.TRANSPARENT
        fill = color
        setOnMouseExited { fill = color }
    }
}
