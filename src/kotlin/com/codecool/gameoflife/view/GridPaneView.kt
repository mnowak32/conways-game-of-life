package com.codecool.gameoflife.view

import com.codecool.gameoflife.controller.GameController
import javafx.event.EventHandler
import javafx.scene.layout.GridPane

class GridPaneView(private val controller: GameController) : GridPane() {

    private val cells: Array<Array<CellView>>
    var gridOn: Boolean = false

    init {
        val xSize = controller.gameBoard.width
        val ySize = controller.gameBoard.height
        gridOn = false
        cells = Array(xSize) { i -> Array(ySize) { j ->
            val c = CellView(controller.gameBoard.board[i][j]).apply {
                onMousePressed = EventHandler { controller.updateCell(i, j) }
                add(this, j, i)
            }
            c
        } }
    }

    fun updateCells(gameBoard: Array<Array<Boolean>>) {
        for (i in gameBoard.indices) {
            for (j in gameBoard[i].indices) {
                updateSingleCell(i, j)
            }
        }
    }

    fun updateSingleCell(x: Int, y: Int) {
        cells[x][y].update(controller.gameBoard.board[x][y], gridOn)
    }
}
