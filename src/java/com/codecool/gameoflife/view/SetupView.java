package com.codecool.gameoflife.view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class SetupView extends VBox {

    private Button startButton;
    private Button randomizeButton;

    SetupView() {
        this.startButton = new Button("Start");
        this.randomizeButton = new Button("Randomize grid");
        this.getChildren().addAll(startButton, randomizeButton);
    }

    void setupStartButton(EventHandler<ActionEvent> handler, String label) {
       this.startButton.setText(label);
       this.startButton.setOnAction(handler);
    }

    void setupRandomizeButton(EventHandler<ActionEvent> handler) {
        this.randomizeButton.setOnAction(handler);
    }
}
