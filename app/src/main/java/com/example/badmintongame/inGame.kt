//inGame.kt
package com.example.badmintongame

import kotlin.random.Random

open class inGame(player_1 :Character, player_2: Character) {

    var gameover: Boolean = false
    val EndScore = 3    // 경기 종료 스코어
    val MaxGameScore = 30 //테스트 최대 게임 수
    var Max = 0   //테스트를 위한 게임수
    var exit: Boolean = false
    var userinput: Int? = 0
    //var UserInput: Int = 0
    var whoseTurn : Boolean = true

    var Player_1 : Player = Player(player_1.name,player_1.atk,player_1.def,player_1.mastery, this)
    var Player_2 : Player = Player(player_2.name,player_2.atk,player_2.def,player_2.mastery, this)

    fun Play(){
        println("\n>>>>>콕콕 게임 시작합니다<<<<<")
        println("${Player_1.name} VS ${Player_2.name}\n")
        while (isGameOver()==false) {
            //프린트 스크린을 해서 옵션 선택 후 함수 실행
            printscreen()
        }

        //종료부분
        resultGame()
        println("\n\n정상 종료합니다.....")
    }

    fun isGameOver(): Boolean {
        gameover = ((Player_1.score >= EndScore) || (Player_2.score >= EndScore) || (Max >= MaxGameScore) || exit)
        return gameover
    }

    fun printscreen() {
        println("########################")
        println("# 1.PLAYER_1의 스탯 보기 ")
        println("# 2.PLAYER_2의 스탯 보기 ")
        println("# 3.PLAYER_1의 공격     ")
        println("# 4.PLAYER_2의 공격     ")
        println("# 5.종료까지 자동 대결   ")
        println("# 6.강제 종료           ")
        println("########################")
        print("->입력 :")
        while (true) {
            userinput = readLine()?.toIntOrNull()
            if (userinput in 1..6) {
                break
            } else {
                println("->1~6까지의 숫자를 입력하세요")
            }
        }

        val userInput = userinput!! // int?에서 int로 변환
        selectOption(userInput)
    }

    fun selectOption(select: Int) {
        when (select) {
            1 -> Player_1.printStatus()
            2 -> Player_2.printStatus()
            3 -> Player_1.attack()
            4 -> Player_2.attack()
            5 -> autoBattle()
            6 -> exit = true
        }

    }

    fun resultGame(){
        if(Player_1.score == Player_2.score){
            println("\n\n동점입니다!")
        }
        else if(Player_1.score > Player_2.score){
            println("\n\n축하합니다! ${Player_1.name}님이 승리하셨습니다!")
        }
        else{
            println("\n\n축하합니다! ${Player_2.name}님이 승리하셨습니다!")
        }
    } //경기 종료 시 점수를 비교하여 승자를 알려줌

    fun autoBattle(){
        while (!isGameOver()) {
            if (whoseTurn) {
                Player_1.attack()
            } else {
                Player_2.attack()
            }
        }
    }

    fun turnOver() {
        whoseTurn = !whoseTurn
    }


//    open class Player(Name: String, Atk: Int, Def: Int, Mastery: Int, private val game: inGame) : Character(Name, Atk, Def, Mastery){
//
//        var score : Int = 0
//
//        fun attack(){
//
//            val attacker: Player = this
//            val defender: Player = if (this == game.Player_1) game.Player_2 else game.Player_1
//
//            println("${attacker.name} 가/이 ${defender.name}한테 공격합니다")
//            if(checkMiss()){ //실수했을 때
//                println("공격 실수!")
//                defender.score++
//                println("->${game.Player_1.name}:${game.Player_1.score} VS ${game.Player_2.name}:${game.Player_2.score}\n")
//                game.turnOver()
//            }
//            else if (isAttackSuccessful(attacker,defender)) {
//                print("->공격 성공!")
//                println(" 1점 획득")
//                attacker.score++
//                println("->${game.Player_1.name}:${game.Player_1.score} VS ${game.Player_2.name}:${game.Player_2.score}\n")
//            } else {
//                println("->${attacker.name}의 공격 실패! ${defender.name}의 수비 성공!")
//
//            }
//        }
//
//
//        fun checkMiss() : Boolean{
//            //공격,수비,서브 때 호출하기
//            var missProbability: Int = 100 - this.mastery
//            val randomValue: Int = Random.nextInt(1, 101)
//            var returnValue : Boolean = false
//            if(randomValue < missProbability) //실수했을 때
//                returnValue = true
//            else
//                returnValue = false
//
//            return returnValue
//        }
//
//        fun isAttackSuccessful(attacker: Player, defender: Player): Boolean {
//
//            var attackProbability: Int = attacker.atk - defender.def //공격력 - 방어력 해서 공격확률
//            val randomValue: Int = Random.nextInt(1, 101)   //1~100 사이의 랜덤한 수
//
//            return randomValue < attackProbability  // attackprobability가 높을 수록 참일 확률이 높으니까 맞나?
//        }
//
////    fun defense(defender: Character) {
////        //println("${name}이 ${defender}한테 공격합니다")
////    }
//
//    }


}