/**
 * Medium -  Binary Search Tree Iterator
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */

import java.util.Stack;

/**
 * Solution 2: separated inorder traversal 
 * 先把所有left children 放入stack，每次pop出一个，然后再观察该node的right,有的话，追踪right下面的所以left
 * @author zy
 *
 */
public class LC173_2 {
    
    private Stack<TreeNode> stack; 
    
	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
    public LC173_2(TreeNode root) {
    		stack = new Stack<TreeNode>();
        while (root!= null){
        		stack.push(root);
        		if (root.left != null){
        		    root = root.left;
        		}
        		else{
        		    break;
        		}
        		
        }
        
    }

    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    		
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode p = stack.pop();
        int e = p.val;
        if (p.right != null){
        		p = p.right;
        		while (p!= null){
        		    stack.push(p);
            		if (p.left != null){
        		        p = p.left;
        	    	}
        	    	else{
        		      break;
        		    }
                }
        		
        }
        return e;
    }
    
    public static void main(String[] args){
		TreeNode root = new TreeNode(2);
		TreeNode leave = new TreeNode(1);
		root.left = leave;
		LC173_2 test = new LC173_2(root);

		while (test.hasNext()){
			System.out.println(test.next());
		}
	}
}