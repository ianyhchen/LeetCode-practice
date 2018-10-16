class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            Set<Character> row = new HashSet<>();
            Set<Character> column = new HashSet<>();
            Set<Character> cube = new HashSet<>();
            
            for(int j = 0; j < 9; j++){
                if(board[i][j] != '.' && !row.add(board[i][j])){
                    return false;
                }
                if(board[j][i] != '.' && !column.add(board[j][i])){
                    return false;
                }
                //the same cube index (hard to understand)
                int rowIndex = 3*(i/3)+(j/3);
                int colIndex = 3*(i%3)+(j%3);
                if(board[rowIndex][colIndex] != '.' && !cube.add(board[rowIndex][colIndex])){
                    return false;
                }
            }
        }
        return true;
    }
}
