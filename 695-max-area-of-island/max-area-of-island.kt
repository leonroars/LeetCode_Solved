import java.util.ArrayList;
import java.util.ArrayDeque;

class Solution {
    val dRow = intArrayOf(-1, 1, 0, 0)
    val dCol = intArrayOf(0, 0, -1, 1)

    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        // 0. Find every island
        val islands = findEveryIsland(grid)

        val n = grid.size
        val m = grid[0].size
        var maxIslandSize = 0

        // 1. Calculate connectivity from each island and count the number of connected component.
        val visited = Array(n) {BooleanArray(m)}

        for(island in islands) {
            // From the island which has not been visited
            if(!visited[island[0]][island[1]]) {

                val q = ArrayDeque<IntArray>()
                var currentIslandSize = 1

                visited[island[0]][island[1]] = true
                q.offer(island)

                while(!q.isEmpty()) {
                    val current = q.poll()

                    for(d in 0..3){
                        val nextRow = current[0] + dRow[d]
                        val nextCol = current[1] + dCol[d]

                        if(isAvailable(nextRow, nextCol, n, m)
                         && grid[nextRow][nextCol] == 1
                          && !visited[nextRow][nextCol])
                          {
                            visited[nextRow][nextCol] = true
                            q.offer(intArrayOf(nextRow, nextCol))
                            currentIslandSize++
                          }
                    }
                }

                maxIslandSize = max(maxIslandSize, currentIslandSize)
            }
        }

        return maxIslandSize
    }

    fun findEveryIsland(grid: Array<IntArray>): ArrayList<IntArray> {
        val n = grid.size
        val m = grid[0].size

        val islands = ArrayList<IntArray>()

        for(r in 0..<n){
            for(c in 0..<m){
                if(grid[r][c] == 1){islands.add(intArrayOf(r, c))}
            }
        }

        return islands
    }

    fun isAvailable(row: Int, col: Int, n: Int, m: Int): Boolean {return row >= 0 && row < n && col >= 0 && col < m}
}