//two ways of solving this hard level problem...
//first method...

class Solution {
    public List<List<String>> solveNQueens(int n) {
        char[][]queen=new char[n][n];
        List<List<String>>res=new ArrayList<>();
        queensplacement(queen,res,0);
        return res;
    }
    public static void queensplacement(char[][]queen,List<List<String>>res,int row){
        if(row==queen.length){
            display(res,queen);
            return;
        }
        for(int c=0;c<queen.length;c++){
            boolean isqueensafe=checkqueensafe(queen,row,c);
               if(isqueensafe==true){
                   queen[row][c]='Q';
                   queensplacement(queen,res,row+1);
                   queen[row][c]='.';
        }  
     }
}
    public static boolean checkqueensafe(char array[][],int row,int coloumn){
        for(int i=row-1,j=coloumn;i>=0;i--){
            if(array[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=coloumn-1;i>=0&&j>=0;i--,j--){
            if(array[i][j]=='Q'){
                return false;
            }
        }
        for(int i=row-1,j=coloumn+1;i>=0&&j<array.length;i--,j++){
            if(array[i][j]=='Q'){
                return false;
            }
        }
        return true;
    }
    //since we need to print all the paths thats why we passed whole board such that we can traverse whole path.
  public static   void display(List<List<String>> res, char[][] board){
        String str = "";
        List<String> row = new ArrayList<>();
        
        for(int i=0;i<board.length;i++){
            str = "";
            for(int j=0;j<board.length;j++){
                if(board[i][j]=='Q')
                    str = str+'Q';
                else
                    str = str+'.';
            }
            row.add(str);
        }
        res.add(row);
    }
}


//Second Method

//Branch and Bound Method...


import java.io.*;
import java.util.*;
public class method2nqueens{
    public static void main(String[]args)throws Exception{
        Scanner in =new Scanner(System.in);
        System.out.println("Enter the number of queens to be placed in n*n board");
        int n=in.nextInt();
        boolean queen[][]=new boolean[n][n];
        boolean cols[]=new boolean[n];
        boolean ndiag[]=new boolean[2*n-1];//we had total this much diagonal this is for normal diagonal  
        boolean rdiag[]=new boolean[2*n-1];
        System.out.println("The paths are as follow");
        queensplacement(queen,"",0,cols,ndiag,rdiag);
    }
    public static void queensplacement(boolean[][]queen,String asf,int row,boolean[] cols,boolean[]ndiag,boolean[]rdiag){
        if(row==queen.length){
            System.out.println(asf+".");
            return;
        }
        for(int c=0;c<queen[0].length;c++){
            if(cols[c]==false&&ndiag[row+c]==false&&rdiag[row-c+queen.length-1]==false){//for reverse diagonal if we just do row minus coloumn than in some diagonal we had negative values so to avoid that we just added the queen length -1 such that we can make similar to normal diagonal but in opposite way...
                queen[row][c]=true;
                cols[c]=true;
                ndiag[row+c]=true;
                rdiag[row-c+queen.length-1]=true;
                queensplacement(queen,asf+row+"-"+c+",",row+1,cols,ndiag,rdiag);
                cols[c]=false;//back track
                ndiag[row+c]=false;
                rdiag[row-c+queen.length-1]=false;
                queen[row][c]=false;
            }
        }
    }
}
