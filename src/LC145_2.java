// hard - Binary Tree Postorder Traversal
// Given a binary tree, return the postorder traversal of its nodes' values.

// For example:
// Given binary tree {1,#,2,3},return [3,2,1].

// Note: Recursive solution is trivial, could you do it iteratively?

// iterative solution, reverse of postorder is root, right, left, which is 
// similiar to preorder, when add val , insert to index 0  
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LC145_2 {

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
		TreeNode root = new TreeNode(1);
		TreeNode leave1 = new TreeNode(1);
		TreeNode leave2 = new TreeNode(2);
		TreeNode leave3 = new TreeNode(3);
		root.left = leave1;
		root.right = leave2;
		leave2.left = leave3;
		List<Integer> li = test.postorderTraversal(root);
		for (int i : li){
			System.out.print(i);
		}
		
	}
	
}
