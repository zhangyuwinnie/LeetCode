
public class BinaryTreeLongestConsecutiveSequence {

    /**
     * @param root the root of binary tree
     * @return the length of the longest consecutive sequence path
     */
    private int longest;
    public int longestConsecutive(TreeNode root) {
        // Write your code here
        longestfromRoot(root);
        return longest;
    }
    public int longestfromRoot(TreeNode root){
        if (root == null){
            return 0;
        }
        int rootlong = 1;
        int left = longestfromRoot(root.left);
        if (root.left != null && root.left.val - 1 == root.val){
            rootlong = Math.max(rootlong, left + 1);
        }
        int right = longestfromRoot(root.right);
        if (root.right != null && root.right.val - 1 == root.val){
                rootlong = Math.max(rootlong,right + 1);
        }
        if (rootlong > longest){
            longest = rootlong;
        }
        return rootlong;
    }
}
//Note:
//	注意理解题意，是binary search tree,而且要求升序，不能降续