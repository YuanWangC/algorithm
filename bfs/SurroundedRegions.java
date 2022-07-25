package bfs;

import java.util.ArrayList;
import java.util.Arrays;

public class SurroundedRegions {
    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public void dfs(String[][] board,int i,int j){
        if(i<0 ||j<0 ||i>=board.length ||j>=board[0].length)return;
        if(!board[i][j].equals("O"))return;
        board[i][j] = "L";
        for(int[] d:directions)
            dfs(board,i+d[0],j+d[1]);
    }
    public void solve(String[][] board) {
        if(board.length ==0 ||board[0].length == 0)return;
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(i==0 || j == 0||i==board.length-1||j==board[0].length-1) {
                    dfs(board, i, j);
                }
            }
        }
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(!board[i][j].equals("L")){
                    board[i][j] = "X";
                }
                if(board[i][j].equals("L")){
                    board[i][j] = "O";
                }
            }
        }
    }
    public static void main(String[] args){
        String[][] arr = {{"X","X","X","X"},{"X","O","O","X"},{"X","X","O","X"},{"X","O","X","X"}};
        SurroundedRegions obj = new SurroundedRegions();
        obj.solve(arr);
        for(String[] s:arr){
            System.out.println(Arrays.toString(s));
        }
    }
}
