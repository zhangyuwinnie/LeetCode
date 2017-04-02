// hard - Binary Tree Postorder Traversal
// Given a binary tree, return the postorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},

// recursive solution
import java.util.ArrayList;
import java.util.List;

public class LC145_1 {
	public class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
	
	public List<Integer> postorderTraversal(TreeNode root) {
	     List<Integer> result = new ArrayList<Integer>();
	     if (root == null){
	    	 return result;
	     }
	     helper(root, result);
	     return result;
	}
	public void helper(TreeNode root, List<Integer> result){
		if (root == null) return;
		//if (root.left == null && root.right == null){    // !!!
		//	result.add(root.val);
		//}
		if (root.left != null){
			helper(root.left, result);
		}
		if(root.right != null){
			helper(root.right, result);
		}
		result.add(root.val);
	}
}
