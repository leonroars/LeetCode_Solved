// Solution : Using Stack - Compare current result with the one at the top of stack before pushing it.

class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        var locator = 0
        val stack = Stack<Int>()

        while(locator < asteroids.size){
            // Case I : Stack is empty -> Push
            if(stack.isEmpty()){stack.push(asteroids[locator++])}

            // Case II : Not Empty -> Compare
            else {
                // While collision exist -> Keep compare
                var tmp: Int? = asteroids[locator] // `null` can be assigned, by type inference.

                while(tmp != null && doTheyCollide(stack.peek(), tmp)){
                    tmp = simulateCollision(stack.pop(), tmp)
                    
                    if(tmp == null || stack.isEmpty()){break}
                }

                if(tmp != null){stack.push(tmp)}
                locator++
            }

        }

        return stack.toIntArray()
    }

    fun doTheyCollide(left: Int, right: Int) = left > 0 && right < 0

    fun simulateCollision(left: Int, right: Int) : Int? {
        if(abs(left) < abs(right)) {return right}
        else if(Math.abs(left) > Math.abs(right)) {return left}
        return null
    }
}