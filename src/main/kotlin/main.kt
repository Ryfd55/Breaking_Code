import java.util.Collections.shuffle


fun main() {
    val questionFullList: MutableList<String> =
        mutableListOf(
            "Какова сумма чисел на трех ваших левых жетонах",
            "Какова сумма чисел на трех ваших правых жетонах",
            "Какова сумма чисел на центральных жетонах",
            "Какова сумма чисел на всех ваших жетонах",
            "Сумма всех четных",
            "Количество жетонов с нечетными числами",
            "Количество черных жетонов",
            "Сумма чисел на белых жетонах",
            "На каком месте цифра #8"
        )
    val questionCount = questionFullList.count()
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
//    println("Вся мапа")
//    println(list)

    val listOfKeys: MutableList<String> = mutableListOf()
    for (i in mapa.keys) {
        listOfKeys.add(i)
    }
//    println("Список ключей")
//    println(listOfKeys)

    val randomList: MutableList<String> = listOfKeys.toMutableList()
    shuffle(randomList)
//    println("Перемешанный список ключей")
//    println(randomList)

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

    shuffle(questionFullList)
//    println("Перемешанный список вопросов")
//    println(questionFullList)

    val questionOnTableList: MutableList<String> = mutableListOf()
    for (i in 0..2) {
        questionOnTableList.add(questionFullList[0])
        questionFullList.removeAt(0)
    }
//    println(questionFullList)
    var input: String? = null

    for (i in 0..8) {
        println()
        println("Выберите номер вопроса")
        for (i in 1..3) {
            println("$i. ${questionOnTableList[i - 1]}")
        }
        var questionNumber: Int? = null
        while (questionNumber == null) {
//            println("Выберите номер вопроса")
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
        println("Вопрос: ${questionOnTableList[questionNumber - 1]}")
        println("Ответы игроков:")
        when (questionOnTableList[questionNumber - 1]) {
            "Какова сумма чисел на трех ваших левых жетонах" -> {
                println("Игрок 2: Сумма левых трех: ${getSumLeft3(player2, mapa)}")
                println("Игрок 3: Сумма левых трех: ${getSumLeft3(player3, mapa)}")
                println("Игрок 4: Сумма левых трех: ${getSumLeft3(player4, mapa)}")
            }
            "Какова сумма чисел на трех ваших правых жетонах" -> {
                println("Игрок 2: Сумма правых трех: ${getSumRight3(player2, mapa)}")
                println("Игрок 3: Сумма правых трех: ${getSumRight3(player3, mapa)}")
                println("Игрок 4: Сумма правых трех: ${getSumRight3(player4, mapa)}")
            }
            "Какова сумма чисел на центральных жетонах" -> {
                println("Игрок 2: Сумма центральных: ${getSumCentr(player2, mapa)}")
                println("Игрок 3: Сумма центральных: ${getSumCentr(player3, mapa)}")
                println("Игрок 4: Сумма центральных: ${getSumCentr(player4, mapa)}")
            }
            "Какова сумма чисел на всех ваших жетонах" -> {
                println("Игрок 2: Сумма всех чисел: ${getSum(player2, mapa)}")
                println("Игрок 3: Сумма всех чисел: ${getSum(player3, mapa)}")
                println("Игрок 4: Сумма всех чисел: ${getSum(player4, mapa)}")
            }
            "Сумма всех четных" -> {
                println("Игрок 2: Сумма всех четных: ${getEvenSumm(player2, mapa)}")
                println("Игрок 3: Сумма всех четных: ${getEvenSumm(player3, mapa)}")
                println("Игрок 4: Сумма всех четных: ${getEvenSumm(player4, mapa)}")
            }
            "Количество жетонов с нечетными числами" -> {
                println("Игрок 2: Количество нечетных чисел: ${getUnevenCount(player2, mapa)}")
                println("Игрок 3: Количество нечетных чисел: ${getUnevenCount(player3, mapa)}")
                println("Игрок 4: Количество нечетных чисел: ${getUnevenCount(player4, mapa)}")
            }
            "Количество черных жетонов" -> {
                println("Игрок 2: Количество черных: ${getBlackCount(player2, mapa)}")
                println("Игрок 3: Количество черных: ${getBlackCount(player3, mapa)}")
                println("Игрок 4: Количество черных: ${getBlackCount(player4, mapa)}")
            }
            "Сумма чисел на белых жетонах" -> {
                println("Игрок 2: Сумма чисел на белых жетонах: ${getWhiteSumm(player2, mapa)}")
                println("Игрок 3: Сумма чисел на белых жетонах: ${getWhiteSumm(player3, mapa)}")
                println("Игрок 4: Сумма чисел на белых жетонах: ${getWhiteSumm(player4, mapa)}")
            }
            "На каком месте цифра #8" -> {
                println("Игрок 2: На каком месте цифра #8: ${getPlace8(player2, mapa)}")
                println("Игрок 3: На каком месте цифра #8: ${getPlace8(player3, mapa)}")
                println("Игрок 4: На каком месте цифра #8: ${getPlace8(player4, mapa)}")
            }
        }
        questionOnTableList.removeAt(questionNumber - 1)

        if (questionFullList.isNotEmpty()) {
            questionOnTableList.add(questionFullList[0])
            questionFullList.removeAt(0)
        }
    }
}

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