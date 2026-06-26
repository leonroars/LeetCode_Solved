/*

 <Implementing queue with two stacks>
 - My Idea : Input Stack & Output Stack(Rev.) + Lazy Update
 */

class MyQueue() {

    val inStack: Stack<Int> = Stack<Int>()
    val outStack: Stack<Int> = Stack<Int>()

    fun push(x: Int) {
        inStack.push(x)
    }

    fun pop(): Int {
        // Case I : outStack is Empty -> Reverse & return
        if(outStack.size == 0){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop())
            }
        }

        return outStack.pop()
    }

    fun peek(): Int {
        if(outStack.size == 0){
            while(!inStack.isEmpty()){
                outStack.push(inStack.pop())
            }
        }
        return outStack.peek()
    }

    fun empty(): Boolean {
        return inStack.isEmpty() && outStack.isEmpty()
    }

}

/**
 * Your MyQueue object will be instantiated and called as such:
 * var obj = MyQueue()
 * obj.push(x)
 * var param_2 = obj.pop()
 * var param_3 = obj.peek()
 * var param_4 = obj.empty()
 */