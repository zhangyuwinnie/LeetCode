import java.util.Arrays;

public class LC189 {
	// solution1: make a copy of the array
    public void rotate(int[] nums, int k) {
	    	int len = nums.length;
	    	if (len <= 1) return; // case of null and [-1]
		k = k%len; // case when k > len 
	    int[] change = new int[len];
	    int j = 0;
	    for ( int i = 0; i< len; i++){
	    		change[i] = nums[j++];
	    }
	    int a = len - k;
	    for ( int i = 0; i < k; i++){
	    		nums[i] = change[a++];
	    }
	    int b = 0;
	    for (int i = k; i<len; i++){
	    		nums[i] = change[b++];
	    }
    }
    // solution2: use reverse strategy
    public void rotate2(int[] nums, int k){
    		k %= nums.length;
    		reverse(nums, 0, nums.length-1);
    		reverse(nums, 0, k-1);
    		reverse(nums, k, nums.length-1);
    }
    public void reverse(int[] nums, int start, int end){
    		if (nums.length <= 1) return;
    		while ( start<end){
    			int tmp = nums[start];
    			nums[start] = nums[end];
    			nums[end] = tmp;
    			start++;
    			end--;
    		}
    }
    
    public static void main (String[] args){
    		LC189 test = new LC189();
    		int[] arr = {1,2,3,4,5,6,7};
    	    test.rotate(arr,3);
    	    System.out.println(Arrays.toString(arr));
    		
    }
}
