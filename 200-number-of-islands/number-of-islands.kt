import java.util.ArrayDeque

class Solution {

    fun numIslands(grid: Array<CharArray>): Int {
        val n = grid.size
        val m = grid[0].size
        val dRow = intArrayOf(-1, 1, 0, 0)
        val dCol = intArrayOf(0, 0, -1, 1)

        var islandCnt = 0
        val visited = Array(n) { BooleanArray(m) }

        for(r in 0..<n){for(c in 0..<m) {

            if(grid[r][c] == '1' && !visited[r][c]){
                val q = ArrayDeque<IntArray>()

                q.offer(intArrayOf(r, c))
                visited[r][c] = true

                while(!q.isEmpty()) {
                    val current = q.poll()

                    for(d in 0..3){
                        val nextRow = current[0] + dRow[d]
                        val nextCol = current[1] + dCol[d]

                        if(isAvailable(nextRow, nextCol, n, m)
                         && grid[nextRow][nextCol] == '1'
                          && !visited[nextRow][nextCol])
                          {
                            visited[nextRow][nextCol] = true
                            q.offer(intArrayOf(nextRow, nextCol))
                          }
                    }
                }

                islandCnt++
            }
        }}

        
        return islandCnt
    }

    fun isAvailable(row: Int, col: Int, n: Int, m: Int): Boolean {
        return row >= 0 && row < n && col >= 0 && col < m
    }
}