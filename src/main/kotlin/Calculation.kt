fun calculation(
    player: ArrayList<String>,
    mapa: MutableMap<String, Int>,
    questionKeyFullList: Int,
    answerListNew: MutableList<List<Int>>,
    indexA: ArrayList<Int>,
    indexB: ArrayList<Int>,
    indexC: ArrayList<Int>,
    indexD: ArrayList<Int>,
    usedQuestions: MutableList<Int>
) {
    player.forEach { key ->
        mapa.remove(key)
    }
    /** Предварительное распределение ДО вопросов*/
//    println("список нераспределенных значений")
//    println(mapa)


    indexA.removeIf { element -> !mapa.containsValue(element) }
    indexB.removeIf { element -> !mapa.containsValue(element) }
    indexC.removeIf { element -> !mapa.containsValue(element) }
    indexD.removeIf { element -> !mapa.containsValue(element) }


    println("список для арифметического подсчета Игрока1 за предыдущий ход")
    println(player1Indexes)

    /** Задаем вопросы  */
//    println("пришедшие ответы")
//    println(answerList)




    when (questionKeyFullList) {
        1 -> calcQuest(answerListNew)
        2 -> calcQuest(answerListNew)
        3 -> calcQuest(answerListNew)
        4 -> calcQuest(answerListNew)
        5 -> calcQuest(answerListNew)
        6 -> calcQuest(answerListNew)
    }




//    for (i in 0 until usedQuestions.size) {
//        if (usedQuestions[i] == 1) {
//            calcQuest1(answerList)
//            println(114)
//            indexA.removeIf { element -> !mapa.containsValue(element) }
//            indexB.removeIf { element -> !mapa.containsValue(element) }
//            indexC.removeIf { element -> !mapa.containsValue(element) }
//            indexD.removeIf { element -> !mapa.containsValue(element) }
//            println(player1Indexes)
//        }
//        if (usedQuestions[i] == 2) {
//            calcQuest2(answerList)
//            println(224)
//            indexA.removeIf { element -> !mapa.containsValue(element) }
//            indexB.removeIf { element -> !mapa.containsValue(element) }
//            indexC.removeIf { element -> !mapa.containsValue(element) }
//            indexD.removeIf { element -> !mapa.containsValue(element) }
//            println(player1Indexes)
//        }
//        if (usedQuestions[i] == 3) {
//            calcQuest3(answerList8)
//            println(334)
//            indexA.removeIf { element -> !mapa.containsValue(element) }
//            indexB.removeIf { element -> !mapa.containsValue(element) }
//            indexC.removeIf { element -> !mapa.containsValue(element) }
//            indexD.removeIf { element -> !mapa.containsValue(element) }
//            println(player1Indexes)
//        }
//        if (usedQuestions[i] == 4) {
//            calcQuest1(answerList)
//            println(444)
//            indexA.removeIf { element -> !mapa.containsValue(element) }
//            indexB.removeIf { element -> !mapa.containsValue(element) }
//            indexC.removeIf { element -> !mapa.containsValue(element) }
//            indexD.removeIf { element -> !mapa.containsValue(element) }
//            println(player1Indexes)
//        }
//    }

    indexA.removeIf { element -> !mapa.containsValue(element) }
    indexB.removeIf { element -> !mapa.containsValue(element) }
    indexC.removeIf { element -> !mapa.containsValue(element) }
    indexD.removeIf { element -> !mapa.containsValue(element) }

    println("возможные комбинации для первого игрока")
    println(player1Indexes)
//    println(indexA)
//    println(indexB)
//    println(indexC)
//    println(indexD)

    println(usedQuestions)


}

fun isReady(playerKOD: ArrayList<String>): String {
    var input: String?
    var areYouReady: String? = null
    println()
    println("Готовы ли Вы взломать код? [y/n]")
    while (areYouReady == null) {
        input = readlnOrNull()
        areYouReady = input.toString()
        if (areYouReady != "y" && areYouReady != "n") {
            println("Нужно выбрать [y/n]")
            areYouReady = null
        } else if (areYouReady == "y") {
            println("Введите ответ отдельными значениями через ENTER")
            val answer: ArrayList<String> = arrayListOf()
            for (k in 0..3) {
                input = readLine()
                if (input != null) answer.add(input)
            }
            if (answer == playerKOD) {
                println(answer)
                println("ВЫ ПОБЕДИЛИ!!!")
            } else println("Нет, не верно!")
        }
    }
    return areYouReady
}