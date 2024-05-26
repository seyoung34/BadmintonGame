import kotlin.random.Random


class BadmintonGame() {

    //게임 정보
    var gameover: Boolean = false //게임종료
    val EndScore = 3    // 경기 종료 스코어
    val MaxGameScore = 30 //테스트 최대 게임 수
    var Max = 0   //테스트를 위한 게임수
    var exit: Boolean = false
    var userinput: Int? = 0
    var UserInput: Int = 0

    lateinit var Player_1: Character
    lateinit var Player_2: Character

    var Park = Character("박준호", 80, 40, 80)
    var Lee = Character("이승윤", 50, 20, 50)
    //var Kim = Character("김지우",40,20)
    //var Jae = Character("김재진",60,30)
    var characterList: Array<Character> = arrayOf(Lee, Park)

    fun startMain() {
        println("선택 가능한 캐릭터")
        printAllCharacter()
        //Player_1 = 이승윤 Player_2 = 박준호 라고 가정
        startGame(Lee, Park)

    }

    fun printAllCharacter() {
        for (character in characterList) {
            character.printStatus()
        }
    }

    fun startGame(player1: Character, player2: Character) {
        Player_1 = player1
        Player_2 = player2
        while (isGameOver()==false) {
            //프린트 스크린을 해서 옵션 선택 후 함수 실행
            printscreen()
        }

        if(Player_1.score > Player_2.score){
            println("\n\n축하합니다! ${Player_1.name}님이 승리하셨습니다!")
        }
        else{
            println("\n\n축하합니다! ${Player_2.name}님이 승리하셨습니다!")
        }


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
        println("# 5.강제 종료           ")
        println("########################")
        print("->입력 :")
        while (true) {
            userinput = readLine()?.toIntOrNull()
            if (userinput in 1..5) {
                break
            } else {
                println("->1~5까지의 숫자를 입력하세요")
            }
        }

        val userInput = userinput!! // int?에서 int로 변환
        selectOption(userInput)
    }

    fun selectOption(select: Int) {
        when (select) {
            1 -> printStatus(Player_1)
            2 -> printStatus(Player_2)
            3 -> Player_1.attack(Player_1, Player_2)
            4 -> Player_2.attack(Player_2, Player_1)
            5 -> exit = true

        }

    }


    fun printStatus(character: Character) {

        print(
            "+--------------------------+\n" +
                    "| 이름 : ${character.name}             ㅣ\n" +
                    "| ->공격력 : ${character.atk}             |\n" +
                    "| ->방어력 : ${character.def}             |\n" +
                    "+--------------------------+\n"
        )


    }

    fun checkMiss(character: Character) : Boolean{
        //공격,수비,서브 때 호출하기
        var missProbability: Int = 100 - character.mastery
        val randomValue: Int = Random.nextInt(1, 101)
        var returnValue : Boolean = false
        if(randomValue < missProbability) //실수했을 때
            returnValue = true
        else
            returnValue = false

        return returnValue
    }
}
//end - class BadmintonGame-

class Character(Name: String, Atk: Int, Def: Int, Mastery: Int) {

    var name = Name
    var atk = Atk
    var def = Def
    var mastery = Mastery


    var score: Int = 0

    fun attack(attacker: Character, defender: Character) {
        println("${attacker.name} 가/이 ${defender.name}한테 공격합니다")
        if (SuccessfulAttack(attacker, defender).isAttackSuccessful()) {
            print("->공격 성공!")
            println("->1점 획득")
            attacker.score++
            println("->${attacker.name}:${attacker.score} VS ${defender.name}:${defender.score}")
        } else {
            println("->${attacker.name}의 공격 실패! ${defender.name}의 수비 성공!")
            //println("--턴넘기기")
        }
    }

    fun defense(defender: Character) {
        //println("${name}이 ${defender}한테 공격합니다")
    }

    fun printStatus() {

        print(
            "+--------------------------+\n" +
                    "| 이름 : ${name}             ㅣ\n" +
                    "| ->공격력 : ${atk}             |\n" +
                    "| ->방어력 : ${def}             |\n" +
                    "+--------------------------+\n"
        )


    }


}

class SuccessfulAttack(attacker: Character, defender: Character) {
    var attackProbability: Int = attacker.atk - defender.def //공격력 - 방어력 해서 공격확률
    val randomValue: Int = Random.nextInt(1, 101)   //1~100 사이의 랜덤한 수

    fun isAttackSuccessful(): Boolean {
        return randomValue < attackProbability  // attackprobability가 높을 수록 참일 확률이 높으니까 맞나?
    }

}


//---------------------------------------------------------

val myGame = BadmintonGame()
myGame.startMain()

//----------------------------------------------------------



