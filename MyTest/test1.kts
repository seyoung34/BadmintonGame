import kotlin.random.Random

class Character(val name : String, var atk : Int, var def : Int) {

    var score : Int =0

    fun defense(defender: Character){
        //println("${name}이 ${defender}한테 공격합니다")
    }

    fun attack(attacker: Character, defender: Character){
        println("${attacker.name}가/이 ${defender.name}한테 공격합니다")
        if(SuccessfulAttack(attacker,defender).isAttackSuccessful()){
            println("공격 성공!")
            println("1점 획득")
            attacker.score++
        }
        else{
            println("${attacker.name}의 공격 실패! ${defender.name}의 수비 성공!")
            println("--턴넘기기")
        }
    }

}

class SuccessfulAttack(attacker : Character, defender : Character){
    var attackProbability : Int = attacker.atk - defender.def //공격력 - 방어력 해서 공격확률
    val randomValue : Int = Random.nextInt(1,101)   //1~100 사이의 랜덤한 수

    fun isAttackSuccessful(): Boolean {
        return randomValue < attackProbability  // attackprobability가 높을 수록 참일 확률이 높으니까 맞나?
    }

}



var Lee = Character("이승윤",50,20)
var Park = Character("박준호",70,40)

println("==게임을 시작합니다==")
println("박준호가 이승윤한테 10번 공격합니다")
for(i in 1..10) {
    println("${i}번째-------------------")
    Park.attack(Park, Lee)
}
println("공격자 박준호의 최종 점수 ${Park.score}")

