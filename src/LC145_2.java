// hard - Binary Tree Postorder Traversal
// Given a binary tree, return the postorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},

// iterative solution, reverse of postorder is root, right, left, which is 
// similiar to preorder, when add val , insert to index 0  
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC145_2 {
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
	     Stack<TreeNode> s = new Stack<TreeNode>();
	     s.push(root);
	     while (!s.empty()  ){
	    	 root = s.pop();
	    	 result.add(0,root.val);
	    	 if (root.left != null){
	    		 s.push(root.left);
	    	 }
	    	 if(root.right != null){
	    		 s.push(root.right);
	    	 }
	     }
	     return result;
	}
	public static void main(String[] args){
		LC145_2 test = new LC145_2();
		TreeNode root = test.new TreeNode(1);
		TreeNode leave = test.new TreeNode(2);
		root.left = leave;
		List<Integer> li = test.postorderTraversal(root);
		for (int i : li){
			System.out.print(i);
		}
		
	}
	
}
