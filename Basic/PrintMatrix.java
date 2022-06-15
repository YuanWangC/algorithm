package algorithm;
import java.util.ArrayList;

//此解法有误，未考虑到中间单个元素矩形转折点
public class PrintMatrix {

    public int[] spiralOrder(int[][] matrix) {
    	//矩形为m行n列，matrix.length为m，matrix[0].length为n
        int[] output = new int[matrix[0].length*matrix.length];
        int time = 1;
        int lastOne = -1;
        ArrayList<Integer> mergeList = new ArrayList<Integer>();
        while(true) {
	        ArrayList<Integer> e = eastRead(matrix,time-1,time);
	        if(e.size() == 0) {
	        	lastOne=matrix[time-1][time-1];
	        	break;
	        }
	        mergeList.addAll(e);
	        ArrayList<Integer> s = sourthRead(matrix,matrix[0].length-time,time);
	        if(s.size() == 0) {
	        	lastOne=matrix[time-1][matrix[0].length-time];
	        	break;
	        }
	        mergeList.addAll(s);
	        ArrayList<Integer> w = westRead(matrix,matrix.length-time,time);
	        if(w.size() == 0) {
	        	lastOne=matrix[matrix.length-time][time-1];
	        	break;
	        }
	        mergeList.addAll(w);
	        ArrayList<Integer> n = northRead(matrix,time-1,time);
	        if(n.size() == 0) {
	        	lastOne=matrix[matrix.length-time][time-1];
	        	break;
	        }
	        mergeList.addAll(n);
	        time++;
        }
        int i=0;
        for(;i<mergeList.size();i++) {
        	//System.out.print(mergeList.get(i));
        	output[i]=mergeList.get(i);
        }
        output[i]=lastOne;	
        return output;
    }
    public ArrayList<Integer> eastRead(int[][] matrix, int row, int time){
        ArrayList<Integer> arr = new ArrayList<>();
        //边界从两边向中间同时收缩【[0,n-1),[1,n-2),···】
        //System.out.print(matrix[row][time-1]);
        for(int i=time-1;i<matrix[row].length-time;i++){
            arr.add(matrix[row][i]);       
        }
        return arr;
    }
    public ArrayList<Integer> sourthRead(int[][] matrix, int colomn, int time){
    	ArrayList<Integer> arr = new ArrayList<>();
    	//边界从两边向中间同时收缩【[0,m-1),[1,m-2),···】
    	//System.out.print(matrix[time-1][colomn]);
        for(int i=time-1;i<matrix.length-time;i++){
            arr.add(matrix[i][colomn]);
        }
        return arr;
    }
    public ArrayList<Integer> westRead(int[][] matrix, int row, int time){
    	ArrayList<Integer> arr = new ArrayList<>();
    	//System.out.print(matrix[row][time-1]);
    	//边界从两边向中间同时收缩【[n-1,0),[n-2,1),···】
        for(int i=matrix[row].length-time;i>time-1;i--){
            arr.add(matrix[row][i]);
        }
        return arr;
    }
    public ArrayList<Integer> northRead(int[][] matrix, int colomn, int time){
    	ArrayList<Integer> arr = new ArrayList<>();
    	//System.out.print(matrix[matrix.length-time][colomn]);
    	//边界从两边向中间同时收缩【[m-1,0),[m-2,1),···】
        for(int i=matrix.length-time;i>time-1;i--){
            arr.add(matrix[i][colomn]);
        }
        return arr;
    }
    public static void main(String[] args) {
    	//int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
    	int[][] arr = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
    	//int[][] arr = {{1,2}};
    	PrintMatrix p =new PrintMatrix();
    	int[] res = p.spiralOrder(arr);
    	for(int i:res)
   		 System.out.println(i);
    }
}