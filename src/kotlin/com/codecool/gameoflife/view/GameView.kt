package com.codecool.gameoflife.view

import com.codecool.gameoflife.controller.GameController
import com.codecool.gameoflife.model.Cell
import javafx.beans.value.ChangeListener
import javafx.event.EventHandler
import javafx.scene.layout.HBox

class GameView(private val gameController: GameController) : HBox() {

    private val gameBoardView: GridPaneView = GridPaneView(gameController)
    private val gameAnimation: GameLoop = GameLoop(200, Runnable { gameController.nextGeneration() })
    private val setupView: SetupView

    init {
        setupView = SetupView().apply {
            setupStartButton(EventHandler { startGame() }, "Start Game")
            setupRandomizeButton(EventHandler { gameController.randomizeGrid() })
            setupClearButton(EventHandler { gameController.clearBoard() })
            setupSlider(ChangeListener { _, _, newValue -> changeGameSpeed(newValue.toInt()) })
            setupBorderLessToggle(ChangeListener { _, _, _ -> gameController.toggleBorderlessMode() })
            setupGridVisibleToggle(ChangeListener { _, _, newValue -> setGridVisible(newValue) })
            createRuleButtons(gameController)
        }
        children.addAll(gameBoardView, setupView)
    }

    private fun changeGameSpeed(gameDelay: Int) {
        gameAnimation.setDelay(gameDelay)
    }

    private fun setGridVisible(visible: Boolean) {
        gameBoardView.gridOn = visible
        updateView(gameController.gameBoard.board)
    }

    fun updateView(gameBoard: Array<Array<Cell>>) {
        gameBoardView.updateCells(gameBoard)
    }

    private fun startGame() {
        gameAnimation.start()
        setupView.setupStartButton(EventHandler { stopGame() }, "Stop")
    }

    private fun stopGame() {
        gameAnimation.stop()
        setupView.setupStartButton(EventHandler { startGame() }, "Start Game")
    }

    fun updateCell(x: Int, y: Int) {
        gameBoardView.updateSingleCell(x, y)
    }

    fun updateRules() {
        setupView.createRuleButtons(gameController)
    }
}
