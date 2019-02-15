package com.codecool.gameoflife.view;

import com.codecool.gameoflife.controller.GameController;
import com.codecool.gameoflife.model.Cell;
import javafx.scene.layout.HBox;
public class GameView extends HBox {

    private GridPaneView gameBoardView;
    private SetupView setupView = new SetupView();
    private GameController gameController;
    private GameLoop gameAnimation;

    public GameView(GameController gameController) {
        this.gameBoardView = new GridPaneView(gameController);
        this.gameController = gameController;
        this.gameAnimation = new GameLoop(200, gameController::nextGeneration);
        this.setupView.setupStartButton(event -> this.startGame(), "Start Game");
        this.setupView.setupRandomizeButton(event -> this.gameController.randomizeGrid());
        this.setupView.setupClearButton(event -> this.gameController.clearBoard());
        this.setupView.setupSlider((observable, oldValue, newValue) -> this.changeGameSpeed(newValue.intValue()));
        this.setupView.setupBorderLessToggle((observable, oldValue, newValue) -> this.gameController.toggleBorderlessMode());
        this.setupView.setupGridVisibleToggle((observable, oldValue, newValue) -> this.setGridVisible(newValue));
        this.setupView.createRuleButtons(gameController);
        this.getChildren().addAll(gameBoardView, setupView);
    }

    private void changeGameSpeed(int gameDelay) {
        this.gameAnimation.setDelay(gameDelay);
    }

    private void setGridVisible(boolean visible) {
        this.gameBoardView.setGridOn(visible);
        this.updateView(this.gameController.getGameBoard());
    }

    public void updateView(Cell[][] gameBoard) {
        this.gameBoardView.updateCells(gameBoard);
    }

    private void startGame() {
        this.gameAnimation.start();
        this.setupView.setupStartButton(event -> this.stopGame(), "Stop");
    }

    private void stopGame() {
        this.gameAnimation.stop();
        this.setupView.setupStartButton(event -> this.startGame(), "Start Game");
    }

    public void updateCell(Cell cellToUpdate, int x, int y) {
        this.gameBoardView.updateSingleCell(cellToUpdate, x, y);
    }

    public void updateRules() {
        this.setupView.createRuleButtons(this.gameController);
    }
}
