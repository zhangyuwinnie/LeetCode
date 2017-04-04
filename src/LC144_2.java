// Medium - Binary Tree Preorder Traversal   
// Given a binary tree, return the preorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},return [1,2,3].

// iterative solution
import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
public class LC144_2 {
	
	public List<Integer> preorderTraversal(TreeNode root) {
	     List<Integer> result = new ArrayList<Integer>();
	     if (root == null){
	    	 return result;
	     }
	     Stack<TreeNode> s = new Stack<TreeNode>();
	     s.push(root);
	     while (!s.empty()  ){
	    	 root = s.pop();
	    	 result.add(root.val);
	    	 if (root.right != null){
	    		 s.push(root.right);
	    	 }
	    	 if(root.left != null){
	    		 s.push(root.left);
	    	 }
	     }
	     return result;
	}
	
	
}
