class Solution {
    private Boolean[][] isPossible; // Boxed boolean array so that we can tell the difference between 'not visied' and 'false'
    private int[] seq;
    
    public boolean canPartition(int[] nums) {
        seq = nums;
        int sum = 0;
        
        for(int num : nums){sum += num;} // Get total sum.
        // Case I : total sum is odd number : Can be divided into equal sum subset.
        
        if(sum % 2 != 0){return false;}
        
        int halfSum = sum / 2;
        
        // isPossible[i][j] : There is a equal sum subset when we reached i with j left till halfSum.
        isPossible = new Boolean[nums.length][halfSum + 1];
        
        return canPartition(0, halfSum);
        
    }
    
    private boolean canPartition(int idx, int left){
                
        // Base Case : Found.
        if(left == 0){
            return true;
        }
        
        // Base Case : Answer Doesn't Exist.
        if(idx == isPossible.length || left < 0){
            return false;
        }
        
        // Base Case : Pre-calcualted.
        if(isPossible[idx][left] != null){return isPossible[idx][left];}
        
        
        boolean currentResult = canPartition(idx + 1, left - seq[idx]) || canPartition(idx + 1, left);
        isPossible[idx][left] = currentResult;
        
        return currentResult;
    }
}