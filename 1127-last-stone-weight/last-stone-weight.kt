import java.util.Collections

class Solution {
    val rockPouch = PriorityQueue<Int>(Collections.reverseOrder())

    fun lastStoneWeight(stones: IntArray): Int {
        // init
        for(stone in stones){rockPouch.offer(stone)}

        // Play game
        while(rockPouch.size > 1){
            val first = rockPouch.poll()
            val second = rockPouch.poll()

            if(first != second){
                val newRock = Math.max(first, second) - Math.min(first, second)
                rockPouch.offer(newRock)
            }
        }

        if(rockPouch.size == 0) return 0
        return rockPouch.poll()
    }
}