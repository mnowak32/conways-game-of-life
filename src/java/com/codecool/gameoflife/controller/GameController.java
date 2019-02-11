package com.codecool.gameoflife.controller;

import com.codecool.gameoflife.model.Config;
import com.codecool.gameoflife.model.GameBoard;
import com.codecool.gameoflife.view.GameView;

public class GameController {

    private GameBoard gameBoard = new GameBoard(Config.BOARD_SIDE,Config.BOARD_SIDE);
    private GameView gameView = new GameView();

    public GameController() {
        this.gameView.setGameBoardView(gameBoard);
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public GameView getGameView() {
        return gameView;
    }


}
