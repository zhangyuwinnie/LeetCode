/**
 * Medium -  Binary Search Tree Iterator
 * Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.
 * Calling next() will return the next smallest number in the BST.
 * 
 * Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree.
 */

import java.util.Stack;
import java.util.Queue;
import java.util.LinkedList;

/**
 * Solution 1: get a queue of TreeNode by inorderTraversal
 * @author zy
 *
 */
public class LC173 {
    
    private Queue<TreeNode> q; 
    
	public static class TreeNode {
		 int val;
		 TreeNode left;
		 TreeNode right;
		 TreeNode(int x) { val = x; }
	}
    public LC173(TreeNode root) {
        q = new LinkedList<TreeNode>();
        inorderTraversal(root);
        
    }

    public void inorderTraversal(TreeNode root){
        if (root == null) return;
        Stack<TreeNode> s = new Stack<TreeNode>();
        // s.push(root);
        while (!s.empty() || root != null){
            if (root != null){
            		s.push(root);
                root=root.left;
                
            }
            else{
            		root = s.pop();
                q.add(root);
                root = root.right;
                
            }
        }
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
    		
        return q.size() != 0;
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode p = q.poll();
        return p.val;
    }
    
    public static void main(String[] args){
		TreeNode root = new TreeNode(2);
		TreeNode leave = new TreeNode(1);
		root.left = leave;
		LC173 test = new LC173(root);

		while (test.hasNext()){
			System.out.println(test.next());
		}
	}
}