import java.util.Arrays;

public class SelectSortPractice {
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void selectSort(int[] arr){
        int selectCount = 0;
        for(int i=0;i<arr.length;i++){
            int min = i;
            for(int j = i+1;j<arr.length;j++){
                selectCount++;
                if(arr[j]<arr[min]){
                    min = j;
                }
            }
            if(min!=i) swap(arr,min,i);
        }
        System.out.println(selectCount);
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args){
        SelectSortPractice obj = new SelectSortPractice();
        int[] arr = {1,2,5,3,4};
        System.out.println(Arrays.toString(arr));
        long start1 = System.currentTimeMillis();
        if(arr.length>1) {
            obj.selectSort(Arrays.copyOf(arr,5));
        }
//        System.out.println(Arrays.toString(arr));
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);
    }
}
