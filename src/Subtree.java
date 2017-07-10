
public class Subtree {
    /**
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        // write your code here
        if (T2 == null){
            return true;
        }
        if (T1 == null){
            return false;
        }
        return subtreeFromRoot(T1, T2) || isSubtree(T1.left, T2) || isSubtree(T1.right, T2);
    }
    public boolean subtreeFromRoot(TreeNode T1, TreeNode T2){
        if (T1 == null || T2 == null) {//!!! Bug,理解好题意，subtree必须那一部分完全一样
            return T1 == T2;
        }
        return T1.val == T2.val && subtreeFromRoot(T1.left, T2.left) && subtreeFromRoot(T1.right, T2.right);
    }
}
//思路：divide and conquer
