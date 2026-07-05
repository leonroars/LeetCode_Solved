// BFS

import java.util.ArrayDeque

class Solution {
    val dRow: IntArray = intArrayOf(-1, -1, 0, 1, 1, 1, 0, -1)
    val dCol: IntArray = intArrayOf(0, 1, 1, 1, 0, -1, -1, -1)
    
    fun shortestPathBinaryMatrix(grid: Array<IntArray>): Int {
        val n = grid.size

        // 0) Dist Matrix init
        val dist = Array(n) {IntArray(n) {Int.MAX_VALUE}}
        val visited = Array(n) {BooleanArray(n)}

        // 1) BFS Ready : Put source position into q
        val q: Queue<Position> = ArrayDeque<Position>()

        if(grid[0][0] == 0){
            q.offer(Position(0, 0, 1))
        }

        while(!q.isEmpty()){
            val current = q.poll()
            
            if(!visited[current.row][current.col]
             && grid[current.row][current.col] == 0)
             {
                visited[current.row][current.col] = true
                dist[current.row][current.col] = current.distFromSource

                for(d in 0..7){
                    val nextRow = current.row + dRow[d]
                    val nextCol = current.col + dCol[d]
                    val nextDist = current.distFromSource + 1

                    if(isAvailable(nextRow, nextCol, n)){
                        q.offer(Position(nextRow, nextCol, nextDist))
                    }
                }
             }
        }

        return if(dist[n - 1][n - 1] != Int.MAX_VALUE) dist[n-1][n-1] else  -1
    }

    fun isAvailable(row: Int, col: Int, n: Int) : Boolean {
        return row >= 0 && row < n && col >= 0 && col < n
    }

    data class Position(val row: Int, val col: Int, val distFromSource: Int)
}