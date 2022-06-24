class Solution {
   static ArrayList<String>list=new ArrayList<>();
    public static ArrayList<String> findPath(int[][] m, int n) {
      boolean array[][]=new boolean[n][n];
       find_paths(0,0,m,"",n,array);
       return list;
    }
    
    public static void find_paths(int row ,int col,int [][]matrix,String ans,int n,boolean[][]array){
        
        if(row==matrix.length-1&&col==matrix[0].length-1&&matrix[row][col]==1){
            list.add(ans);
            return;
        }
        
        
        if(row<0||col<0||row>=matrix.length||col>=matrix[0].length||matrix[row][col]==0||array[row][col]==true)return;
    
        array[row][col]=true;
        find_paths(row-1,col,matrix,ans+"U",n,array);
        find_paths(row,col-1,matrix,ans+"L",n,array);
        find_paths(row+1,col,matrix,ans+"D",n,array);
        find_paths(row,col+1,matrix,ans+"R",n,array);
         array[row][col]=false;
    }
}
