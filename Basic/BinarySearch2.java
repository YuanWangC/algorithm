package algorithm;

public class BinarySearch2 {
	 public int search(int[] nums, int target) {
		 /*
         int right = binarySearch(nums,target);
         System.out.println(right);
         System.out.println("###########");
         int left = binarySearch(nums,target-1);
         System.out.println(left);
         return right-left;
         */
         int right2 = binarySearchLeft(nums,target+1);
         System.out.println(right2);
         System.out.println("###########");
         int left2 = binarySearchLeft(nums,target);
         System.out.println(left2);
         return right2-left2;
    }
	 //��target+1��target�����Ҳ��һ����
	 public int binarySearchLeft(int[] nums,int target){
	        int left = 0,right = nums.length-1;
	        while(left<=right){
	        	System.out.println(right);
	            int mid = left+(right-left)/2;
	            if(nums[mid]<target){
	            	left = mid+1;        
	            }
	            else{
	            	right = mid-1;
	            }
	        }
	        return left;
	    }
    public int binarySearch(int[] nums,int target){
        int left = 0,right = nums.length-1;
        while(left<=right){
        	System.out.println(right);
            int mid = left+(right-left)/2;
            if(nums[mid]>target){
                right = mid-1;
            }
            else{
                left = mid+1;
            }
        }

        //�ұ߽��ֵʱ�����жϣ���Ϊtarget��target-1���п��ܲ�����
        //��������ʱ��right����ѹ����ͬһ��λ�÷���0
        //ֻ����һ��ʱ���᷵��������ӽ���λ�ã��м���һ��λ�ò��ü�1
        //if(right<0 || nums[right]!=target)
        //    return -1;
        return right;
    }
    public static void main(String[] args) {
    	BinarySearch2 s = new BinarySearch2();
		//���������������������
		//int[] arr = {5,7,7,8,8,8,8,8,10};
		//int[] arr = {7,8,10};
		int[] arr = {8};
		int target = 8;
		int res = s.search(arr, target);
		System.out.print(res);
	}
}
