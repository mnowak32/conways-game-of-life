package com.codecool.gameoflife.view;

import com.codecool.gameoflife.model.Config;
import javafx.scene.paint.Color;

import java.awt.*;

public class DisplayConfig {

    public static final double SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.8;
    public static final double SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.8;
    public static final int CELL_SIDE = (int) (SCREEN_WIDTH / Config.BOARD_SIDE * 0.5);
    public static final Color ALIVE_COLOR = Color.ORCHID;
    public static final Color DEAD_COLOR = Color.LIGHTGRAY;
}
