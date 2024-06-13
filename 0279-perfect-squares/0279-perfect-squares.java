class Solution {
    static int[] squares;
    static int[] dp;
    
    public int numSquares(int n) {
        squares = new int[101]; // squares[i] = i^2;
        dp = new int[n + 1]; // dp[i] = 'The least number of perfect square numbers that sum to i'.
        
        // Storing perfect square numbers.
        for(int i = 1; i < 101; i++){
            squares[i] = i * i;
        }
        
        return findingAns(n);
        
    }
    
    // Recursion method here.
    private int findingAns(int n) {
        // Base Case A : Given n is perfect square number.
        if(isPSN(n)){return dp[n] = 1;}
        // Base Case B : Given n is under 4, which is pre-stored in memoization array.
        if(n < 4){return dp[n] = n;}
        
        // Main logic
        if(dp[n] != 0){return dp[n];}
        else{
            int min = Integer.MAX_VALUE;
            for(int i = 1; squares[i] < n; i++){
                int current = 1 + findingAns(n - squares[i]);
                if(current < min){min = current;}
            }
            return dp[n] = min;
        }
    }
    
    // Returns true if given integer n is perfect square number.
    private boolean isPSN(int n){
        if(Math.floor(Math.sqrt(n)) == Math.sqrt(n)){return true;}
        return false;
    }
}