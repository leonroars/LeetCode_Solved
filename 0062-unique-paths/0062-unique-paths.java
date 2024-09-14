/*
 [Main Idea] BFS + DP
  - BFS traverse given graph or dimension in level order.
    -------------------------------------------------------
    |(0,0)| (0,1) | (0,2) | (0,3) | (0,4) | (0,5) | (0,6) |
    -------------------------------------------------------
    |(1,0)| (1,1) | (1,2) | (1,3) | (1,4) | (1,5) | (1,6) |
    -------------------------------------------------------
    Let's say we have this 2-D dimension. And m & n will be 2 and 7 correspondingly.
    So what we want to know is the number of unique path from (0, 0) to (1, 6)
    if we only move right or down.
    
    It was quite hard for me to come up with the solution which starting from (0, 0).
    Maybe I could use the pattern that unique path is permutation - (n-1) number of 'right' and (m - 1) of 'down'.
    
    Instead, i decided to focus on the things that is 'sort of deterministic'.
    For example, you can see that unique path from (0, 6) and (1, 5) to (1, 6) is "1".
    The number of unique path of certain location - let's say P - is determined by its locatin relative to destination.
    Below is the number of unique path from the point to destination.
    
      -----------------------------
   0   | 7 | 6 | 5 | 4 | 3 | 2 | 1 |
      -----------------------------
   1   | 1 | 1 | 1 | 1 | 1 | 1 | 0 |
      -----------------------------
    
    As you can see, from the location K - (0, 5) - to destination - (1, 6), it has two unique path.
    It's because K can to destination via its downside or rightside which correspondingly has 1 unique path to destination.
*/

import java.util.ArrayDeque;

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] board = new int[m][n];
        boolean[][] visited = new boolean[m][n]; // For checking visited.
        ArrayDeque<int[]> q = new ArrayDeque<>();
        board[m-1][n-1] = 1;
        q.addLast(new int[]{m-1, n-1});
        
        while(!q.isEmpty()){
            int[] current = q.removeFirst(); // FIFO
            int currentRow = current[0];
            int currentCol = current[1];
            
            int leftRow = currentRow;
            int leftCol = currentCol - 1;
            int upRow = currentRow - 1;
            int upCol = currentCol;
                
            if(leftRow >= 0 && leftCol >= 0){
                board[leftRow][leftCol] += board[currentRow][currentCol];
                if(!visited[leftRow][leftCol]){
                    visited[leftRow][leftCol] = true;
                    q.addLast(new int[]{leftRow, leftCol});
                }
            }
            if(upRow >= 0 && upCol >= 0){
                board[upRow][upCol] += board[currentRow][currentCol];
                if(!visited[upRow][upCol]){
                    visited[upRow][upCol] = true;
                    q.addLast(new int[]{upRow, upCol});
                }
            }
        }
        
        return board[0][0];
        
    }
}