package sort;

import java.util.Arrays;

public class HeapSort {
    public static void buildHeap(int[] arr){
        if(arr.length ==1)return;
        //(i-1)/2算的是每个节点的父节点【长度为10的数组，整理4,3,2,1,0这几个节点】
        for(int i=(arr.length-1-1)/2;i>=0;i--){
            System.out.print(i+" ");
            shiftDown(arr,i, arr.length);
            System.out.println(Arrays.toString(arr));
        }
    }
    //从上往下整理堆
    public static void shiftDown(int[] arr,int parent,int len){
        int child = 2*parent+1;
        while(child<len){
            if(child+1<len && arr[child+1]>arr[child]){
                child++;
            }
            if(arr[parent]<arr[child]) {
                swap(arr, parent, child);
                parent = child;
                child = 2 * parent + 1;
            }
            else break;
        }
    }
    public static void main(String[] args) {
        int[] arr = {10,9,5,7,3,8,1,0,2,6};
        buildHeap(arr);     //大根堆
        System.out.println(Arrays.toString(arr));
        //交换节点+整理堆，最后一个节点不再参与，所以size从len-1开始
        int size = arr.length-1;
        while(size>0){
            swap(arr,0,size);
            shiftDown(arr,0,size);
            size--;
        }
        System.out.println(Arrays.toString(arr));
    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
