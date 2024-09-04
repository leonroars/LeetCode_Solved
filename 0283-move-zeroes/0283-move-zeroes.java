// <Main Idea> : Two pointers that behaves just like a bubble sort.

class Solution {
    public void moveZeroes(int[] nums) {
        int locA = 0;
        int locB = locA;
        
        while(locA < nums.length && locB < nums.length){
            if(nums[locA] == 0){
                while(locB < nums.length && nums[locB] == 0){
                    locB++;
                }
                if(locB < nums.length){
                    nums[locA] = nums[locB];
                    nums[locB] = 0;
                    locA ++;
                    locB = locA + 1;
                }
            }
            else {
                locA++;
                locB++;
            }
        }
    }
}