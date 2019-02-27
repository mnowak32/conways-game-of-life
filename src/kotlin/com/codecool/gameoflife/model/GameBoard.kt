package com.codecool.gameoflife.model

class GameBoard(val width: Int, val height: Int) {

    private var rules = RuleSet.getDefaultRuleSet()
    var board = newBoard()
    private var borderLess = false

    constructor(boardSide: Int) : this(boardSide, boardSide)

    private fun newBoard() = Array(height) { Array(width) { false } }

    fun toggleBorderLess() {
        this.borderLess = !borderLess
    }

    fun reset() {
        board = newBoard()
    }

    fun randomizeBoard() {
        for (row in board) {
            for (cellId in row.indices) {
                row[cellId] = Math.random() > 0.5
            }
        }
    }

    fun nextGeneration() {
        val nextGen = newBoard()
        for (i in nextGen.indices) {
            for (j in nextGen[i].indices) {
                nextGen[i][j] = cellLived(i, j)
            }
        }
        board = nextGen
    }

    private fun cellLived(x: Int, y: Int): Boolean {
        val neighborsNumber = checkNeighbors(x, y)
        return if (board[x][y]) {
            rules.aliveRules
        } else {
            rules.deadRules
        }.contains(neighborsNumber)
    }

    private infix fun Int.modulo(d: Int): Int {
        // Don't check for a division by 0, "%" operator will throw an exception in that case.
        val rem = this % d
        return if (rem < 0) rem + d else rem
    }

    private fun cellAt(xy: Pair<Int, Int>): Boolean? {
        return if (borderLess) {
            val truX = xy.first modulo width
            val truY = xy.second modulo height
            board[truX][truY]
        } else {
            if (xy.first < 0 || xy.second < 0 || xy.first >= width || xy.second >= height) {
                null
            } else {
                board[xy.first][xy.second]
            }
        }
    }

    /**
     * Checks a neighboring cells and returns a number of alive ones.
     * Excludes the checked cell.
     * If borderLess field is true it checks the neighbors as if there were no borders
     * (eg. in board of len 10 board[-1][0] becomes board[9][0])
     * @param cellX - the X position of cell to check
     * @param cellY - the Y position of cell to check
     * @return number of alive cells.
     */
    private fun checkNeighbors(cellX: Int, cellY: Int) = neighbourCoords
            .map { it.first + cellX to it.second + cellY}
            .count { cellAt(it) == true }

    fun setRuleSet(ruleSet: RuleSet) {
        this.rules = ruleSet
    }

    companion object {
        private val neighbourCoords = listOf(
                -1 to -1, -1 to 0, -1 to 1,
                0 to -1, 0 to 1,
                1 to -1, 1 to 0, 1 to 1
        )
    }
}
