package com.codecool.gameoflife.model;

import java.util.Arrays;
import java.util.List;

public enum RuleSet {
    CLASSIC(Arrays.asList(2, 3), Arrays.asList(3)),
    LABYRINTH(Arrays.asList(1,2,3,4,5), Arrays.asList(3)),
    MOVEMENT(Arrays.asList(2,4,5), Arrays.asList(3, 6, 8)),
    DIAMEBA(Arrays.asList(5, 6, 7, 8), Arrays.asList(3, 5, 6, 7, 8));

    private List<Integer> aliveRules;
    private List<Integer> deadRules;

    RuleSet(List<Integer> aliveRules, List<Integer> deadRules) {
        this.aliveRules = aliveRules;
        this.deadRules = deadRules;
    }

    public List<Integer> getAliveRules() {
        return aliveRules;
    }

    public List<Integer> getDeadRules() {
        return deadRules;
    }
}
