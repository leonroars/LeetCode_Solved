class Solution {
    
    val possibleAnswers = mutableListOf<List<String>>()

    fun solveNQueens(n: Int): List<List<String>> {
        
        placeQueen(Array(n) {BooleanArray(n)}, 0, 0)

        return possibleAnswers
    }

    // columnSelection : Column Selection Status represented as bitmask.
    fun placeQueen(board: Array<BooleanArray>, currentRow: Int, columnSelection: Int) {
        // Base Case : 
        if(currentRow == board.size) {
            possibleAnswers.add(translateBoardToStringArray(board))
            return
        }
        
        for(c in 0..<board.size) {
            // found right column to place queen
            if(columnSelection and (1 shl c) == 0 
                && isDiagonallySafe(board, currentRow, c)) {
                board[currentRow][c] = true
                placeQueen(board, currentRow + 1, (columnSelection or (1 shl c)))
                board[currentRow][c] = false
            }
        }
    }

    fun translateBoardToStringArray(board: Array<BooleanArray>): List<String> {
        val result = ArrayList<String>()

        for(r in 0..<board.size) {
            val currentRow = StringBuilder()

            for(c in 0..<board.size) {
                currentRow.append(if (board[r][c]) "Q" else ".")
            }

            result.add(currentRow.toString())
        }

        return result
    }

    fun isDiagonallySafe(board: Array<BooleanArray>, currentRow: Int, currentCol: Int): Boolean {
        var r = currentRow
        var c = currentCol

        while(r >= 0 && c >= 0) {
            if(board[r][c]){return false}
            r--
            c--
        }

        r = currentRow
        c = currentCol

        while(r >= 0 && c < board.size){
            if(board[r][c]){return false}
            r--
            c++
        }

        return true
    }
}