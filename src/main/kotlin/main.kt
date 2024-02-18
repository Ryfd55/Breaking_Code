import java.util.*
import java.util.Collections.shuffle
import kotlin.collections.ArrayList

class Player(var tokens: List<String>)

var indexA: ArrayList<Int> = arrayListOf(0, 1, 2, 3, 4, 5, 6, 7, 8)
var indexB: ArrayList<Int> = arrayListOf(0, 1, 2, 3, 4, 5, 6, 7, 8)
var indexC: ArrayList<Int> = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
var indexD: ArrayList<Int> = arrayListOf(1, 2, 3, 4, 5, 6, 7, 8, 9)
var player1Indexes: ArrayList<ArrayList<Int>> = arrayListOf(indexA, indexB, indexC, indexD)
const val numberOfCardsOnTheTable = 4


fun main() {
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
            "0b" to 0, "0w" to 0,
            "1b" to 1, "1w" to 1,
            "2b" to 2, "2w" to 2,
            "3b" to 3, "3w" to 3,
            "4b" to 4, "4w" to 4,
            "5b" to 5, "5w" to 5,
            "6b" to 6, "6w" to 6,
            "7b" to 7, "7w" to 7,
            "8b" to 8, "8w" to 8,
            "9b" to 9, "9w" to 9
        )
    val game = Game( questionFullList, mapa)
    game.start()
}







