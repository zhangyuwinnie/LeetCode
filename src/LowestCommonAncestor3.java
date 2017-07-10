

class ResultType4{
    boolean a_exist;
    boolean b_exist;
    TreeNode node;
    ResultType4(boolean a_exist, boolean b_exist, TreeNode node){
        this.a_exist = a_exist;
        this.b_exist = b_exist;
        this.node = node;
    }
}

public class LowestCommonAncestor3 {
    /**
     * @param root The root of the binary tree.
     * @param A and B two nodes
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // write your code here
        ResultType4 result = helper(root, A, B);
        if (result.a_exist && result.b_exist){
            return result.node;
        }
        return null;//!!!
        
        

    }
    public ResultType4 helper(TreeNode root, TreeNode A, TreeNode B){
        if (root == null){
            return new ResultType4(false, false, null);
        }
        
        ResultType4 left = helper(root.left, A, B);
        ResultType4 right = helper(root.right, A, B);
        
        boolean a_exist = false; 
        boolean b_exist = false;
        if (left.a_exist || right.a_exist || root == A){
            a_exist = true;
        }
        if (left.b_exist || right.b_exist || root == B){
            b_exist = true;
        }
        
        if (root == A || root == B){//!!! Bug1: !!!漏写该情况
            return new ResultType4(a_exist, b_exist, root);
        }
        
        if (left.node != null && right.node != null){
            return new ResultType4(a_exist, b_exist, root);
        }
        
        if (left.node != null){
            return new ResultType4(a_exist, b_exist, left.node);//!!!Bug笔误
        }
        if (right.node != null){
            return new ResultType4(a_exist, b_exist, right.node);
        }
        return new ResultType4(a_exist, b_exist, null);
    }
}
//Note:多了一个是否存在于root的判断