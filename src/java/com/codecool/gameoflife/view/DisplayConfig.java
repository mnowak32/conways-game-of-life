package com.codecool.gameoflife.view;

import com.codecool.gameoflife.model.Config;

import java.awt.*;

public class DisplayConfig {

    public static final double SCREEN_WIDTH = Toolkit.getDefaultToolkit().getScreenSize().getWidth() * 0.8;
    public static final double SCREEN_HEIGHT = Toolkit.getDefaultToolkit().getScreenSize().getHeight() * 0.8;
    public static final double CELL_SIDE = SCREEN_WIDTH / Config.BOARD_SIDE * 0.5;
}
