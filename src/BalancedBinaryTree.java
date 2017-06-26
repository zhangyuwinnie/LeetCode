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
}