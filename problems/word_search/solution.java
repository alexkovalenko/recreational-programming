class Solution {
    public boolean exist(char[][] board, String word) {
        if (word.length() > board.length * board[0].length) {
            return false;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && exist(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean exist(char[][] board, String word, int i, int j, int p) {
        
        if (!inRange(board, i, j) || word.charAt(p) != board[i][j]) {
            return false;
        }
        
        if (word.length() - 1 == p) {
            return true;
        }
        
        
        char original = board[i][j];
        board[i][j] = '0';
        
        if(exist(board, word, i + 1, j, p + 1)) {
            return true;
        }
        
        if(exist(board, word, i, j + 1, p + 1)) {
            return true;
        }
        
        if(exist(board, word, i - 1, j, p + 1)) {
            return true;
        }
        
        if(exist(board, word, i, j - 1, p + 1)) {
            return true;
        }
        
        board[i][j] = original;
        
        return false;
    }
    
    private boolean inRange(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >=0 && j < board[0].length;
    }
}