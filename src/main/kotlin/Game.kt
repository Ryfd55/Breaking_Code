import java.util.*
import kotlin.collections.ArrayList


class Game(private val questionFullList: MutableMap<Int, String>, private val mapa: MutableMap<String, Int>) {
    fun start() {
        val player1: ArrayList<String> = arrayListOf()
        val player2: ArrayList<String> = arrayListOf()
        val player3: ArrayList<String> = arrayListOf()
        val player4: ArrayList<String> = arrayListOf()
        val playerKOD: ArrayList<String> = arrayListOf()

        val listOfKeys: MutableList<String> = mutableListOf()
        for (i in mapa.keys) {
            listOfKeys.add(i)
        }
        /**     РАЗМЕШИВАЕМ КОЛОДУ */
        val randomList: MutableList<String> = listOfKeys.toMutableList()
        randomList.shuffle()

        do {
            player1.add(randomList[0])
            player2.add(randomList[1])
            player3.add(randomList[2])
            player4.add(randomList[3])
            playerKOD.add(randomList[4])
            for (i in 0..4) randomList.removeAt(0)
        } while (randomList.isNotEmpty())

        println("Упорядоченные карточки у игроков")
        player1.sort()
        player2.sort()
        player3.sort()
        player4.sort()
        playerKOD.sort()
        println(player1)
        println(player2)
        println(player3)
        println(player4)
        println(playerKOD)

        val random = Random()
        val questionNumberFullList = (1..questionFullList.size).toMutableList().shuffled(random).toMutableList()
//    println(questionNumberFullList)

        val questionOnTableList: MutableList<Int> = mutableListOf()
        val usedQuestions: MutableList<Int> = mutableListOf()
        for (i in 0 until numberOfCardsOnTheTable) {
            questionOnTableList.add(questionNumberFullList[0])
            questionNumberFullList.removeAt(0)
        }

        var input: String?
        for (i in 0 until questionFullList.size) {
            println()
            if (questionOnTableList.size in 1 until numberOfCardsOnTheTable) println("Внимание! Осталось мало вопросов!")

            println("Выберите номер вопроса")
            for (i in 1..questionOnTableList.size) {
                println("$i. ${questionFullList[questionOnTableList[i - 1]]}")
            }

            var inputedNumberFromTable: Int? = null

            while (inputedNumberFromTable == null) {
                input = readlnOrNull()
                inputedNumberFromTable = try {
                    input?.toInt()
                } catch (e: NumberFormatException) {
                    println("Некорректный ввод. Попробуйте еще раз")
                    null
                }
                if (inputedNumberFromTable != null) {
                    if (inputedNumberFromTable !in 0..questionOnTableList.size) {
                        println("Нужно выбрать один из имеющихся вопросов")
                        inputedNumberFromTable = null
                    }
                }
            }

            val answerList = mutableListOf<Int>()
            val answerList8 = mutableListOf<List<Int>>()
            val questionKeyFullList = questionOnTableList[inputedNumberFromTable - 1]
            println("Вопрос: ${questionFullList[questionKeyFullList]}")
            println("Ответы игроков:")

            usedQuestions.add(questionKeyFullList)
            println("список использованных вопросов")
            println(usedQuestions)

            when (questionKeyFullList) {
                1 -> getAnswer1(answerList, questionKeyFullList, player1, player2, player3, player4, mapa)
                2 -> getAnswer2(answerList, questionKeyFullList, player1, player2, player3, player4, mapa)
                3 -> getAnswer3(answerList8, questionKeyFullList, player1, player2, player3, player4, mapa)
                4 -> getAnswer4(answerList, questionKeyFullList, player1, player2, player3, player4, mapa)
                5 -> getAnswer5(answerList, questionKeyFullList, player1, player2, player3, player4, mapa)
            }

            calculation(
                player2,
                mapa,
                questionKeyFullList,
                answerList,
                answerList8,
                indexA,
                indexB,
                indexC,
                indexD,
                usedQuestions
            )

//            questionOnTableList.removeAt(inputedNumberFromTable - 1)
            if (questionNumberFullList.isNotEmpty()) {
                questionOnTableList.add(questionNumberFullList[0])
                questionNumberFullList.removeAt(0)
            }

//            println("оставшиеся вопросы")
//            println(questionFullList)
//            println("оставшиеся вопросы на столе")
//            println(questionOnTableList)
//            println("оставшиеся вопросы в стопке")
//            println(questionNumberFullList)

            println("Игрок 2: Сумма левых трех: ${answerList[1]}")
            if (isReady(playerKOD) == "y") return

            println("Игрок 22: Сумма левых трех: ${answerList[1]}")
        }
    }
}