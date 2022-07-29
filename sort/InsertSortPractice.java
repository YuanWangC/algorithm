import java.util.Arrays;

public class InsertSortPractice {
    public void insertSort(int[] arr){
        int insertCount = 0;
        for(int i=1;i<arr.length;i++){
            int temp = arr[i],j=i;
            while(j>0 && arr[j]<arr[j-1]){
                insertCount++;
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
        System.out.println(insertCount);
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args){
        InsertSortPractice obj = new InsertSortPractice();
        int[] arr = {1,2,5,3,4};
        System.out.println(Arrays.toString(arr));
        long start1 = System.currentTimeMillis();
        if(arr.length>1) {
            obj.insertSort(Arrays.copyOf(arr,5));
        }
//        System.out.println(Arrays.toString(arr));
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);
    }
}
