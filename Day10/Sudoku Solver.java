class Solution {
    boolean a;
    private boolean isSafe(char[][] board, int row, int col, char t){
        
        for(int i = 0; i<board[0].length; i++){
            
            //check in column if target is present
            if(board[row][i] == t) return false;
            
             //check in row if target is present
            if(board[i][col] == t) return false;
            
        }
        
        //check in grid if target is present
        int startRowOfGrid = (row/3) * 3;
        int startColOfGrid = (col/3) * 3;
        
        for(int i = startRowOfGrid; i < startRowOfGrid + 3; i++){
            for(int j = startColOfGrid; j < startColOfGrid + 3; j++){
                if(board[i][j] == t) return false;
            }
        }
        
        return true;
    }
    
    private boolean helper(char[][] board, int row, int col){
        
        if(row == board.length) return true;
        
		// for the next recursive call we will pass this 
        int newRow = 0;
        int newCol = 0;
        
        if(col == board[0].length-1){
            //go to next row
            newRow = row + 1;
            newCol = 0;
        }else{
            //go one cell further
            newRow = row;
            newCol = col + 1;
        }
        
        if(board[row][col] == '.'){
            //empty cell
            for(char value = '1'; value <= '9'; value++){
                if(isSafe(board, row, col, value)){
                    board[row][col] = value;
                    if(helper(board, newRow, newCol)){
                        //if the placed value is correct
                        return true;//once this run every called function will get true hence no bactracking take place this is used to avoid the bactrack when we got our answer board if this condition we dont put than no every element which we putted will be replaced by '.';
                    }else{
                        //backtrack
                        board[row][col] = '.';
                    }
                }
            }
        }
        else{
            //already filled
            if(helper(board, newRow, newCol)) return true;
        }
        return false;
    }
    
    public void solveSudoku(char[][] board) {
       boolean value= helper(board, 0, 0);
        System.out.println(value+" "+a);
    }
}
