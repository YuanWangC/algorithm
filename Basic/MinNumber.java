package algorithm;
import 
public class MinNumber {
	public String minNumber(int[] nums) {
		//StringBuilder s = new StringBuilder();
		String[] s = new String[nums.length];
        for(int i=0;i>nums.length;i++){
            s[i] = String.valueOf(nums[i]);
        }
        quickSort(s,0,s.length);
        
        
    }
	public void quickSort(String[] s,) {
		int startIndex=0,endIndex=s.length;
        String select = s[startIndex+1];
        while(startIndex<endIndex) {
        	while(s[startIndex].compareTo(select])<0)startIndex++;
        	while(s[startIndex].compareTo(select)>0)endIndex--;
        	swap(s,startIndex,endIndex);
        	
        }
	}
	public void swap(String[] s,int i,int j) {
		String temp = s[i];
		s[i] = s[j];
		s[j] = s[i];
	}
	public static void main(String[] args) {
		int[] arr= {9,5,34,30,3};
		MinNumber m = new MinNumber();
		String res=m.minNumber(arr);
		System.out.print(res);
	}
}
