class Solution {
    fun myAtoi(s: String): Int {
        
        var isSignOccured = false
        var isNegative = false
        var isDigitOccured = false
        var isEndReached = false

        val parsed = StringBuilder()
        var index = 0

        // 0) Parse & Filter
        while(s.length > 0 && !isEndReached && index < s.length){
            val c = s[index]

            // if digit : append.
            if(c.isDigit()){
                parsed.append(c)
                isDigitOccured = true
            }

            // if sign : Depends if the sign has already occured or not.
            else if(c == '-' || c == '+'){
                // redundant sign occurence : Consider it as non-digit character
                if(isSignOccured || isDigitOccured){
                    isEndReached = true
                }
                else {
                    isSignOccured = true
                    if(c == '-'){isNegative = true}
                }
            }

            // if non-digit & non-sign character : Check if it's whitespace or not
            else {
                if(c.isWhitespace()){
                    // non-leading whitespace : end
                    if(isDigitOccured || isSignOccured){isEndReached = true}
                }
                else {isEndReached = true}
            }
            index++
        }

        // 1) Check if it's proper number
        val parsedString = parsed.toString()

        // no digits were read -> return 0 (ex. "-" or "")
        if(parsedString.toBigIntegerOrNull() == null){
            print(parsedString)
            return 0
        }

        // at least it is number -> round & return
        var parsedNum = parsedString.toBigInteger()

        if(isNegative){parsedNum *= -1.toBigInteger()}

        // rounding
        if(parsedNum < Int.MIN_VALUE.toBigInteger()){return Int.MIN_VALUE}
        else if(parsedNum > Int.MAX_VALUE.toBigInteger()){return Int.MAX_VALUE}
        
        return parsedNum.toInt()
    }
}