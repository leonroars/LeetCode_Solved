
/*
 LPS(i, j) - true (if i == j).
           - (i == j)
           - (i == j) && LPS(i + 1, j - 1);
 */


class Solution {
    public String longestPalindrome(String s) {
        
        boolean[][] dp = new boolean[s.length()][s.length()]; // dp[i][j] : Is s.substring(i, j + 1) palindrome?
        
        String answer = "";
        int len = -Integer.MAX_VALUE; //
        
        
        // Time Complexity : O(N ^ 2)
        for(int window = 0; window < s.length(); window++){
            for(int locator = 0; locator + window < s.length(); locator++){
                if(window == 0){
                    dp[locator][locator] = true;
                    if(answer.isBlank()){answer = Character.toString(s.charAt(locator)); len = 1;}
                }
                else if(window == 1){
                    if(s.charAt(locator) == s.charAt(locator + window)){
                        dp[locator][locator + window] = true;
                        if(window + 1> len){len = window + 1; answer = s.substring(locator, locator + window + 1);}
                    }
                }
                else {
                    if((s.charAt(locator) == s.charAt(locator + window)) && dp[locator + 1][locator + window - 1]){
                        dp[locator][locator + window] = true;
                        if(window + 1 > len){len = window + 1; answer = s.substring(locator, locator + window + 1);}
                    }
                }
            }
        }
        
        return answer;
    }
}