
public class LowestCommonAncestor {
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        if (root == null || root == A || root == B){
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        if (left != null && right != null){//如果LCA是root，那么left=A, right = B,也就是都不是null
            return root;
        }
        if (left != null){//如果LCA是left，那么left 不是null，right是null,right不是null的情况上面考虑了，这里right是null，
            return left;
        }
        if (right != null){//同上
            return right;
        }
        return null;
    }
}
