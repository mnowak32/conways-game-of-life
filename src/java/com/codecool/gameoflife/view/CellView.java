package com.codecool.gameoflife.view;

import com.codecool.gameoflife.model.Cell;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class CellView extends Rectangle {

    public CellView(Cell cell) {
        super(DisplayConfig.CELL_SIDE, DisplayConfig.CELL_SIDE);
        Color color = cell.isAlive() ? Color.RED : Color.WHITE;
        this.setFill(color);
    }
}
