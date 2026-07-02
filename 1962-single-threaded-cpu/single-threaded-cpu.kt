class Solution {

    fun getOrder(tasks: Array<IntArray>): IntArray {
        
        // 0) Init PQ & List
        val availableQueue = PriorityQueue(compareBy<Task> {it.processingTime}.thenBy{it.index})

        val taskQueue = ArrayList<Task>()

        // 1) Move all the items from tasks -> taskQueue & sort them by enqueueTime
        for(i in 0..<tasks.size){
            taskQueue.add(Task(tasks[i][0], tasks[i][1], i))
        }

        val sortedTaskQueue = taskQueue.sortedBy {it.enqueueTime}

        // 2) Simulate
        var time = 0
        val processedTasks = ArrayList<Int>()

        var locator = 0

        while(locator < sortedTaskQueue.size){
            // Case I - No Available Task
            //          Condition : availableQueue Empty && (sortedTaskQueue.get(locator).enQTime > time)
            //          Action : Time Skip
            if(availableQueue.size == 0 && (sortedTaskQueue.get(locator).enqueueTime > time)){
                time = sortedTaskQueue.get(locator).enqueueTime
            }
            // Case II - There is at least one available task in either availableQueue or sortedTaskQueue, or Both.
            else {
                // Check if there's any task available from sortedTaskQueue
                while(locator < sortedTaskQueue.size
                         && time >= sortedTaskQueue.get(locator).enqueueTime)
                {
                    availableQueue.offer(sortedTaskQueue.get(locator++))
                }

                // Then get the most optimal task at the moment.
                // At this point, PQ can never be empty.
                val optimalTask = availableQueue.poll()
                time += optimalTask.processingTime
                processedTasks.add(optimalTask.index)
            }
        }

        // As we moved locator forward only if the task at that locator is available,
        // Every task left in availableQueue(PQ) is available after this loop ends.
        while(availableQueue.size > 0){
            processedTasks.add(availableQueue.poll().index)
        }
        
        return processedTasks.toIntArray()
    }
    
    class Task (val enqueueTime: Int, val processingTime: Int, val index: Int) {}
}