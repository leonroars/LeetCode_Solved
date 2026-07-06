class Solution {
    
    val combination = mutableListOf<List<Int>> ()

    fun subsets(nums: IntArray): List<List<Int>> {
        for(i in 0..nums.size){findSubset(i, -1, mutableListOf(), HashSet<Int>(), nums)}

        return combination
    }

    private fun findSubset(
        targetDepth: Int,
        lastIndex: Int,
      currentSet: List<Int>,
       used: HashSet<Int>,
        nums: IntArray)
    {
        // Base Case
        if(currentSet.size == targetDepth) {
            combination.add(currentSet)
            return
        }

        // General Case
        for(i in lastIndex + 1..<nums.size){
            // only if the number has not been selected
            if(!used.contains(nums[i])){
                used.add(nums[i]) // Visit the number

                // list + item -> Kotlin creates new instance with newly added item.
                findSubset(targetDepth, i, currentSet + nums[i], used, nums)
                used.remove(nums[i]) // Unvisit the number
            }
        }
    }
}