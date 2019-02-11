package com.codecool.gameoflife;

import com.codecool.gameoflife.controller.GameController;
import com.codecool.gameoflife.view.DisplayConfig;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameOfLife extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        GameController gameController = new GameController();

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(gameController.getGameView(), DisplayConfig.SCREEN_WIDTH, DisplayConfig.SCREEN_HEIGHT));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
