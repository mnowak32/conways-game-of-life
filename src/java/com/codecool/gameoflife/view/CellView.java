package com.codecool.gameoflife.view;

import com.codecool.gameoflife.model.Cell;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;


public class CellView extends Rectangle {

    public CellView(Cell cell) {
        super(DisplayConfig.CELL_SIDE, DisplayConfig.CELL_SIDE);
        Color color = cell.isAlive() ? Color.RED : Color.WHITE;
        this.setStroke(Color.BLACK);
        this.setStrokeType(StrokeType.INSIDE);
        this.setFill(color);
        this.setOnMouseEntered(event -> this.setFill(Color.BLUE));
        this.setOnMouseExited(event -> this.setFill(color));
    }

}
