fun getAnswer1(
    firstAnswerList: MutableList<Int>,
    player1: ArrayList<String>,
    player2: ArrayList<String>,
    player3: ArrayList<String>,
    player4: ArrayList<String>,
    mapa: MutableMap<String, Int>
) {
    firstAnswerList.add(getSumLeft3(player1, mapa))
    firstAnswerList.add(getSumLeft3(player2, mapa))
    firstAnswerList.add(getSumLeft3(player3, mapa))
    firstAnswerList.add(getSumLeft3(player4, mapa))
    println("Игрок 1: Сумма левых трех: ${firstAnswerList[1]}")
    println("Игрок 2: Сумма левых трех: ${firstAnswerList[2]}")
    println("Игрок 3: Сумма левых трех: ${firstAnswerList[3]}")
    println("Игрок 4: Сумма левых трех: ${firstAnswerList[4]}")
    println(firstAnswerList)
    return
}

fun getAnswer2(
    secondAnswerList: MutableList<Int>,
    player1: ArrayList<String>,
    player2: ArrayList<String>,
    player3: ArrayList<String>,
    player4: ArrayList<String>,
    mapa: MutableMap<String, Int>
) {
    secondAnswerList.add(getSumRight3(player1, mapa))
    secondAnswerList.add(getSumRight3(player2, mapa))
    secondAnswerList.add(getSumRight3(player3, mapa))
    secondAnswerList.add(getSumRight3(player4, mapa))
    println("Игрок 1: Сумма правых трех: ${secondAnswerList[1]}")
    println("Игрок 2: Сумма правых трех: ${secondAnswerList[2]}")
    println("Игрок 3: Сумма правых трех: ${secondAnswerList[3]}")
    println("Игрок 4: Сумма правых трех: ${secondAnswerList[4]}")
    println(secondAnswerList)
    return
}

fun getAnswer3(
    thirdAnswerList: MutableList<Int>,
    player1: ArrayList<String>,
    player2: ArrayList<String>,
    player3: ArrayList<String>,
    player4: ArrayList<String>,
    mapa: MutableMap<String, Int>
) {
//    answerList8.add()
    thirdAnswerList.add(getPlace8(player1, mapa))
    thirdAnswerList.add(getPlace8(player2, mapa))
    thirdAnswerList.add(getPlace8(player3, mapa))
    thirdAnswerList.add(getPlace8(player4, mapa))

    println("Игрок 1: На каком месте цифра #8: ${thirdAnswerList[0]}")
    println("Игрок 2: На каком месте цифра #8: ${thirdAnswerList[1]}")
    println("Игрок 3: На каком месте цифра #8: ${thirdAnswerList[2]}")
    println("Игрок 4: На каком месте цифра #8: ${thirdAnswerList[3]}")
    println(thirdAnswerList)
    return
}

fun getAnswer4(
    answerList: MutableList<Int>,
    player1: ArrayList<String>,
    player2: ArrayList<String>,
    player3: ArrayList<String>,
    player4: ArrayList<String>,
    mapa: MutableMap<String, Int>
) {
    answerList.add(getSum(player1, mapa))
    answerList.add(getSum(player2, mapa))
    answerList.add(getSum(player3, mapa))
    answerList.add(getSum(player4, mapa))
    println("Игрок 1: Сумма всех чисел: ${answerList[1]}")
    println("Игрок 2: Сумма всех чисел: ${answerList[2]}")
    println("Игрок 3: Сумма всех чисел: ${answerList[3]}")
    println("Игрок 4: Сумма всех чисел: ${answerList[4]}")
    println(answerList)
    return
}

fun getAnswer5(
    answerList: MutableList<Int>,
    player1: ArrayList<String>,
    player2: ArrayList<String>,
    player3: ArrayList<String>,
    player4: ArrayList<String>,
    mapa: MutableMap<String, Int>
) {
    answerList.add(getSumCentr(player1, mapa))
    answerList.add(getSumCentr(player2, mapa))
    answerList.add(getSumCentr(player3, mapa))
    answerList.add(getSumCentr(player4, mapa))
    println("Игрок 1: Сумма центральных: ${answerList[1]}")
    println("Игрок 2: Сумма центральных: ${answerList[2]}")
    println("Игрок 3: Сумма центральных: ${answerList[3]}")
    println("Игрок 4: Сумма центральных: ${answerList[4]}")
    println(answerList)
    return
}
fun getAnswer6(
    answerList: MutableList<Int>,
    player1: ArrayList<String>,
    player2: ArrayList<String>,
    player3: ArrayList<String>,
    player4: ArrayList<String>,
    mapa: MutableMap<String, Int>
) {
    answerList.add(getEvenSumm(player1, mapa))
    answerList.add(getEvenSumm(player2, mapa))
    answerList.add(getEvenSumm(player3, mapa))
    answerList.add(getEvenSumm(player4, mapa))
    println("Игрок 1: Сумма всех четных: ${answerList[1]}")
    println("Игрок 2: Сумма всех четных: ${answerList[2]}")
    println("Игрок 3: Сумма всех четных: ${answerList[3]}")
    println("Игрок 4: Сумма всех четных: ${answerList[4]}")
    println(answerList)
    return
}

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