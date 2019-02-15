package com.codecool.gameoflife.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public enum RuleSet {
    CLASSIC(Arrays.asList(2, 3), Collections.singletonList(3)),
    Diameba(Arrays.asList(5, 6, 7, 8), Arrays.asList(3, 5, 6, 7, 8)),
    Flakes(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8), Collections.singletonList(3)),
    Labyrinth(Arrays.asList(1, 2, 3, 4, 5), Collections.singletonList(3)),
    Movement(Arrays.asList(2, 4, 5), Arrays.asList(3, 6, 8)),
    Seeds(Collections.EMPTY_LIST, Collections.singletonList(2)),
    Growth(Collections.singletonList(1), Collections.singletonList(1)),
    Wolfram(Arrays.asList(0, 1, 8), Arrays.asList(0, 1, 8)),
    Wolfram2(Arrays.asList(1,2,3,4,5,6), Arrays.asList(0,5,7,8)),
    Cities(Arrays.asList(2,3,4,5), Arrays.asList(4,5,6,7,8));

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
