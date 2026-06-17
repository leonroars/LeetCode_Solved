import kotlin.math.*

class Solution {
    fun titleToNumber(columnTitle: String): Int {
        var accum = 0
        for(i in 0..columnTitle.length - 1){
            val digit = (columnTitle.length - 1) - i
            val currentNum
             = (getMappedNumericValueFromAlphabet(columnTitle.get(i))) * 26.0.pow(digit).toInt()
            accum += currentNum
        }

        return accum
    }

    fun getMappedNumericValueFromAlphabet(alphabet: Char) : Int {
        return alphabet.code - 64
    }
}