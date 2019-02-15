package com.codecool.gameoflife.model;

import java.util.*;

public class RuleSet {
    private static Map<String, RuleSet> ruleSets = new HashMap<>();

    private List<Integer> aliveRules;
    private List<Integer> deadRules;
    private String name;

    static {
        ruleSets.put("Classic", new RuleSet("Classic", Arrays.asList(2, 3), Collections.singletonList(3)));
        ruleSets.put("Diameba", new RuleSet("Diameba", Arrays.asList(5, 6, 7, 8), Arrays.asList(3, 5, 6, 7, 8)));
        ruleSets.put("Flakes", new RuleSet("Flakes", Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8), Collections.singletonList(3)));
        ruleSets.put("Labyrinth", new RuleSet("Labyrinth", Arrays.asList(1, 2, 3, 4, 5), Collections.singletonList(3)));
        ruleSets.put("Movement", new RuleSet("Movement", Arrays.asList(2, 4, 5), Arrays.asList(3, 6, 8)));
        ruleSets.put("Seeds", new RuleSet("Seeds", Collections.EMPTY_LIST, Collections.singletonList(2)));
        ruleSets.put("Growth", new RuleSet("Growth", Collections.singletonList(1), Collections.singletonList(1)));
        ruleSets.put("Wolfram", new RuleSet("Wolfram", Arrays.asList(0, 1, 8), Arrays.asList(0, 1, 8)));
        ruleSets.put("Wolfram2", new RuleSet("Wolfram2", Arrays.asList(1,2,3,4,5,6), Arrays.asList(0,5,7,8)));
        ruleSets.put("Cities", new RuleSet("Cities", Arrays.asList(2,3,4,5), Arrays.asList(4,5,6,7,8)));
    }

    public static RuleSet getRuleSet(String ruleName) {
        return ruleSets.get(ruleName);
    }

    public static Collection<RuleSet> getAllRuleSets() {
        return ruleSets.values();
    }

    public static void addRuleSet(String name, List<Integer> aliveRules, List<Integer> deadRules) {
        ruleSets.put(name, new RuleSet(name, aliveRules, deadRules));
    }

    RuleSet(String name, List<Integer> aliveRules, List<Integer> deadRules) {
        this.name = name;
        this.aliveRules = aliveRules;
        this.deadRules = deadRules;
    }

    public List<Integer> getAliveRules() {
        return aliveRules;
    }

    public List<Integer> getDeadRules() {
        return deadRules;
    }

    public String getName() {
        return this.name;
    }
}
