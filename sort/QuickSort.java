import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {
    public void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void qsort1(int[] arr,int left,int right){
        if(right<=left)return;
//        int pos = partitionEnd(arr,left,right);
//        qsort1(arr,left,pos-1);
//        qsort1(arr,pos+1,right);

        int[] pos = ThreepartitionEnd(arr,left,right);
//        int[] pos = ThreePartitionLeft(arr,left,right,arr[right]);
        qsort1(arr,left,pos[0]-1);
        qsort1(arr,pos[1]+1,right);
    }
    public int partitionStart(int[] arr,int left,int right){
        int start = left,end = right;
        int mid = (left+right)/2;
        int target = arr[mid];
        swap(arr,mid,left);
        while(left<right){
            while(left<right && arr[right]>=target){
                right--;
            }
            while(left<right && arr[left]<=target){
                left++;
            }
            if(left<right)
                swap(arr,left,right);
        }
        System.out.println(Arrays.toString(arr));
        swap(arr,right,start);
        return left;
    }

    public int partitionEnd(int[] arr,int left,int right){
        int end = right;
        int mid = (left+right)/2;
        int target = arr[mid];
        swap(arr,mid,end);
        while(left<right){
            while(left<right && arr[left]<=target){
                left++;
            }
            while(left<right && arr[right]>=target){
                right--;
            }
            if(left<right)
                swap(arr,left,right);
        }
        System.out.println(Arrays.toString(arr));
        swap(arr,right,end);
        return right;
    }

    public int[] ThreepartitionEnd(int[] arr,int left,int right){
        int end = right;
        int mid = left+(int)(Math.random()*(right-left+1));
        int target = arr[mid];
        swap(arr,mid,end);
        int less = left-1,more = end;
        int index = left;
        while(index<more){
            if(arr[index] > target){
                swap(arr,index,--more);
            }
            else if(arr[index] < target){
                swap(arr,index++,++less);
            }
            else if(arr[index] == target)
                index++;
        }
        swap(arr,more,end);
        return new int[]{less+1,more};
    }

    public void qsort(int[] arr,int start,int end){
        if(start>=end)return;
        System.out.println(start+" "+end+" "+arr[end]);
        //随机选取一个下标交换到start上去
//        int mid = start +(int)(Math.random()*(end-start+1));
//        swap(arr, start, mid);
//        int pos = TwoPartition(arr, start, end, arr[start]);
//        qsort(arr, start, pos-1);
//        qsort(arr, pos + 1, end);
//        int pos[] = ThreePartitionLeft(arr, start, end, arr[start]);
        int pos[] = ThreePartitionRight(arr, start, end, arr[end]);
        System.out.println(Arrays.toString(pos));
        System.out.println("after:"+Arrays.toString(arr));
        qsort(arr, start, pos[0]-1);
        qsort(arr, pos[1] + 1, end);
    }
//    两折快排，选取start位置的数作为基准
    public int TwoPartition(int[] arr,int start,int end, int target){
        int less = start,more = end;
        while(less<more){
            while(less<more && arr[more] >= target){
                more--;
            }
            while(less<more && arr[less] <= target){
                less++;
            }
            if(less<more) swap(arr,less,more);
        }
        swap(arr,start,more);
        return less;
    }
    //  三折快排，选取start位置的数作为基准
    public int[] ThreePartitionLeft(int[] arr,int start,int end, int target){
        int less = start-1,more = end;
        int index = start;
        while(index<=more){
            if(arr[index] > target){
                swap(arr,index,more--);
            }
            else if(arr[index] < target){
                swap(arr,index++,++less);
            }
            else if(arr[index] == target){
                index++;
            }
        }
        System.out.println("before: "+Arrays.toString(arr));
//        闭区间[less+1,more]就是等于基准的区间
        return new int[]{less+1,more};
    }
    public int[] ThreePartitionRight(int[] arr, int start, int end, int target) {
        //[left,right]为闭区间，初始less为start-1,more在end上(基准的位置)
        int less = start-1,more = end;
        while(start<more) {
            //对于所有小于划分值的值，交换到less位置上
            if(arr[start]<target) {
                swap(arr,++less,start++);
            }
            //对于所有大于划分值的值，交换到more位置上，start不能变，因为换过来的值还未遍历
            else if(arr[start]>target){
                swap(arr,--more,start);
            }
            //保留了等于区
            else {
                start++;
            }
        }
        System.out.println("before: "+Arrays.toString(arr));
        //从end上交换到确定的位置
        swap(arr,more,end);
        //返回less+1，pos[0]-1
        //less表示的就是小于区域的边界元素，[less+1,more]是等于区域
        return new int[] {less+1,more};
    }
    public static void main(String[] args){
        QuickSort obj = new QuickSort();
//        Scanner in = new Scanner(System.in);
//        int k = in.nextInt();
//        int[] arr = new int[k];
//        for(int i=0;i<k;i++){
//            arr[i] = in.nextInt();
//        }
        int[] arr = {100,12,35,31,24,23,10,55,11};
        System.out.println(Arrays.toString(arr));
        long start1 = System.currentTimeMillis();
        if(arr.length>1)
//            obj.qsort(arr,0,arr.length-1);
            obj.qsort1(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
        long end1 = System.currentTimeMillis();
        System.out.println(end1-start1);


    }
}
