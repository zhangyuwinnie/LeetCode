import java.util.Queue;
import java.util.LinkedList;

public class LC116 {
	public class TreeLinkNode {
    	     int val;
     	 TreeLinkNode left, right, next;
		 TreeLinkNode(int x) { val = x; }
	}
	//solution1: BFS Queue.peek()的用法,适用于non binary tree,but not constant extra space 
	public void connect(TreeLinkNode root) {
	        if (root == null) return;
	        Queue<TreeLinkNode> q = new LinkedList<TreeLinkNode>();
	        q.add(root);
	        while (!q.isEmpty()){
	            int size = q.size();
	            for (int i = 0; i<size; i++){
	                TreeLinkNode curr = q.poll();
	                if (curr.left != null){
	                    q.add(curr.left);
	                }
	                if (curr.right != null){
	                    q.add(curr.right);
	                }
	                if (i<size-1){ //不是某层最后一个，有next
	                    TreeLinkNode next = q.peek();
	                    curr.next = next;
	                }
	            }
	        }
	}
	// solution2: perfect balanced tree,直接一层一层，从左到右连
	public void connect2(TreeLinkNode root) {
        TreeLinkNode level = root;
        while (level!= null){
            TreeLinkNode curr = level;
            while (curr != null){
                if (curr.left != null) curr.left.next = curr.right;
                if (curr.right != null && curr.next!= null) curr.right.next = curr.next.left;
                curr = curr.next;
            }
            level = level.left;
        }
    }
	
}
