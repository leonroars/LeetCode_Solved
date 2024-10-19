class Solution {
    
    public int longestCommonSubsequence(String text1, String text2) {
        // lcs[i][j] = The length of LCS between the first 'i' letters of text1 & j letters of text2.
        int[][] lcs = new int[text1.length() + 1][text2.length() + 1];
        
        for(int i = 0; i < text1.length() + 1; i++){
            for(int j = 0; j < text2.length() + 1; j++){
                // Edge Case : Comparing with empty string always produces 0-length of LCS.
                if(i == 0 || j == 0){lcs[i][j] = 0;}
                
                // Case I : LCS(i, j) = LCS(i - 1, j - 1) + 1 when i-th letter of text1 is eqaul to j-th of text2.
                else if(text1.charAt(i - 1) == text2.charAt(j - 1)){
                    lcs[i][j] = lcs[i-1][j-1] + 1;
                }
                // Case II : LCS(i, j) = max(LCS(i-1, j), LCS(i, j-1)) if i-th letter is not equal to j-th of text2.
                else{
                    lcs[i][j] = Math.max(lcs[i - 1][j], lcs[i][j-1]);
                }
            }
        }
        
        return lcs[text1.length()][text2.length()];
    }
    
}