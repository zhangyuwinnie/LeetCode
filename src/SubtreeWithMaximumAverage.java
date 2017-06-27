class ResultType2{
    public int nodes;
    public int sum;
    ResultType2(int nodes, int sum){
        this.nodes = nodes;
        this.sum = sum;
    }
}
public class SubtreeWithMaximumAverage {
    /**
     * @param root the root of binary tree
     * @return the root of the maximum average of subtree
     */
    private ResultType2 avg;
    private TreeNode subtree;
    public TreeNode findSubtree2(TreeNode root) {
        // Write your code here
        helper(root);
        return subtree;
    }
    public ResultType2 helper(TreeNode root){
        if (root == null){
            // if (avg < 0){
            //     avg = 0;
            //     subtree = root;
            // }
            return new ResultType2(0, 0);
        }
        // if (root.left == null && root.right == null){
        //     if (avg < root.val){
        //         avg = root.val;
        //         subtree = root;
        //     }
        //     return new ResultType(1, root.val);
        // }
        ResultType2 left = helper(root.left);
        ResultType2 right = helper(root.right);
        ResultType2 result = new ResultType2(left.nodes + right.nodes + 1, left.sum + right.sum + root.val);
        if (avg == null || avg.sum * result.nodes < avg.nodes * result.sum ){
            avg = result;
            subtree = root;
        }
        return result;
    }
}
