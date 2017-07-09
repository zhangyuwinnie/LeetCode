class ResultType{
    public boolean isBalanced;
    public int maxDepth;
    ResultType(boolean isBalanced, int maxDepth){
        this.isBalanced = isBalanced;
        this.maxDepth = maxDepth;
    }
}

public class BalancedBinaryTree {
/**
 * @param root: The root of binary tree.
 * @return: True if this Binary tree is Balanced, or false.
 */

	public boolean isBalanced(TreeNode root) {
	    // write your code here
	    boolean result = helper(root).isBalanced;
	    return result;
	}
	
	public ResultType helper(TreeNode root){//1
	    if (root == null){
	        return new ResultType(true, 0);
	    }
	    ResultType left = helper(root.left);
	    ResultType right = helper(root.right);
	    if (!left.isBalanced || !right.isBalanced){
	        return new ResultType(false, -1);
	        
	    }
	    if (Math.abs(left.maxDepth - right.maxDepth )> 1){
	        return new ResultType(false, -1);
	        
	    }
	    return new ResultType(true, Math.max(helper(root.left).maxDepth, helper(root.right).maxDepth) + 1);
	}
	
//	自创方法：用global变量和helper函数分别负责追踪一个特性，这样就可以追踪两个变量
	public class Solution {
	    /**
	     * @param root: The root of binary tree.
	     * @return: True if this Binary tree is Balanced, or false.
	     */
	    private boolean balanced = true;
	    public boolean isBalanced(TreeNode root) {
	        // write your code here
	        helper(root);
	        return balanced;
	    }
	    
	    public int helper(TreeNode root){//1
	        if (root == null){
	            return 0;
	        }
	        int left = helper(root.left);
	        int right = helper(root.right);
	        if (Math.abs(left - right) > 1){
	            balanced = false;
	        }
	        return Math.max(left, right) + 1;
	    }
	}
}