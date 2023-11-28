import java.util.Arrays;

class Solution {
    public int removeDuplicates(int[] nums) {
        // Initializing temporary array which will be used for stroing de-duplicated elements of `nums`.
        //int[] temp = new int[nums.length];
        int tempLocator = 0; // A locator initialized for indicating the index that element about to be inserted.
        int k = 0; // The number of unique elements of nums.

        /* As the problem requires assertion for every elements in given array, 
         *  the time complexity naturally requires at least O(n).
         * Thus my goal is not to exceed O(n^2).
         */

         for(int i = 0; i < nums.length;){
            nums[tempLocator] = nums[i]; // Adding element at the start of each main loop.
            tempLocator++;
            k++;
            int j = i + 1;

            if(j >= nums.length){break;}

            //Comparison. Process in bulk.
            while(nums[i] == nums[j]){
                j++;
                if(j >= nums.length){break;}
            }

            i = j;
        }

        return k;
    }
}