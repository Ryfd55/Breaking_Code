fun getAnswer1(
    answerList: MutableList<Int>,
    questionKeyFullList: Int,
    player1: ArrayList<String>,
    player2: ArrayList<String>,
    player3: ArrayList<String>,
    player4: ArrayList<String>,
    mapa: MutableMap<String,Int>
) {
    answerList.add(getSumLeft3(player1, mapa))
    answerList.add(getSumLeft3(player2, mapa))
    answerList.add(getSumLeft3(player3, mapa))
    answerList.add(getSumLeft3(player4, mapa))
    println("Игрок 1: Сумма левых трех: ${answerList[0]}")
    println("Игрок 2: Сумма левых трех: ${answerList[1]}")
    println("Игрок 3: Сумма левых трех: ${answerList[2]}")
    println("Игрок 4: Сумма левых трех: ${answerList[3]}")
    println(answerList)
    return
}

fun getAnswer2(
    answerList: MutableList<Int>,
    questionKeyFullList: Int,
    player1: ArrayList<String>,
    player2: ArrayList<String>,
    player3: ArrayList<String>,
    player4: ArrayList<String>,
    mapa: MutableMap<String,Int>
) {
    answerList.add(getSumRight3(player1, mapa))
    answerList.add(getSumRight3(player2, mapa))
    answerList.add(getSumRight3(player3, mapa))
    answerList.add(getSumRight3(player4, mapa))
    println("Игрок 1: Сумма правых трех: ${answerList[0]}")
    println("Игрок 2: Сумма правых трех: ${answerList[1]}")
    println("Игрок 3: Сумма правых трех: ${answerList[2]}")
    println("Игрок 4: Сумма правых трех: ${answerList[3]}")
    println(answerList)
    return
}

fun getAnswer3(
    answerList8: MutableList<List<Int>>,
    questionKeyFullList: Int,
    player1: ArrayList<String>,
    player2: ArrayList<String>,
    player3: ArrayList<String>,
    player4: ArrayList<String>,
    mapa: MutableMap<String,Int>
) {
    answerList8.add(getPlace8(player1, mapa))
    answerList8.add(getPlace8(player2, mapa))
    answerList8.add(getPlace8(player3, mapa))
    answerList8.add(getPlace8(player4, mapa))
    println("Игрок 1: На каком месте цифра #8: ${answerList8[0]}")
    println("Игрок 2: На каком месте цифра #8: ${answerList8[1]}")
    println("Игрок 3: На каком месте цифра #8: ${answerList8[2]}")
    println("Игрок 4: На каком месте цифра #8: ${answerList8[3]}")
    println(answerList8)
    return
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