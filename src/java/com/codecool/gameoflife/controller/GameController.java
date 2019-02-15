package com.codecool.gameoflife.controller;

import com.codecool.gameoflife.model.Cell;
import com.codecool.gameoflife.model.GameBoard;
import com.codecool.gameoflife.model.RuleSet;
import com.codecool.gameoflife.view.GameView;

import java.util.ArrayList;
import java.util.List;

public class GameController {

    private GameBoard gameBoard;
    private GameView gameView;

    public void setGameBoard(GameBoard gameBoard) {
        this.gameBoard = gameBoard;
    }

    public void setGameView(GameView gameView) {
        this.gameView = gameView;
        this.gameView.updateView(gameBoard.getBoard());
    }

    public GameView getGameView() {
        return gameView;
    }

    public void nextGeneration() {
        this.gameBoard.nextGeneration();
        this.gameView.updateView(this.gameBoard.getBoard());
        }

    public void randomizeGrid() {
        this.gameBoard.randomizeBoard();
        this.gameView.updateView(this.gameBoard.getBoard());
    }

    public void updateCell(int x, int y) {
        Cell cellToUpdate = this.gameBoard.getBoard()[x][y];
        cellToUpdate.toggleAlive();
        this.gameView.updateCell(cellToUpdate, x, y);
    }

    public void toggleBorderlessMode() {
        this.gameBoard.toggleBorderLess();
    }

    public Cell[][] getGameBoard() {
        return this.gameBoard.getBoard();
    }

    public void setRules(RuleSet ruleSet) {
        this.gameBoard.setRuleSet(ruleSet);
    }

    public void clearBoard() {
        this.gameBoard.populateTiles();
        this.gameView.updateView(this.gameBoard.getBoard());
    }

    public void addRules(String name, String aliveString, String deadString) {
        List<Integer> aliveRules = convertRulesToList(aliveString);
        List<Integer> deadRules = convertRulesToList(deadString);
        if (deadRules == null || aliveRules == null) {
            return;
        }
        RuleSet.addRuleSet(name, aliveRules, deadRules);
        this.gameView.updateRules();
    }

    private List<Integer> convertRulesToList(String rules) {
        List<Integer> rulesList = new ArrayList<>();
        String[] rulesArray = rules.split(",");
        for (String rule : rulesArray) {
            rule = rule.trim();
            if (!rule.matches("\\d+")) {
                return null;
            }
            rulesList.add(Integer.parseInt(rule));
        }

        return rulesList;
    }
}
