package com.codecool.gameoflife

import com.codecool.gameoflife.controller.GameController
import com.codecool.gameoflife.model.Config
import com.codecool.gameoflife.model.GameBoard
import com.codecool.gameoflife.view.DisplayConfig
import com.codecool.gameoflife.view.GameView
import javafx.application.Application
import javafx.scene.Scene
import javafx.stage.Stage

class GameOfLife : Application() {

    @Throws(Exception::class)
    override fun start(primaryStage: Stage) {
        val gameController = GameController(GameBoard(Config.BOARD_SIDE))

        primaryStage.apply {
            title = "Hello World"
            scene = Scene(gameController.gameView, DisplayConfig.SCREEN_WIDTH, DisplayConfig.SCREEN_HEIGHT)
            show()
        }
    }
}

fun main(args: Array<String>) {
    Application.launch(GameOfLife::class.java, *args)
}

