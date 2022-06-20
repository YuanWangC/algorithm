package Basic;

import java.util.Arrays;

public class PartSorting {
    public int[] subSort(int[] array) {
        int left = -1,right = -1;
        if(array.length == 1)return new int[]{left,right};
        int min = array.length-1,max = 0;
        for(int i=0;i<array.length;i++){
            if(array[i]<=array[max]){
                right = i;
            }
            else {
                max = i;
            }
        }
        for(int i=array.length-1;i>=0;i--){
            if(array[i]>=array[min]){
                left = i;
            }
            else {
                min =i;
            }
        }
        if(left == array.length-1&& right == 0)return new int[]{-1,-1};
        return new int[]{left,right};
    }
    public static void main(String[] args){
        PartSorting p = new PartSorting();
        int[] arr = {1,3,5,7,9};
        int[] res = p.subSort(arr);
        System.out.println(Arrays.toString(res));
    }
}