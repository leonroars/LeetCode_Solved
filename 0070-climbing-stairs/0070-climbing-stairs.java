class Solution {
    public int climbStairs(int n) {
        // This problem is making 'n' using only '1' and '2'.
        int[] dp = new int[n + 1];
        
        for(int i = 1; i < n + 1; i++){
            if(i < 3){dp[i] = i;}
            else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        
        return dp[n];
        
    }
}