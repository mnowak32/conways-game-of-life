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
        this.gameAnimation = new GameLoop(200, gameController::nextGeneration);
        this.setupView.setupStartButton(event -> this.startGame(), "Start Game");
        this.setupView.setupRandomizeButton(event -> this.gameController.randomizeGrid());
        this.setupView.setupSlider((observable, oldValue, newValue) -> this.changeGameSpeed(newValue.intValue()));
        this.getChildren().addAll(gameBoardView, setupView);
    }

    private void changeGameSpeed(int gameDelay) {
        this.gameAnimation.setDelay(gameDelay);
    }

    public void updateView(Cell[][] gameBoard) {
        gameBoardView.getChildren().clear();
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                CellView cellView = new CellView(gameBoard[i][j]);
                int y = j;
                int x = i;
                cellView.setOnMousePressed(event -> this.gameController.updateCell(x, y));
                gameBoardView.add(cellView, i, j);
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
