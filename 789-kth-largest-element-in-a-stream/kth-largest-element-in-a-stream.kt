class KthLargest(k: Int, nums: IntArray) {

    var kth: Int = 1
    val k: Int = k
    val pq: PriorityQueue<Int> = PriorityQueue<Int>()

    init {
        if(nums.size > 0){
            for(i in 0..<nums.size){
                pq.offer(nums[i])
            }

            while(pq.size > k){pq.poll()}
        }

        if(pq.size == k){
            this.kth = pq.peek()
        }
    }

    fun add(`val`: Int): Int {
        pq.offer(`val`)
        while(pq.size > this.k){pq.poll()}
        this.kth = pq.peek()
        return this.kth
    }

}

/**
 * Your KthLargest object will be instantiated and called as such:
 * var obj = KthLargest(k, nums)
 * var param_1 = obj.add(`val`)
 */