// Medium - Binary Tree Preorder Traversal   
// Given a binary tree, return the preorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},return [1,2,3].

// recursive solution, less efficient
import java.util.List;
import java.util.ArrayList;
public class LC144 {

	public List<Integer> preorderTraversal(TreeNode root) {
	     List<Integer> result = new ArrayList<Integer>();
	     if (root == null){
	    	 return result;
	     }
	     helper(root, result);
	     return result;
	}
	public void helper(TreeNode root, List<Integer> result){
		if (root == null) return;
		result.add(root.val);
		if (root.left != null){
			helper(root.left, result);
		}
		if(root.right != null){
			helper(root.right, result);
		}
	}
	
}
