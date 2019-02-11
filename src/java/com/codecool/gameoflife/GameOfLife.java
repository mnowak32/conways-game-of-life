package com.codecool.gameoflife;

import com.codecool.gameoflife.controller.GameController;
import com.codecool.gameoflife.model.Config;
import com.codecool.gameoflife.model.GameBoard;
import com.codecool.gameoflife.view.DisplayConfig;
import com.codecool.gameoflife.view.GameView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameOfLife extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GameController gameController = new GameController();
        gameController.setGameBoard(new GameBoard(Config.BOARD_SIDE));
        gameController.setGameView(new GameView(gameController));

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(gameController.getGameView(), DisplayConfig.SCREEN_WIDTH, DisplayConfig.SCREEN_HEIGHT));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
