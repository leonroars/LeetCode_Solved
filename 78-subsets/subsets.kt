class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {

        val numberOfCases = 1 shl nums.size
        val combination = mutableListOf<List<Int>>()

        // mask : combination of selected indices represented as integer value
        for(mask in 0..<numberOfCases) {
            // find out which index has been selected and make set from it.
            val currentSet = mutableListOf<Int>()

            for(i in 0..<nums.size){
                // i'th number has been selected
                if(mask and (1 shl i) != 0){currentSet.add(nums[i])}
            }
            combination.add(currentSet)
        }

        return combination
    }
}