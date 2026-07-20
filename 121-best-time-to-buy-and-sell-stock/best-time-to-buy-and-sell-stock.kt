class Solution {
    fun maxProfit(prices: IntArray): Int {
        var minByFar = prices[0]
        var maxSurplus = 0

        for(i in 1..<prices.size){
            if(prices[i] < minByFar) {minByFar = prices[i]}
            else {
                val diff = prices[i] - minByFar
                if(maxSurplus < diff){maxSurplus = diff}
            }
        }

        return maxSurplus
    }
}