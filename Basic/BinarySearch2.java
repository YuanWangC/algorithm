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
	 //看target+1和target的左侧也是一样的
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

        //右边界的值时不用判断，因为target和target-1都有可能不存在
        //都不存在时，right都会压缩到同一个位置返回0
        //只存在一个时，会返回两者最接近的位置，中间会差一个位置不用减1
        //if(right<0 || nums[right]!=target)
        //    return -1;
        return right;
    }
    public static void main(String[] args) {
    	BinarySearch2 s = new BinarySearch2();
		//输入必须是升序排序数组
		//int[] arr = {5,7,7,8,8,8,8,8,10};
		//int[] arr = {7,8,10};
		int[] arr = {8};
		int target = 8;
		int res = s.search(arr, target);
		System.out.print(res);
	}
}
