//myGame.kt
package com.example.badmintongame


fun main(){
    var game = myGame()
    game.startMain()
}


class myGame {
    var userinput_string : String?=""
    var userinput_int : Int? =0
    var selectCharacter_1 : Int =0
    var selectCharacter_2 : Int =0
    lateinit var characterList: Array<Character>

    fun makeCharacters(){
        var character_0 = Character("이세영", 100, 100, 100)
        var character_1 = Character("박준호", 80, 40, 100)
        var character_2 = Character("이승윤", 50, 20, 50)
        var character_3 = Character("김지우",40,20, 50)
        var character_4 = Character("김재진",60,30, 60)

        characterList= arrayOf(character_0,character_1,character_2,character_3,character_4)
    }


    fun startMain() {
        makeCharacters()
        println("선택 가능한 캐릭터")
        printAllCharacter()
        //Player_1 = 이승윤 Player_2 = 박준호 라고 가정
        selectCharacter(1) //1P 고르기
        selectCharacter(2) //2P 고르기

        startGame(characterList[selectCharacter_1], characterList[selectCharacter_2])

        print("재실행 하시겠습니까? (Y/N) :")
        userinput_string = readLine().toString()
        if(userinput_string=="y" || userinput_string=="Y"){
            startMain()
        }
        else {
            println("완전히 종료합니다")
        }
    }

    fun selectCharacter(select : Int){
        when(select){
            1 -> {
                print("[Player_1] 원하는 캐릭터를 숫자로 골라주세요 :")
                while (true) {
                    userinput_int = readLine()?.toIntOrNull()
                    if(userinput_int in 1..characterList.size) {
                        break
                    } else {
                        print("보기에 있는 숫자를 입력하세요 :")
                    }
                }
                selectCharacter_1 = userinput_int!! - 1
                print("[Player_1] 고르신 캐릭터 :")
                println(characterList[selectCharacter_1].name)
            }
            2 -> {
                print("[Player_2] 원하는 캐릭터를 숫자로 골라주세요 :")
                while (true) {
                    userinput_int = readLine()?.toIntOrNull()
                    if(userinput_int in 1..characterList.size) {
                        break
                    } else {
                        print("보기에 있는 숫자를 입력하세요 :")
                    }
                }
                selectCharacter_2 = userinput_int!! - 1
                print("[Player_2] 고르신 캐릭터 :")
                println(characterList[selectCharacter_2].name)
            }
        }

    }

    fun printAllCharacter() {
        for (i in 0..characterList.size-1) {
            print("${i+1}.${characterList[i].name}  ")
        }
        println("")
    }

    fun startGame(player1: Character, player2: Character) {
        inGame(player1,player2).Play()
    }

}

