package com.codecool.gameoflife.view;

import com.codecool.gameoflife.controller.GameController;
import com.codecool.gameoflife.model.RuleSet;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class SetupView extends HBox {

    private VBox gameSettings;
    private VBox rulesSettings;
    private Button startButton;
    private Button randomizeButton;
    private Button clearButton;
    private Slider speedSlider;
    private CheckBox borderLessModeToggle;
    private CheckBox gridVisibleToggle;
    private ToggleGroup rulesToggle;

    SetupView() {
        super(50);
        this.gameSettings = new VBox(10);
        this.rulesSettings = new VBox(10);
        this.setPadding(new Insets(25));
        this.startButton = new Button("Start");
        this.randomizeButton = new Button("Randomize grid");
        this.clearButton = new Button("Clear");
        Label speedLabel = new Label("Speed");
        this.speedSlider = new Slider(0, 400, 200);
        this.speedSlider.setShowTickLabels(true);
        this.borderLessModeToggle = new CheckBox("Borderless mode");
        this.gridVisibleToggle = new CheckBox("Grid visible");
        this.rulesToggle = new ToggleGroup();
        Label rulesLabel = new Label("Rules modifications:");
        this.gameSettings.getChildren().addAll(startButton, randomizeButton, clearButton, speedLabel,
                speedSlider, borderLessModeToggle, gridVisibleToggle);
        this.rulesSettings.getChildren().add(rulesLabel);
        this.getChildren().addAll(gameSettings, rulesSettings);
    }

    void setupRulesToggles(GameController gameController) {
        for (RuleSet ruleSet : RuleSet.values()) {
            RadioButton button = new RadioButton(ruleSet.toString());
            button.setToggleGroup(this.rulesToggle);
            button.setUserData(ruleSet);
            button.setOnMouseClicked(event -> gameController.setRules((RuleSet) button.getUserData()));
            this.rulesSettings.getChildren().add(button);
        }
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

    void setupClearButton(EventHandler<ActionEvent> handler) {
        this.clearButton.setOnAction(handler);
    }

    void setupBorderLessToggle(ChangeListener<Boolean> changeListener) {
        this.borderLessModeToggle.selectedProperty().addListener(changeListener);
    }

    void setupGridVisibleToggle(ChangeListener<Boolean> changeListener) {
        this.gridVisibleToggle.selectedProperty().addListener(changeListener);
    }
}
