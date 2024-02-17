import java.util.*
import java.util.Collections.shuffle
import kotlin.collections.ArrayList


var indexA: ArrayList<Int> = arrayListOf(0, 1, 2, 3, 4, 5, 6, 7, 8)
var indexB: ArrayList<Int> = arrayListOf(0, 1, 2, 3, 4, 5, 6, 7, 8)
var indexC: ArrayList<Int> = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
var indexD: ArrayList<Int> = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
var player1: ArrayList<ArrayList<Int>> = arrayListOf(indexA, indexB, indexC, indexD)

fun main() {
    val numberOfCardsOnTheTable = 4
    val questionFullList: MutableMap<Int, String> =
        mutableMapOf(
            1 to "Какова сумма чисел на трех ваших левых жетонах",
            2 to "Какова сумма чисел на трех ваших правых жетонах",
            3 to "На каком месте цифра #8",
//            3 to "Какова сумма чисел на центральных жетонах",
            4 to "Какова сумма чисел на всех ваших жетонах",
//            5 to "Сумма всех четных",
//            6 to "Количество жетонов с нечетными числами",
//            7 to "Количество черных жетонов",
//            8 to "Сумма чисел на белых жетонах",
//            9 to "На каком месте цифра #8"
        )
    val mapa: MutableMap<String, Int> =
        mutableMapOf(
            "0b" to 0,
            "0w" to 0,
            "1b" to 1,
            "1w" to 1,
            "2b" to 2,
            "2w" to 2,
            "3b" to 3,
            "3w" to 3,
            "4b" to 4,
            "4w" to 4,
            "5b" to 5,
            "5w" to 5,
            "6b" to 6,
            "6w" to 6,
            "7b" to 7,
            "7w" to 7,
            "8b" to 8,
            "8w" to 8,
            "9b" to 9,
            "9w" to 9
        )
    val player1: ArrayList<String> = arrayListOf()
    val player2: ArrayList<String> = arrayListOf()
    val player3: ArrayList<String> = arrayListOf()
    val player4: ArrayList<String> = arrayListOf()
    val playerKOD: ArrayList<String> = arrayListOf()

    val listOfKeys: MutableList<String> = mutableListOf()
    for (i in mapa.keys) {
        listOfKeys.add(i)
    }
    val randomList: MutableList<String> = listOfKeys.toMutableList()
    shuffle(randomList)

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
        val questionKeyFullList = questionOnTableList[inputedNumberFromTable - 1]
        println("Вопрос: ${questionFullList[questionKeyFullList]}")
        println("Ответы игроков:")
        val answerList = mutableListOf<Int>()
//        var answerMatr = mutableListOf<>()
        when (questionKeyFullList) {
            1 -> {
                answerList.add(getSumLeft3(player1, mapa))
                answerList.add(getSumLeft3(player2, mapa))
                answerList.add(getSumLeft3(player3, mapa))
                answerList.add(getSumLeft3(player4, mapa))
                println("Игрок 1: Сумма левых трех: ${answerList[0]}")
                println("Игрок 2: Сумма левых трех: ${answerList[1]}")
                println("Игрок 3: Сумма левых трех: ${answerList[2]}")
                println("Игрок 4: Сумма левых трех: ${answerList[3]}")
                println(answerList)
            }
            2 -> {
                answerList.add(getSumRight3(player1, mapa))
                answerList.add(getSumRight3(player2, mapa))
                answerList.add(getSumRight3(player3, mapa))
                answerList.add(getSumRight3(player4, mapa))
                println("Игрок 1: Сумма правых трех: ${answerList[0]}")
                println("Игрок 2: Сумма правых трех: ${answerList[1]}")
                println("Игрок 3: Сумма правых трех: ${answerList[2]}")
                println("Игрок 4: Сумма правых трех: ${answerList[3]}")
            }
            3 -> {
                answerList.add(getPlace8(player1, mapa))
                answerList.add(getPlace8(player2, mapa))
                answerList.add(getPlace8(player3, mapa))
                answerList.add(getPlace8(player4, mapa))
                println("Игрок 1: На каком месте цифра #8: ${answerList[0]}")
                println("Игрок 2: На каком месте цифра #8: ${answerList[1]}")
                println("Игрок 3: На каком месте цифра #8: ${answerList[2]}")
                println("Игрок 4: На каком месте цифра #8: ${answerList[3]}")
            }

//            3 -> {
//                println("Игрок 1: Сумма центральных: ${getSumCentr(player1, mapa)}")
//                println("Игрок 2: Сумма центральных: ${getSumCentr(player2, mapa)}")
//                println("Игрок 3: Сумма центральных: ${getSumCentr(player3, mapa)}")
//                println("Игрок 4: Сумма центральных: ${getSumCentr(player4, mapa)}")
//            }
//            4 -> {
//                println("Игрок 1: Сумма всех чисел: ${getSum(player1, mapa)}")
//                println("Игрок 2: Сумма всех чисел: ${getSum(player2, mapa)}")
//                println("Игрок 3: Сумма всех чисел: ${getSum(player3, mapa)}")
//                println("Игрок 4: Сумма всех чисел: ${getSum(player4, mapa)}")
//            }
//            5 -> {
//                println("Игрок 1: Сумма всех четных: ${getEvenSumm(player1, mapa)}")
//                println("Игрок 2: Сумма всех четных: ${getEvenSumm(player2, mapa)}")
//                println("Игрок 3: Сумма всех четных: ${getEvenSumm(player3, mapa)}")
//                println("Игрок 4: Сумма всех четных: ${getEvenSumm(player4, mapa)}")
//            }
//            6 -> {
//                println("Игрок 1: Количество нечетных чисел: ${getUnevenCount(player1, mapa)}")
//                println("Игрок 2: Количество нечетных чисел: ${getUnevenCount(player2, mapa)}")
//                println("Игрок 3: Количество нечетных чисел: ${getUnevenCount(player3, mapa)}")
//                println("Игрок 4: Количество нечетных чисел: ${getUnevenCount(player4, mapa)}")
//            }
//            7 -> {
//                println("Игрок 1: Количество черных: ${getBlackCount(player1, mapa)}")
//                println("Игрок 2: Количество черных: ${getBlackCount(player2, mapa)}")
//                println("Игрок 3: Количество черных: ${getBlackCount(player3, mapa)}")
//                println("Игрок 4: Количество черных: ${getBlackCount(player4, mapa)}")
//            }
//            8 -> {
//                println("Игрок 1: Сумма чисел на белых жетонах: ${getWhiteSumm(player1, mapa)}")
//                println("Игрок 2: Сумма чисел на белых жетонах: ${getWhiteSumm(player2, mapa)}")
//                println("Игрок 3: Сумма чисел на белых жетонах: ${getWhiteSumm(player3, mapa)}")
//                println("Игрок 4: Сумма чисел на белых жетонах: ${getWhiteSumm(player4, mapa)}")
//            }
            4 -> {
                answerList.add(getSumLeft3(player1, mapa))
                answerList.add(getSumLeft3(player2, mapa))
                answerList.add(getSumLeft3(player3, mapa))
                answerList.add(getSumLeft3(player4, mapa))
                println("Игрок 1: Сумма левых трех: ${answerList[0]}")
                println("Игрок 2: Сумма левых трех: ${answerList[1]}")
                println("Игрок 3: Сумма левых трех: ${answerList[2]}")
                println("Игрок 4: Сумма левых трех: ${answerList[3]}")
                println(answerList)
            }
        }

        calculation(player2, mapa, questionKeyFullList, answerList, indexA, indexB, indexC, indexD)

        questionOnTableList.removeAt(inputedNumberFromTable - 1)

        if (questionNumberFullList.isNotEmpty()) {
            questionOnTableList.add(questionNumberFullList[0])
            questionNumberFullList.removeAt(0)
        }
        println(questionFullList)
        println(questionOnTableList)
        println(questionNumberFullList)
        println()
        println("Готовы ли Вы взломать код? [y/n]")
        var areYouReady: String? = null
        while (areYouReady == null) {
            input = readlnOrNull()
            areYouReady = try {
                input?.toString()
            } catch (e: NumberFormatException) {
                println("Некорректный ввод. Попробуйте еще раз")
                null
            }
            if (areYouReady != "y" && areYouReady != "n") {
                println("Нужно выбрать [y/n]")
                areYouReady = null
            } else if (areYouReady == "y") {
                println("Введите ответ отдельными значениями через ENTER")
                val answer: ArrayList<String> = arrayListOf()
                for (k in 0..3) {
                    input = readLine()
                    if (input != null) {
                        answer.add(input)
                    }
                }
                if (answer == playerKOD) {
                    println(answer)
                    println("ВЫ ПОБЕДИЛИ!!!")
                    return
                } else println("Нет, не верно!")
            }
        }
    }
}

