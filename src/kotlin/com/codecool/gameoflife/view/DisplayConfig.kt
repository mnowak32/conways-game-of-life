package com.codecool.gameoflife.view

import com.codecool.gameoflife.model.Config
import javafx.scene.paint.Color

import java.awt.*

object DisplayConfig {

    val SCREEN_WIDTH = Toolkit.getDefaultToolkit().screenSize.getWidth() * 0.8
    val SCREEN_HEIGHT = Toolkit.getDefaultToolkit().screenSize.getHeight() * 0.8
    val CELL_SIDE = SCREEN_WIDTH / Config.BOARD_SIDE * 0.5
    val ALIVE_COLOR: Color = Color.ORCHID
    val DEAD_COLOR: Color = Color.LIGHTGRAY
}
