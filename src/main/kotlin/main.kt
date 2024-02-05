import java.util.Collections.shuffle

fun main() {
    val list: MutableMap<String, Int> =
        mutableMapOf(
            "0ч" to 0,
            "0б" to 0,
            "1ч" to 1,
            "1б" to 1,
            "2ч" to 2,
            "2б" to 2,
            "3ч" to 3,
            "3б" to 3,
            "4ч" to 4,
            "4б" to 4,
            "5ч" to 5,
            "5б" to 5,
            "6ч" to 6,
            "6б" to 6,
            "7ч" to 7,
            "7б" to 7,
            "8ч" to 8,
            "8б" to 8,
            "9ч" to 9,
            "9б" to 9
        )
    val player1: ArrayList<String> = arrayListOf()
    val player2: ArrayList<String> = arrayListOf()
    val player3: ArrayList<String> = arrayListOf()
    val player4: ArrayList<String> = arrayListOf()
    val playerKOD: ArrayList<String> = arrayListOf()
    println(list)

    val listOfKeys: MutableList<String> = mutableListOf()
    for (i in list.keys) {
        listOfKeys.add(i)
    }
    println(listOfKeys)

    val randomList: MutableList<String> = listOfKeys.toMutableList()
    shuffle(randomList)
    println(randomList)

    do {
        player1.add(randomList[0])
        player2.add(randomList[1])
        player3.add(randomList[2])
        player4.add(randomList[3])
        playerKOD.add(randomList[4])
        for (i in 0..4) randomList.removeAt(0)
    } while (randomList.isNotEmpty())

    println(player1)
    println(player2)
    println(player3)
    println(player4)
    println(playerKOD)
}