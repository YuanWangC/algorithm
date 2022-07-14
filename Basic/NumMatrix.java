package Basic;

import java.util.Arrays;
import java.util.HashMap;

public class NumMatrix {
    int[][] sum;
    public NumMatrix(int[][] matrix) {
//        计算前缀和
        sum = new int[matrix.length+1][matrix[0].length+1];
        for(int i=0;i<matrix.length;i++){
            int rowSum = 0;
            for(int j=0;j<matrix[0].length;j++){
                rowSum+=matrix[i][j];
                sum[i+1][j+1]=sum[i][j+1]+rowSum;
            }
        }
         for(int i=0;i<=matrix.length;i++)
             System.out.println(Arrays.toString(sum[i]));
    }

    //像求集合交集一样求子矩形的和
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2+1][col2+1]-sum[row2+1][col1]-sum[row1][col2+1]+sum[row1][col1];
    }
    public static void main(String[] args){
        int[][] matrix = {{3,0,1,4,2},{5,6,3,2,1},{1,2,0,1,5},{4,1,0,1,7},{1,0,3,0,5}};
        NumMatrix obj = new NumMatrix(matrix);
        int res = obj.sumRegion(2,1,4,3);
        System.out.println(res);
    }
}