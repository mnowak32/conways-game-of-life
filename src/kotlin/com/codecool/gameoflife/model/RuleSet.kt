package com.codecool.gameoflife.model

class RuleSet(val name: String, val aliveRules: List<Int>, val deadRules: List<Int>) {
    companion object {
        val ruleSets = mutableMapOf(
            "Classic" to RuleSet("Classic", listOf(2, 3), listOf(3)),
            "Diameba" to RuleSet("Diameba", listOf(5, 6, 7, 8), listOf(3, 5, 6, 7, 8)),
            "Flakes" to RuleSet("Flakes", listOf(0, 1, 2, 3, 4, 5, 6, 7, 8), listOf(3)),
            "Labyrinth" to RuleSet("Labyrinth", listOf(1, 2, 3, 4, 5), listOf(3)),
            "Movement" to RuleSet("Movement", listOf(2, 4, 5), listOf(3, 6, 8)),
            "Seeds" to RuleSet("Seeds", emptyList(), listOf(2)),
            "Growth" to RuleSet("Growth", listOf(1), listOf(1)),
            "Wolfram" to RuleSet("Wolfram", listOf(0, 1, 8), listOf(0, 1, 8)),
            "Wolfram2" to RuleSet("Wolfram2", listOf(1, 2, 3, 4, 5, 6), listOf(0, 5, 7, 8)),
            "Cities" to RuleSet("Cities", listOf(2, 3, 4, 5), listOf(4, 5, 6, 7, 8))
        )

        val defaultRulesetName = ruleSets.keys.first()


        fun getRuleSet(ruleName: String): RuleSet? {
            return ruleSets[ruleName]
        }
        fun getDefaultRuleSet() = ruleSets[defaultRulesetName]!!

        fun addRuleSet(name: String, aliveRules: List<Int>, deadRules: List<Int>) {
            ruleSets[name] = RuleSet(name, aliveRules, deadRules)
        }
    }
}
