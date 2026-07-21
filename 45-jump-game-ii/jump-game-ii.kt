/*

 State : minimum number of jumps from i to n-1
 Direction : From end to start.
 Answer: Optimal state at 0

 */

class Solution {
    fun jump(nums: IntArray): Int {
        val n = nums.size

        val dp = IntArray(n) {Int.MAX_VALUE / 2}


        for(i in n - 1 downTo 0){
            // Base Case : i == n-1
            if(i == n - 1){dp[i] = 0}

            // General Case I : Can move to 'n-1' directly
            else if(i + nums[i] >= n-1){dp[i] = 1}

            // General Case II : Cannot move to 'n-1' directly -> optimal detour path
            else {
                var minJumpCnt = Int.MAX_VALUE
                for(j in 0..nums[i]) {
                    if(i + j < n){
                        dp[i] = min(dp[i], dp[i + j] + 1)
                    }
                    else {break}
                }
            }
        }

        for(c in 0..<n){println(dp[c])}
        
        return dp[0]
    }
}