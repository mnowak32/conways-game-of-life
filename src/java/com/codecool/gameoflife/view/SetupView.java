package com.codecool.gameoflife.view;

import com.codecool.gameoflife.controller.GameController;
import com.codecool.gameoflife.model.RuleSet;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

public class SetupView extends VBox {

    private Button startButton;
    private Button randomizeButton;
    private Slider speedSlider;
    private CheckBox borderLessModeToggle;
    private CheckBox gridVisibleToggle;
    private ToggleGroup rulesToggle;

    SetupView() {
        super(10);
        this.setPadding(new Insets(25));
        this.startButton = new Button("Start");
        this.randomizeButton = new Button("Randomize grid");
        Label speedLabel = new Label("Speed");
        this.speedSlider = new Slider(0, 400, 200);
        this.speedSlider.setShowTickLabels(true);
        this.borderLessModeToggle = new CheckBox("Borderless mode");
        this.gridVisibleToggle = new CheckBox("Grid visible");
        this.rulesToggle = new ToggleGroup();
        this.getChildren().addAll(startButton, randomizeButton, speedLabel, speedSlider,
                borderLessModeToggle, gridVisibleToggle);
    }

    void setupRulesToggles(GameController gameController) {
        for (RuleSet ruleSet : RuleSet.values()) {
            RadioButton button = new RadioButton(ruleSet.toString());
            button.setToggleGroup(this.rulesToggle);
            button.setUserData(ruleSet);
            button.setOnMouseClicked(event -> gameController.setRules((RuleSet) button.getUserData()));
            this.getChildren().add(button);
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

    void setupBorderLessToggle(ChangeListener<Boolean> changeListener) {
        this.borderLessModeToggle.selectedProperty().addListener(changeListener);
    }

    void setupGridVisibleToggle(ChangeListener<Boolean> changeListener) {
        this.gridVisibleToggle.selectedProperty().addListener(changeListener);
    }
}
