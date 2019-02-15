package com.codecool.gameoflife.view;

import com.codecool.gameoflife.model.Cell;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;


public class CellView extends Rectangle {

    public CellView(Cell cell) {
        super(DisplayConfig.CELL_SIDE, DisplayConfig.CELL_SIDE);
        this.setStrokeType(StrokeType.INSIDE);
        this.setOnMouseEntered(event -> this.setFill(Color.BLUE));
        this.update(cell, false);
    }

    public void update(Cell cell, boolean gridOn) {
        Color color = cell.isAlive() ? DisplayConfig.ALIVE_COLOR : DisplayConfig.DEAD_COLOR;
        if (gridOn) {
            this.setStroke(Color.BLACK);
        } else {
            this.setStroke(Color.TRANSPARENT);
        }
        this.setFill(color);
        this.setOnMouseExited(event -> this.setFill(color));
    }
}
