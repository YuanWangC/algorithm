package algorithm;

public class SingleNonDuplicate {
	int key= -1;
	public int singleNonDuplicate(int[] nums) {
		if(nums.length == 0)return -1;
        int start = 0,end = nums.length-1;
        quickSearch1(nums,start,end);
        if(this.key == -1)return -1;
        return nums[this.key];
    }
	public void quickSearch1(int[] nums, int low, int high) {
		if(nums.length == 1) {
			this.key = low;
			return;
		}
		//注意边界位置，是在数组两端，而不是遍历指针start和end两端
		int start = low;
		int end = high;
		while(start<=end) {
			int mid = start+(end-start)/2;
			System.out.println("##############");
			System.out.println(start);
			System.out.println(end);
			System.out.println(mid);
			System.out.println(this.key);
			//start与end集中在一个数上
			if(start == end) {
				int s1 = start-1;
				int s2 = start+1;
				if((s1>=low && nums[start]==nums[s1])||(s2<=high && nums[start] ==nums[s2])) {
					return;
				}	
				else {
					this.key = start;
					return;
				}
				
			}
			if(mid+1<=high && nums[mid] == nums[mid+1]) {
				if((mid&1) == 0) {
					//序号正确，start和mid之间没有目标
					start = mid+1;
				}
				else {
					//序号错误，目标在start和mid之间
					end = mid-1;
				}
			}
			//mid+1和mid不相等,比较mid与mid-1
			else if(mid-1>=low && nums[mid] == nums[mid-1]) {
					if((mid&1) != 0) {
						//序号正确，start和mid之间没有目标
						start = mid+1;
					}
					else {
						//序号错误，目标在start和mid之间
						end = mid-1;
					}
				}
			//mid与mid+1，mid-1都不相等
			else if((mid-1>=low && nums[mid] != nums[mid-1]) || (mid+1<=high && nums[mid] != nums[mid+1])){
				this.key = mid;
				return; 
				}
		}

	}
	public int quickSearch2(int[] nums) {
		int low = 0, high = nums.length - 1;
        while (low < high) {
            int mid = (high - low) / 2 + low;
            if (nums[mid] == nums[mid ^ 1]) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return nums[low];
    }

	public static void main(String[] args) {
		SingleNonDuplicate s = new SingleNonDuplicate();
		//int[] arr= {1,1,2,3,3,4,4,8,8};
		//int[] arr= {3,3,4,4};
		int[] arr = {3,3,7,7,10,11,11};
		int res = s.singleNonDuplicate(arr);
		System.out.println(res);
		int res2 = s.quickSearch2(arr);
		System.out.println(res2);
	}
}
