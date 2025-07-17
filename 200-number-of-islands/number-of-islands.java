/*
<Idea>
 - Pick a certain land(vertex) and do BFS to figure out the constituent of island that vertex belongs to.
 - Pick another vertex which has not been visited. Do BFS from there and go on.

<Time Complexity>
 - O(m*n) (Since 1 <= m, n <= 300, It would be efficient enough.)
<Concept>
 - Counting the nubmer of connected components.
*/


class Solution {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int numberOfIslands = 0;

        for(int row = 0; row < grid.length; row++){
            for(int col = 0; col < grid[0].length; col++){
                if(grid[row][col] == '1' && !visited[row][col]){
                    BFS(grid, visited, row, col);
                    numberOfIslands++;
                }
            }
        }

        return numberOfIslands;
    }

    private void BFS(char[][] grid, boolean[][] visited, int row, int col){
        ArrayDeque<int[]> q = new ArrayDeque<>();
        
        int[] dRow = new int[]{-1, 1, 0, 0};
        int[] dCol = new int[]{0, 0, -1, 1};

        visited[row][col] = true;
        q.addLast(new int[]{row, col});

        while(!q.isEmpty()){
            int[] current = q.removeFirst();
            for(int d = 0; d < 4; d++){
                int adjRow = current[0] + dRow[d];
                int adjCol = current[1] + dCol[d];
                if(isAvailable(grid.length, grid[0].length, adjRow, adjCol)
                 && grid[adjRow][adjCol] == '1'
                  && !visited[adjRow][adjCol]){
                    visited[adjRow][adjCol] = true;
                    q.addLast(new int[]{adjRow, adjCol});
                }
            }
        }
    }

    private boolean isAvailable(int rowLen, int colLen, int row, int col){
        return row >= 0 && row < rowLen && col >= 0 && col < colLen;
    }
}