fun calculation(
    player: ArrayList<String>,
    mapa: MutableMap<String, Int>,
    questionKeyFullList: Int,
    answerList: MutableList<Int>,
    indexA: ArrayList<Int>,
    indexB: ArrayList<Int>,
    indexC: ArrayList<Int>,
    indexD: ArrayList<Int>
) {

    player.forEach { key ->
        mapa.remove(key)
    }
    println("список нераспределенных значений")
    println(mapa)

    indexA.removeIf { element -> !mapa.containsValue(element) }
    indexB.removeIf { element -> !mapa.containsValue(element) }
    indexC.removeIf { element -> !mapa.containsValue(element) }
    indexD.removeIf { element -> !mapa.containsValue(element) }

    val player2: ArrayList<String> = player
    val player3: ArrayList<String> = arrayListOf("", "", "", "")
    val player4: ArrayList<String> = arrayListOf("", "", "", "")
    val playerKOD: ArrayList<String> = arrayListOf("", "", "", "")
    println("список для арифметического подсчета Игрока1")
    println(player1)

    when (questionKeyFullList) {
        1 -> {
            println("пришедшие ответы")
            println(answerList)

            val possibleSolutions = arrayListOf<Triple<Int, Int, Int>>()

            for (a in indexA) {
                for (b in indexB) {
                    for (c in indexC) {
                        if (b in a..c && a + b + c == answerList[0] && a != c) {
                            possibleSolutions.add(Triple(a, b, c))
                        }
                    }
                }
            }
            println("Возможные значения для A:")
            indexA.clear()
            indexA.addAll(possibleSolutions.map { it.first }.distinct().sorted())
            println(indexA)

            println("Возможные значения для B:")
            indexB.clear()
            indexB.addAll(possibleSolutions.map { it.second }.distinct().sorted())
            println(indexB)

            println("Возможные значения для C:")
            indexC.clear()
            indexC.addAll(possibleSolutions.map { it.third }.distinct().sorted())
            println(indexC)
        }
        2 -> {
            println("пришедшие ответы")
            println(answerList)

            val possibleSolutions = arrayListOf<Triple<Int, Int, Int>>()

            for (b in indexB) {
                for (c in indexC) {
                    for (d in indexD) {
                        if (c in b..d && b + c + d == answerList[0] && b != d) {
                            possibleSolutions.add(Triple(b, c, d))
                        }
                    }
                }
            }

            println("Возможные значения для B:")
            indexB.clear()
            indexB.addAll(possibleSolutions.map { it.first }.distinct().sorted())
            println(indexB)

            println("Возможные значения для C:")
            indexC.clear()
            indexC.addAll(possibleSolutions.map { it.second }.distinct().sorted())
            println(indexC)

            println("Возможные значения для D:")
            indexD.clear()
            indexD.addAll(possibleSolutions.map { it.third }.distinct().sorted())
            println(indexD)
        }
        3 -> {
            println("пришедшие ответы")
            println(answerList)

            val possibleSolutions = arrayListOf<Triple<Int, Int, Int>>()

            for (i in 0..3) {
                when (answerList[i]) {
                    1 -> {
                        indexA.clear()
                        indexA.add(8)
                    }
                    2 -> {
                        indexB.clear()
                        indexB.add(8)
                    }
                    3 -> {
                        indexC.clear()
                        indexC.add(8)
                    }
                    4 -> {
                        indexD.clear()
                        indexD.add(8)
                    }
                }
            }
        }
        4 -> {
            println("пришедшие ответы")
            println(answerList)

            val possibleSolutions = arrayListOf<Triple<Int, Int, Int>>()

            for (a in indexA) {
                for (b in indexB) {
                    for (c in indexC) {
                        if (b in a..c && a + b + c == answerList[0] && a != c) {
                            possibleSolutions.add(Triple(a, b, c))
                        }
                    }
                }
            }
            println("Возможные значения для A:")
            indexA.clear()
            indexA.addAll(possibleSolutions.map { it.first }.distinct().sorted())
            println(indexA)

            println("Возможные значения для B:")
            indexB.clear()
            indexB.addAll(possibleSolutions.map { it.second }.distinct().sorted())
            println(indexB)

            println("Возможные значения для C:")
            indexC.clear()
            indexC.addAll(possibleSolutions.map { it.third }.distinct().sorted())
            println(indexC)
        }
    }

    indexA.removeIf { element -> !mapa.containsValue(element) }
    indexB.removeIf { element -> !mapa.containsValue(element) }
    indexC.removeIf { element -> !mapa.containsValue(element) }
    indexD.removeIf { element -> !mapa.containsValue(element) }
    println("список после вопроса")
    println(player1)
    println(indexA)
    println(indexB)
    println(indexC)
    println(indexD)


}
