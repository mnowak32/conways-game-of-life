package com.codecool.gameoflife.model;

public class GameBoard {
    Cell[][] board;

    public Cell[][] getBoard() {
        return board;
    }

    public Cell getTileAt(int x, int y) {
        return this.board[x][y];
    }

    public GameBoard(int width, int height) {
        this.board = new Cell[width][height];
        this.populateTiles();
    }

    private void populateTiles() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                board[i][j] = new Cell(i, j);
            }
        }
    }

    public void showBoard() {
        for (int i = 0; i < board.length; i++) {
            System.out.println();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j].isAlive()) {
                    System.out.print(String.format(" %s.%s ", i ,j));
                } else {
                    System.out.print(" ... ");
                }
            }
        }
    }

    public void nextGeneration() {

    }

    /**
     * Checks a neighboring cells and returns a number of alive ones.
     * Excludes the checked cell.
     * @param cellX - the X position of cell to check
     * @param cellY - the Y position of cell to check
     * @return number of alive cells.
     */
    public int checkNeighbors(int cellX, int cellY) {
        int aliveCount = 0;

        for (int offsetX = -1; offsetX < 2; offsetX++) {
            for (int offsetY = -1; offsetY < 2; offsetY++) {
                int neighborX = cellX + offsetX, neighborY = cellY + offsetY;

                if (neighborX < 0 || neighborX > this.board[0].length ||
                    neighborY < 0 || neighborY > this.board.length ||
                    offsetX == 0 && offsetY ==0) {
                    continue;
                }

                if (this.board[neighborX][neighborY].isAlive()) {
                    aliveCount++;
                }
            }
        }
        return aliveCount;
    }
}
