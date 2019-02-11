package com.codecool.gameoflife.view;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;

public class SetupView extends VBox {

    private Button startButton;
    private Button randomizeButton;
    private Label speedLabel;
    private Slider speedSlider;

    SetupView() {
        this.startButton = new Button("Start");
        this.randomizeButton = new Button("Randomize grid");
        this.speedLabel = new Label("Speed");
        this.speedSlider = new Slider(0, 400, 200);
        this.getChildren().addAll(startButton, randomizeButton, speedLabel, speedSlider);
    }

    void setupSlider(ChangeListener<Number> numberChangeListener) {
        this.speedSlider.valueProperty().addListener(numberChangeListener);
    }

    void setupStartButton(EventHandler<ActionEvent> handler, String label) {
       this.startButton.setText(label);
       this.startButton.setOnAction(handler);
    }

    void setupRandomizeButton(EventHandler<ActionEvent> handler) {
        this.randomizeButton.setOnAction(handler);
    }
}
