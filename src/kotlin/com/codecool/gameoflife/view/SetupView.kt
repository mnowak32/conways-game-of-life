package com.codecool.gameoflife.view

import com.codecool.gameoflife.controller.GameController
import com.codecool.gameoflife.model.RuleSet
import javafx.beans.value.ChangeListener
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.scene.control.*
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Text

class SetupView : HBox(50.0) {

    private val rulesSettings = VBox(10.0)
    private val startButton = Button("Start")
    private val randomizeButton = Button("Randomize grid")
    private val clearButton = Button("Clear")
    private val speedSlider = Slider(0.0, 400.0, 200.0)
    private val borderLessModeToggle = CheckBox("Borderless mode")
    private val gridVisibleToggle = CheckBox("Grid visible")
    private val rulesToggle = ToggleGroup()
    private val validationResult: Text = Text()

    init {
        this.padding = Insets(25.0)
        val speedLabel = Label("Speed")
        speedSlider.isShowTickLabels = true
        val gameSettings = VBox(10.0).apply {
            children.addAll(
                    startButton,
                    randomizeButton,
                    clearButton,
                    speedLabel,
                    speedSlider,
                    borderLessModeToggle,
                    gridVisibleToggle
            )
        }
        children.addAll(gameSettings, rulesSettings)
    }

    fun createRuleButtons(gameController: GameController) {
        rulesSettings.children.apply {
            setAll(Label("Rules modifications:"))
            RuleSet.ruleSets.values.forEach { rs ->
                add(RadioButton(rs.name).apply {
                    toggleGroup = rulesToggle
                    userData = rs
                    setOnMouseClicked { gameController.setRules(this.userData as RuleSet) }
                })
            }
            add(createCustomRulesForm(gameController))
            add(validationResult)
        }
    }

    private fun createCustomRulesForm(controller: GameController): HBox {
        val form = HBox(5.0)
        val aliveRules = TextField()
        val deadRules = TextField()
        aliveRules.prefColumnCount = 5
        deadRules.prefColumnCount = 5
        val addRules = Button("Add")
        addRules.setOnAction {
            val success = controller.addRules("Custom", aliveRules.text, deadRules.text)
            if (success) {
                validationResult.text = "Added new custom rules."
            } else {
                validationResult.text = "Wrong rules format"
            }
        }
        form.children.addAll(Label("Custom:"), aliveRules,
                Label("/"), deadRules, addRules)
        return form
    }

    fun setupSlider(numberChangeListener: ChangeListener<Number>) {
        speedSlider.valueProperty().addListener(numberChangeListener)
    }

    fun setupStartButton(handler: EventHandler<ActionEvent>, label: String) {
        startButton.text = label
        startButton.onAction = handler
    }

    fun setupRandomizeButton(handler: EventHandler<ActionEvent>) {
        randomizeButton.onAction = handler
    }

    fun setupClearButton(handler: EventHandler<ActionEvent>) {
        clearButton.onAction = handler
    }

    fun setupBorderLessToggle(changeListener: ChangeListener<Boolean>) {
        borderLessModeToggle.selectedProperty().addListener(changeListener)
    }

    fun setupGridVisibleToggle(changeListener: ChangeListener<Boolean>) {
        gridVisibleToggle.selectedProperty().addListener(changeListener)
    }
}
