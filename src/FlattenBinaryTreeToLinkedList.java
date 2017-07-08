
public class FlattenBinaryTreeToLinkedList {
    /**
     * @param root: a TreeNode, the root of the binary tree
     * @return: nothing
     */
	// traverse
    private TreeNode lastNode = null;
    public void flatten(TreeNode root) {//以root为根的flatten之后连到lastNode上
        // write your code here
        if (root == null){
            return;
        }
        if (lastNode != null){
            lastNode.left = null;
            lastNode.right = root;
        }
        
        lastNode = root;
        TreeNode right = root.right;//flatten(root.left)之后root.right变了
        flatten(root.left);
        flatten(right);
        return;
    }
    // divide and conquer
    public void flatten2(TreeNode root) {
        // write your code here
        helper(root);
        
    }
    // flatten root and return the last node
    public TreeNode helper(TreeNode root){
        if (root == null){
            return root;
        }
        if (root.left == null && root.right == null){
            return root;
        }
        
        // connect leftLast to root.right
        TreeNode left = root.left;
        TreeNode right = root.right;
        TreeNode leftlast = helper(left);
        TreeNode rightlast = helper(right);
        if (leftlast != null){   //!!! 没有这个判断会出错
            leftlast.right = right;
            root.left = null;
            root.right = left;
        }
        
        if (rightlast != null) {//!!!最后一个node可能来自左字数，右子树或者root
            return rightlast;
        }
        
        if (leftlast != null) {//!!!
            return leftlast;
        }
        
        return root;//!!!

    }
     
}
