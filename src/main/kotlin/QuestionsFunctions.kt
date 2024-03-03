fun getSumLeft3(player: ArrayList<String>, mapa: MutableMap<String, Int>): Int {
    var sumLeft3 = 0
    for (i in 0..2) {
        val nextNum = mapa[player[i]]
        if (nextNum != null) {
            sumLeft3 += nextNum
        }
    }
    return sumLeft3
}

fun getSumRight3(player: ArrayList<String>, mapa: MutableMap<String, Int>): Int {
    var sumRight3 = 0
    for (i in 1..3) {
        val nextNum = mapa[player[i]]
        if (nextNum != null) {
            sumRight3 += nextNum
        }
    }
    return sumRight3
}

fun getPlace8(player: ArrayList<String>, mapa: MutableMap<String, Int>): Int {
    val listPlace: ArrayList<Int> = arrayListOf()
    var listPlace1 = 0
    for (i in 0..3) {
        val nextNum = mapa[player[i]]
        if (nextNum != null && player[i].contains("8")) {
            listPlace.add(i + 1)
        }
    }
    println(listPlace1)
    println(1111)
    println(listPlace)
    println(2222)
    listPlace1 = when (listPlace.size){
        1-> listPlace[0]
        2-> listPlace[0] + listPlace[1]*10
        else -> 0
    }

    println(listPlace1)
    println(33333)
    return listPlace1
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

