package com.example.badmintongame

import kotlin.random.Random

open class Player(
    name: String,
    atk: Int,
    def: Int,
    mastery: Int,
    private val game: inGame
) : Character(name, atk, def, mastery) {

    var score: Int = 0

    fun attack() {
        val attacker: Player = this
        val defender: Player = if (this == game.Player_1) game.Player_2 else game.Player_1

        println("${attacker.name} 가/이 ${defender.name}한테 공격합니다")
        if (checkMiss()) { // 실수했을 때
            println("공격 실수!")
            defender.score++
            println("->${attacker.name}:${attacker.score} VS ${defender.name}:${defender.score}")
        } else if (isAttackSuccessful(attacker, defender)) {
            println("->공격 성공!")
            println(" 1점 획득")
            attacker.score++
            println("->${attacker.name}:${attacker.score} VS ${defender.name}:${defender.score}")
        } else {
            println("->${attacker.name}의 공격 실패! ${defender.name}의 수비 성공!")
            game.turnOver()
        }
    }

    private fun checkMiss(): Boolean {
        val missProbability: Int = 100 - this.mastery
        val randomValue: Int = Random.nextInt(1, 101)
        return randomValue < missProbability // 실수했을 때
    }

    private fun isAttackSuccessful(attacker: Player, defender: Player): Boolean {
        val attackProbability: Int = attacker.atk - defender.def
        val randomValue: Int = Random.nextInt(1, 101)
        return randomValue < attackProbability
    }
}
