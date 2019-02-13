package com.codecool.gameoflife.controller;

import com.codecool.gameoflife.model.GameBoard;
import com.codecool.gameoflife.view.GameView;

public class GameController {

    private GameBoard gameBoard;
    private GameView gameView;

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void setGameView(GameView gameView) {
        this.gameView = gameView;
        this.gameView.updateView(gameBoard.getBoard());
    }

    public GameView getGameView() {
        return gameView;
    }

    public void nextGeneration() {
        this.gameBoard.nextGeneration();
        this.gameView.updateView(this.gameBoard.getBoard());
        }

    public void randomizeGrid() {
        this.gameBoard.randomizeBoard();
        this.gameView.updateView(this.gameBoard.getBoard());
    }

    public void updateCell(int x, int y) {
        this.gameBoard.getBoard()[x][y].toggleAlive();
        this.gameView.updateView(this.gameBoard.getBoard());
    }

    public void toggleBorderlessMode() {
        this.gameBoard.toggleBorderLess();
    }
}
