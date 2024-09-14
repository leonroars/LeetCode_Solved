/*

 */


class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double maxAvg = -Double.MAX_VALUE;
        boolean isAvgCalculated = false;
        double currentAvg = 0;
        int currentSum = 0;
        
        for(int i = 0; i+k-1 < nums.length; i++){
            if(!isAvgCalculated){
                for(int j = i; j < i + k; j++){
                    currentSum += nums[j];
                }
                currentAvg = (double) ((double)currentSum / (double)k);
                if(currentAvg > maxAvg){maxAvg = currentAvg;}
                isAvgCalculated = true;
            }
            else {
                currentSum = currentSum - nums[i-1] + nums[i+k-1];
                currentAvg = (double) ((double)currentSum / (double)k);
                if(currentAvg > maxAvg){maxAvg = currentAvg;}
            }
        }
        System.out.println(currentSum);
        return maxAvg;
        
    }
}