package com.codecool.gameoflife.view;

import com.codecool.gameoflife.controller.GameController;
import com.codecool.gameoflife.model.Cell;
import javafx.scene.layout.GridPane;

public class GameBoardView extends GridPane {

    private CellView[][] cells;
    private boolean gridOn;


    public GameBoardView(GameController controller) {
        Cell[][] gameBoard = controller.getGameBoard();
        this.gridOn = false;
        this.cells = new CellView[gameBoard.length][gameBoard[0].length];
        this.createCells(gameBoard, controller);
    }

    private void createCells(Cell[][] gameBoard, GameController controller) {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                cells[i][j] = new CellView(gameBoard[i][j]);
                int x = i;
                int y = j;
                cells[i][j].setOnMousePressed(event -> controller.updateCell(x, y));
                this.add(cells[i][j], j, i);
            }
        }
    }

    public void updateCells(Cell[][] gameBoard) {
        for (int i = 0; i < gameBoard.length; i++) {
            for (int j = 0; j < gameBoard[i].length; j++) {
                cells[i][j].update(gameBoard[i][j], gridOn);
            }
        }
    }

    public void setGridOn(boolean visible) {
        this.gridOn = visible;
    }

    public void updateCell(Cell cellToUpdate, int x, int y) {
        this.cells[x][y].update(cellToUpdate, gridOn);
    }
}
