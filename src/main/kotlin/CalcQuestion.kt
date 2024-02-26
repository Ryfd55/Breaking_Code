data class Quadruple<A, B, C, D>(val first: A, val second: B, val third: C, val fourth: D)

fun calcQuest1(answerList: MutableList<Int>) {
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
    indexA.clear()
    indexA.addAll(possibleSolutions.map { it.first }.distinct().sorted())

    indexB.clear()
    indexB.addAll(possibleSolutions.map { it.second }.distinct().sorted())

    indexC.clear()
    indexC.addAll(possibleSolutions.map { it.third }.distinct().sorted())
}

fun calcQuest2(answerList: MutableList<Int>) {
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
    indexB.clear()
    indexB.addAll(possibleSolutions.map { it.first }.distinct().sorted())

    indexC.clear()
    indexC.addAll(possibleSolutions.map { it.second }.distinct().sorted())

    indexD.clear()
    indexD.addAll(possibleSolutions.map { it.third }.distinct().sorted())
}

fun calcQuest3(answerList8: MutableList<List<Int>>) {
    if (answerList8[0].contains(1)) {
        indexA.clear()
        indexA.add(8)
        indexB.removeIf { it < 8 }
        indexC.removeIf { it < 8 }
        indexD.removeIf { it < 8 }
    }
    if (answerList8[0].contains(2)) {
        indexB.clear()
        indexB.add(8)
        indexA.removeIf { it > 8 }
        indexC.removeIf { it < 8 }
        indexD.removeIf { it < 8 }
    }
    if (answerList8[0].contains(3)) {
        indexC.clear()
        indexC.add(8)
        indexA.removeIf { it > 8 }
        indexB.removeIf { it > 8 }
        indexD.removeIf { it < 8 }
    }
    if (answerList8[0].contains(4)) {
        indexD.clear()
        indexD.add(8)
        indexA.removeIf { it > 8 }
        indexB.removeIf { it > 8 }
        indexC.removeIf { it > 8 }
    }
}

fun calcQuest4(answerList: MutableList<Int>) {
    val possibleSolutions = arrayListOf<Quadruple<Int, Int, Int, Int>>()

    for (a in indexA) {
        for (b in indexB) {
            for (c in indexC) {
                for (d in indexD) {
                    if (b in a..c && c in b..d && a + b + c + d == answerList[0] && b != d && a != c) {
                        possibleSolutions.add(Quadruple(a, b, c, d))
                    }
                }
            }
        }
    }
    indexA.clear()
    indexA.addAll(possibleSolutions.map { it.first }.distinct().sorted())

    indexB.clear()
    indexB.addAll(possibleSolutions.map { it.second }.distinct().sorted())

    indexC.clear()
    indexC.addAll(possibleSolutions.map { it.third }.distinct().sorted())

    indexD.clear()
    indexD.addAll(possibleSolutions.map { it.fourth }.distinct().sorted())
}

fun calcQuest5(answerList: MutableList<Int>) {
    val possibleSolutions = arrayListOf<Quadruple<Int, Int, Int, Int>>()

    for (a in indexA) {
        for (b in indexB) {
            for (c in indexC) {
                for (d in indexD) {
                    if (b in a..c && c in b..d && b + c == answerList[0] && b != d && a != c) {
                        possibleSolutions.add(Quadruple(a, b, c, d))
                    }
                }
            }
        }
    }
    indexA.clear()
    indexA.addAll(possibleSolutions.map { it.first }.distinct().sorted())

    indexB.clear()
    indexB.addAll(possibleSolutions.map { it.second }.distinct().sorted())

    indexC.clear()
    indexC.addAll(possibleSolutions.map { it.third }.distinct().sorted())

    indexD.clear()
    indexD.addAll(possibleSolutions.map { it.fourth }.distinct().sorted())
}

fun calcQuest6(answerList: MutableList<Int>) {
    val possibleSolutions = arrayListOf<Quadruple<Int, Int, Int, Int>>()
    var tempA: Int = 0
    var tempB: Int = 0
    var tempC: Int = 0
    var tempD: Int = 0
    for (a in indexA) {
        for (b in indexB) {
            for (c in indexC) {
                for (d in indexD) {
                    if (a % 2 == 0) tempA = a
                    if (b % 2 == 0) tempB = b
                    if (c % 2 == 0) tempC = c
                    if (d % 2 == 0) tempD = d
                    if (b in a..c && c in b..d && tempA + tempB + tempC + tempD == answerList[0] && b != d && a != c) {
                        possibleSolutions.add(Quadruple(a, b, c, d))
                    }
                }
            }
        }
    }
    indexA.clear()
    indexA.addAll(possibleSolutions.map { it.first }.distinct().sorted())

    indexB.clear()
    indexB.addAll(possibleSolutions.map { it.second }.distinct().sorted())

    indexC.clear()
    indexC.addAll(possibleSolutions.map { it.third }.distinct().sorted())

    indexD.clear()
    indexD.addAll(possibleSolutions.map { it.fourth }.distinct().sorted())
}