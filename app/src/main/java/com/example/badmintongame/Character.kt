//Character.kt
package com.example.badmintongame

open class Character(Name: String, Atk: Int, Def: Int, Mastery: Int) {

    var name = Name
    var atk = Atk
    var def = Def
    var mastery = Mastery



    fun printStatus() {

        print(
            "+--------------------------+\n" +
            "| 이름 : ${name}             ㅣ\n" +
            "| ->공격력 : ${atk}             |\n" +
            "| ->방어력 : ${def}             |\n" +
            "| ->숙련도 : ${mastery}             |\n" +
            "+--------------------------+\n"
        )


    }


}