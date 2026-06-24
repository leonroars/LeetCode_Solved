import java.util.ArrayList;

class Solution {
    fun countPrimes(n: Int): Int {
        
        if(n == 0 || n == 1){return 0}
        
        val compositeNumbers = BooleanArray(n) // 0~N
        compositeNumbers[0] = true
        compositeNumbers[1] = true

        var i = 2
        while(i * i < n){
            if(!compositeNumbers[i]){
                var j = i * i
                while(j < n){
                    compositeNumbers[j] = true
                    j += i
                }
            }
            i++
        }

        var cnt = 0

        for(idx in 0..<n){
            if(!compositeNumbers[idx]){cnt++}
        }

        return cnt
    }
}