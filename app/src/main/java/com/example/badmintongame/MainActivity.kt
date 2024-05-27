package com.example.badmintongame

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    lateinit var game: myGame
    lateinit var scoreBoard: TextView
    lateinit var player1StatsButton: Button
    lateinit var player2StatsButton: Button
    lateinit var player1AttackButton: Button
    lateinit var player2AttackButton: Button
    lateinit var exitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        game = myGame()
        game.makeCharacters()

        scoreBoard = findViewById(R.id.scoreBoard)
        player1StatsButton = findViewById(R.id.player1StatsButton)
        player2StatsButton = findViewById(R.id.player2StatsButton)
        player1AttackButton = findViewById(R.id.player1AttackButton)
        player2AttackButton = findViewById(R.id.player2AttackButton)
        exitButton = findViewById(R.id.exitButton)

        player1StatsButton.setOnClickListener {
            showPlayerStats(game.characterList[game.selectCharacter_1])
        }

        player2StatsButton.setOnClickListener {
            showPlayerStats(game.characterList[game.selectCharacter_2])
        }

        player1AttackButton.setOnClickListener {
            game.Player_1.attack()
            updateScoreBoard()
        }

        player2AttackButton.setOnClickListener {
            game.Player_2.attack()
            updateScoreBoard()
        }

        exitButton.setOnClickListener {
            finish()
        }

        game.selectCharacter(1)
        game.selectCharacter(2)
        updateScoreBoard()
    }

    private fun showPlayerStats(character: Character) {
        val stats = """
            이름: ${character.name}
            공격력: ${character.atk}
            방어력: ${character.def}
            숙련도: ${character.mastery}
        """.trimIndent()
        scoreBoard.text = stats
    }

    private fun updateScoreBoard() {
        val scoreText = """
            ${game.Player_1.name}: ${game.Player_1.score}
            ${game.Player_2.name}: ${game.Player_2.score}
        """.trimIndent()
        scoreBoard.text = scoreText
    }
}
