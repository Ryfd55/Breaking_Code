import java.util.*
import java.util.Collections.shuffle
import kotlin.collections.ArrayList


fun main() {
    val questionFullList: MutableMap<Int, String> =
        mutableMapOf(
           1 to "Какова сумма чисел на трех ваших левых жетонах",
            2 to "Какова сумма чисел на трех ваших правых жетонах",
            3 to  "Какова сумма чисел на центральных жетонах",
            4 to  "Какова сумма чисел на всех ваших жетонах",
            5 to  "Сумма всех четных",
            6 to  "Количество жетонов с нечетными числами",
            7 to   "Количество черных жетонов",
            8 to   "Сумма чисел на белых жетонах",
            9 to   "На каком месте цифра #8"
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

//    shuffle(1 to 10)

    val random = Random()
    val questionNumberFullList = (1..9).toMutableList().shuffled(random).toMutableList()

    val questionOnTableList: MutableList<Int> = mutableListOf()
    for (i in 0..2) {
        questionOnTableList.add(questionNumberFullList[0])
        questionNumberFullList.removeAt(0)
    }
    var input: String?



    for (i in 0..8) {
        println()
        println("Выберите номер вопроса")
        for (j in 1..3) {
            println("$j. ${questionFullList[questionOnTableList[i - 1]]}")
        }
        var questionNumber: Int? = null
        while (questionNumber == null) {
            input = readlnOrNull()
            questionNumber = try {
                input?.toInt()
            } catch (e: NumberFormatException) {
                println("Некорректный ввод. Попробуйте еще раз")
                null
            }
            if (questionNumber != null) {
                if (questionNumber <= 0 || questionNumber > 3 || questionNumber > questionOnTableList.size) {
                    println("Нужно выбрать один из имеющихся вопросов")
                    questionNumber = null
                }
            }
        }
        println("Вопрос: ${questionFullList[questionOnTableList[i]]}")
        println("Ответы игроков:")
        when (questionOnTableList[questionNumber - 1]) {
            1 -> {
                println("Игрок 1: Сумма левых трех: ${getSumLeft3(player1, mapa)}")
                println("Игрок 2: Сумма левых трех: ${getSumLeft3(player2, mapa)}")
                println("Игрок 3: Сумма левых трех: ${getSumLeft3(player3, mapa)}")
                println("Игрок 4: Сумма левых трех: ${getSumLeft3(player4, mapa)}")
            }
            2 -> {
                println("Игрок 1: Сумма правых трех: ${getSumRight3(player1, mapa)}")
                println("Игрок 2: Сумма правых трех: ${getSumRight3(player2, mapa)}")
                println("Игрок 3: Сумма правых трех: ${getSumRight3(player3, mapa)}")
                println("Игрок 4: Сумма правых трех: ${getSumRight3(player4, mapa)}")
            }
            3 -> {
                println("Игрок 1: Сумма центральных: ${getSumCentr(player1, mapa)}")
                println("Игрок 2: Сумма центральных: ${getSumCentr(player2, mapa)}")
                println("Игрок 3: Сумма центральных: ${getSumCentr(player3, mapa)}")
                println("Игрок 4: Сумма центральных: ${getSumCentr(player4, mapa)}")
            }
            4 -> {
                println("Игрок 1: Сумма всех чисел: ${getSum(player1, mapa)}")
                println("Игрок 2: Сумма всех чисел: ${getSum(player2, mapa)}")
                println("Игрок 3: Сумма всех чисел: ${getSum(player3, mapa)}")
                println("Игрок 4: Сумма всех чисел: ${getSum(player4, mapa)}")
            }
            5 -> {
                println("Игрок 1: Сумма всех четных: ${getEvenSumm(player1, mapa)}")
                println("Игрок 2: Сумма всех четных: ${getEvenSumm(player2, mapa)}")
                println("Игрок 3: Сумма всех четных: ${getEvenSumm(player3, mapa)}")
                println("Игрок 4: Сумма всех четных: ${getEvenSumm(player4, mapa)}")
            }
            6 -> {
                println("Игрок 1: Количество нечетных чисел: ${getUnevenCount(player1, mapa)}")
                println("Игрок 2: Количество нечетных чисел: ${getUnevenCount(player2, mapa)}")
                println("Игрок 3: Количество нечетных чисел: ${getUnevenCount(player3, mapa)}")
                println("Игрок 4: Количество нечетных чисел: ${getUnevenCount(player4, mapa)}")
            }
            7 -> {
                println("Игрок 1: Количество черных: ${getBlackCount(player1, mapa)}")
                println("Игрок 2: Количество черных: ${getBlackCount(player2, mapa)}")
                println("Игрок 3: Количество черных: ${getBlackCount(player3, mapa)}")
                println("Игрок 4: Количество черных: ${getBlackCount(player4, mapa)}")
            }
            8 -> {
                println("Игрок 1: Сумма чисел на белых жетонах: ${getWhiteSumm(player1, mapa)}")
                println("Игрок 2: Сумма чисел на белых жетонах: ${getWhiteSumm(player2, mapa)}")
                println("Игрок 3: Сумма чисел на белых жетонах: ${getWhiteSumm(player3, mapa)}")
                println("Игрок 4: Сумма чисел на белых жетонах: ${getWhiteSumm(player4, mapa)}")
            }
            9 -> {
                println("Игрок 1: На каком месте цифра #8: ${getPlace8(player1, mapa)}")
                println("Игрок 2: На каком месте цифра #8: ${getPlace8(player2, mapa)}")
                println("Игрок 3: На каком месте цифра #8: ${getPlace8(player3, mapa)}")
                println("Игрок 4: На каком месте цифра #8: ${getPlace8(player4, mapa)}")
            }
        }

//        calculation(player2,mapa)
        questionOnTableList.removeAt(questionNumber - 1)

        if (questionFullList.isNotEmpty()) {
            questionOnTableList.add(questionNumberFullList[0])
            questionNumberFullList.removeAt(0)
        }
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
                println("Введите ответ в одну строку через запятую в фомате \"__, __, __, __\"")
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

//fun calculation(player: ArrayList<String>, mapa: MutableMap<String, Int>){
//    player.forEach { key ->
//        mapa.remove(key)
//    }
//    println(mapa)
//    val playerX: ArrayList<String> = arrayListOf("","","","")
//    val playerY: ArrayList<String> = arrayListOf("","","","")
//    val playerZ: ArrayList<String> = arrayListOf("","","","")
//    val playerKOD: ArrayList<String> = arrayListOf("","","","")
//    playerX[0] = "1b"
//    println(playerX)
//
//}

fun getSumLeft3(player: ArrayList<String>, mapa: MutableMap<String, Int>): Int {
    var sumLeft3 = 0
    for (i in 0..2) {
        val nextNum = mapa[player[i]]
        if (nextNum != null) {
            sumLeft3 += nextNum
        }
    }
    return (sumLeft3)
}

fun getSumRight3(player: ArrayList<String>, mapa: MutableMap<String, Int>): Int {
    var sumRight3 = 0
    for (i in 1..3) {
        val nextNum = mapa[player[i]]
        if (nextNum != null) {
            sumRight3 += nextNum
        }
    }
    return (sumRight3)
}

fun getSumCentr(player: ArrayList<String>, mapa: MutableMap<String, Int>): Int {
    var sumCentr = 0
    for (i in 1..2) {
        val nextNum = mapa[player[i]]
        if (nextNum != null) {
            sumCentr += nextNum
        }
    }
    return (sumCentr)
}

fun getSum(player: ArrayList<String>, mapa: MutableMap<String, Int>): Int {
    var sum = 0
    for (i in 0..3) {
        val nextNum = mapa[player[i]]
        if (nextNum != null) {
            sum += nextNum
        }
    }
    return (sum)
}

fun getEvenSumm(player: ArrayList<String>, mapa: MutableMap<String, Int>): Int {
    var evenSumm = 0
    for (i in 0..3) {
        val nextNum = mapa[player[i]]
        if (nextNum != null && nextNum % 2 == 0) {
            evenSumm += nextNum
        }
    }
    return (evenSumm)
}

fun getUnevenCount(player: ArrayList<String>, mapa: MutableMap<String, Int>): Int {
    var unevenCount = 0
    for (i in 0..3) {
        val nextNum = mapa[player[i]]
        if (nextNum != null && nextNum % 2 == 1) {
            unevenCount += 1
        }
    }
    return (unevenCount)
}

fun getBlackCount(player: ArrayList<String>, mapa: MutableMap<String, Int>): Int {
    var blackCount = 0
    for (i in 0..3) {
        val nextNum = mapa[player[i]]
        if (nextNum != null && player[i].contains("b")) {
            blackCount += 1
        }
    }
    return (blackCount)
}

fun getWhiteSumm(player: ArrayList<String>, mapa: MutableMap<String, Int>): Int {
    var whiteSumm = 0
    for (i in 0..3) {
        val nextNum = mapa[player[i]]
        if (nextNum != null && player[i].contains("w")) {
            whiteSumm += nextNum
        }
    }
    return (whiteSumm)
}

fun getPlace8(player: ArrayList<String>, mapa: MutableMap<String, Int>): String {
    var place = "отсутствует"
    for (i in 0..3) {
        val nextNum = mapa[player[i]]
        if (nextNum != null && player[i].contains("8")) {
            place = (i + 1).toString()
        }
    }
    return (place)
}
