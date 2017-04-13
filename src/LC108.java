public class LC108 {
	   public TreeNode sortedArrayToBST(int[] nums) {
	        if (nums.length == 0) return null;
	        TreeNode root = helper(nums, 0, nums.length-1);
	        return root;
	    }
	    
	    public TreeNode helper(int[] nums, int start, int end){
	    		// if (nums.length == 0) return null; 上面的function判断过了，不需要了
	    		if (start > end) return null; // 防止end会出现-1等值
	    		if (start == end){ // 
	    		    TreeNode root = new TreeNode(nums[start]);
	    		    return root;
	    		}
	    		int mid = (end + start)/2;
	    		TreeNode root = new TreeNode(nums[mid]);
	    		root.left = helper(nums, start, mid-1);
	    		root.right = helper(nums, mid+1, end);
	    		return root;
	    }
}
