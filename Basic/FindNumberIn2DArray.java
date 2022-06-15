package algorithm;

public class FindNumberIn2DArray {
	 public boolean findNumberIn2DArray(int[][] matrix, int target) {
		 //二维数组两个边界条件
		 if(matrix.length == 0)return false;
		 if(matrix[0].length == 0) return false;
		 
		 int m = matrix.length-1,n=matrix[0].length-1;
		 int curRow = 0,curCol = n;
		 int cur = matrix[curRow][curCol];
		 //注意把行和列分清楚
		 while(curRow<=m && curCol>=0) {
			 System.out.println(curRow);
			 System.out.println(curCol);
			 System.out.println(matrix[curRow][curCol]);
			 
			 if(matrix[curRow][curCol] == target) {
				 return true;
			 }
			 else if(matrix[curRow][curCol] < target) {
				 curRow++;
				 
			 }
			 else if(matrix[curRow][curCol] > target) {
				 curCol--;
				 
			 }
		 }
		 return false;
		 
	 }
	public static void main(String[] args) {
		//int[][] arr = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10, 13, 14, 17, 24},{18, 21, 23, 26, 30}};
		//int key = 5;
		//int key = 20;
		int[][] arr = {{1,1}};
		int key = 2;
		FindNumberIn2DArray f = new FindNumberIn2DArray();
		boolean res = f.findNumberIn2DArray(arr, key);
		System.out.print(res);
	}
}
