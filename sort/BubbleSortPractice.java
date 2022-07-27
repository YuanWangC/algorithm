import java.util.Arrays;
import java.util.Scanner;

public class BubbleSortPractice {
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void bubbleSort(int[] arr){
        int bubbleCount = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1;j++){
                bubbleCount++;
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
        System.out.println(bubbleCount);
        System.out.println(Arrays.toString(arr));
    }
    //    针对数组比较次数的优化
    public void bubbleSortV2(int[] arr){
        int bubbleCount = 0;
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length-1-i;j++){
                bubbleCount++;
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                }
            }
        }
        System.out.println(bubbleCount);
        System.out.println(Arrays.toString(arr));
    }
//    针对基本排好序的数组优化
    public void bubbleSortV3(int[] arr){
        int bubbleCount = 0;
        boolean flag;
        for(int i=0;i<arr.length;i++){
            flag = false;
            for(int j=0;j<arr.length-1-i;j++){
                bubbleCount++;
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    flag = true;
                }
            }
            if(!flag)break;
        }
        System.out.println(bubbleCount);
        System.out.println(Arrays.toString(arr));
    }

//    用最后一个交换的下标来限制比较次数
    public void bubbleSortV4(int[] arr){
        int bubbleCount = 0;
        boolean flag;
        int temp = arr.length-1;
        for(int i=0;i<arr.length;i++){
            flag = false;
            int count = temp;
            for(int j=0;j<count;j++){
                bubbleCount++;
                if(arr[j]>arr[j+1]){
//                    System.out.println(j);
                    swap(arr,j,j+1);
                    temp = j;
                    flag = true;
                }
            }
            if(!flag)break;
        }
        System.out.println(bubbleCount);
        System.out.println(Arrays.toString(arr));
    }
    public static void main(String[] args){
        BubbleSortPractice obj = new BubbleSortPractice();
//        Scanner in = new Scanner(System.in);
//        int k = in.nextInt();
//        int[] arr = new int[k];
//        for(int i=0;i<k;i++){
//            arr[i] = in.nextInt();
//        }
//        System.out.println(Arrays.toString(arr));
        int[] arr = {1,2,5,3,4};
        System.out.println(Arrays.toString(arr));
        long start1 = System.currentTimeMillis();
        if(arr.length>1) {
            obj.bubbleSort(Arrays.copyOf(arr,5));
            obj.bubbleSortV2(Arrays.copyOf(arr,5));
            obj.bubbleSortV3(Arrays.copyOf(arr,5));
            obj.bubbleSortV4(Arrays.copyOf(arr,5));
        }
//        System.out.println(Arrays.toString(arr));
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);
    }
}
