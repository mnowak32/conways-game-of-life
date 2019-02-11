package com.codecool.gameoflife.view;

import com.codecool.gameoflife.controller.GameController;
import com.codecool.gameoflife.model.Cell;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
public class GameView extends HBox {

    private GridPane gameBoardView = new GridPane();
    private SetupView setupView = new SetupView();
    private GameController gameController;
    private GameLoop gameAnimation;

    public GameView(GameController gameController) {
        this.gameController = gameController;
        this.gameAnimation = new GameLoop(1000, gameController::nextGeneration);
        this.setupView.setupStartButton(event -> this.startGame(), "Start Game");
        this.setupView.setupRandomizeButton(event -> this.gameController.randomizeGrid());
        this.getChildren().addAll(gameBoardView, setupView);
    }

    public void setGameBoardView(GameBoard gameBoard) {
        Cell[][] board = gameBoard.getBoard();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                gameBoardView.add(new CellView(board[i][j]), i, j);
            }
        }
    }

    private void startGame() {
        this.gameAnimation.start();
        this.setupView.setupStartButton(event -> this.stopGame(), "Stop");
    }

    private void stopGame() {
        this.gameAnimation.stop();
        this.setupView.setupStartButton(event -> this.startGame(), "Start Game");
    }
}
