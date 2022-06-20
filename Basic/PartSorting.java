package Basic;

import java.util.Arrays;

public class PartSorting {
    public int[] subSort(int[] array) {
        int left = -1,right = -1;
        if(array.length == 1)return new int[]{left,right};
//        左边从尾部来，右边从头部来
        int min = array.length-1,max = 0;
        for(int i=0;i<array.length;i++){
//            使用<=等号会扩大范围
            if(array[i]<array[max]){
                right = i;
            }
            else {
                max = i;
            }
        }
        for(int i=array.length-1;i>=0;i--){
//            使用>=等号会扩大范围
            if(array[i]>array[min]){
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