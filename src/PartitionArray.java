public class PartitionArray {
	/** 
     *@param nums: The integer array you should partition
     *@param k: As description
     *return: The index after partition
     */
    public int partitionArray(int[] nums, int k) {
	    //write your code here
	    if (nums == null || nums.length == 0){
	        return 0;
	    }
	    int left = 0, right = nums.length - 1;
	    while (left < right){
	        while (nums[left] < k && left < right){
	            left++;
	        }
	        while (nums[right] >= k && left < right){
	            right--;
	        }
	        if (left < right){
	            int temp = nums[left];
	            nums[left] = nums[right];
	            nums[right] = temp;
	            left++;
	            right--;
	        }
	    }
	   // System.out.println(left+" "+nums[left]+" "+ right +" "+nums[right]);
	    if (nums[left] < k){
	        return left + 1;
	    } else {
            return left;
	    }
    }
}