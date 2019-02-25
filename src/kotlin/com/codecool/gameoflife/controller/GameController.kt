package com.codecool.gameoflife.controller

import com.codecool.gameoflife.model.GameBoard
import com.codecool.gameoflife.model.RuleSet
import com.codecool.gameoflife.view.GameView

class GameController(public val gameBoard: GameBoard) {
    val gameView: GameView

    init {
        gameView = GameView(this)
        gameView.updateView(gameBoard.board)
    }

    fun nextGeneration() {
        gameBoard.nextGeneration()
        gameView.updateView(gameBoard.board)
    }

    fun randomizeGrid() {
        gameBoard.randomizeBoard()
        gameView.updateView(gameBoard.board)
    }

    fun updateCell(x: Int, y: Int) {
        val cellToUpdate = gameBoard.board[x][y]
        cellToUpdate.toggleAlive()
        gameView.updateCell(x, y)
    }

    fun toggleBorderlessMode() {
        gameBoard.toggleBorderLess()
    }

    fun setRules(ruleSet: RuleSet) {
        gameBoard.setRuleSet(ruleSet)
    }

    fun clearBoard() {
        gameBoard.reset()
        gameView.updateView(gameBoard.board)
    }

    fun addRules(name: String, aliveString: String, deadString: String): Boolean {
        val aliveRules = convertRulesToList(aliveString)
        val deadRules = convertRulesToList(deadString)
        return if (deadRules.isEmpty() || aliveRules.isEmpty()) {
            false
        } else {
            RuleSet.addRuleSet(name, aliveRules, deadRules)
            gameView.updateRules()
            true
        }
    }

    private fun convertRulesToList(rules: String): List<Int> {
        return rules.split(",")
                .map { it.trim() }
                .filter { it.matches(RX_DIGITS) }
                .mapNotNull { it.toIntOrNull() }
    }

    companion object {
        private val RX_DIGITS = "\\d+".toRegex()
    }
}
