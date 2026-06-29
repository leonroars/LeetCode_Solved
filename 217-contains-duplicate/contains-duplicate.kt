class Solution {
    val set = HashSet<Int>()

    fun containsDuplicate(nums: IntArray): Boolean {
        var isDuplicated = false

        for(num in nums){
            if(!set.contains(num)){
                set.add(num)
            }
            else {
                isDuplicated = true
                break
            }
        }
        return isDuplicated
    }
}