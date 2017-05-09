import java.util.ArrayList;
import java.util.List;
public class LC113 {
	// 分治法
    /**
     * @param root the root of binary tree
     * @param target an integer
     * @return all valid paths
     */
     // 分治法
     // 定义：以root为根，和为target的结果
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        // 出口
        if (root == null){
            return result;
        }
        if (root.left == null && root.right == null){
            if (root.val == target){
                List<Integer> lis = new ArrayList<Integer>();
                lis.add(root.val);
                result.add(lis);
            }
            return result;
        }
        
        // 分治
        List<List<Integer>> leftpathsum = binaryTreePathSum(root.left, target - root.val); //(2,2)  return [[2]]
        List<List<Integer>> rightpathsum = binaryTreePathSum(root.right, target - root.val); //(null,2) return null
        
        if (leftpathsum != null && leftpathsum.size() != 0){
            for (List<Integer> lis : leftpathsum){
                lis.add(0, root.val);
                result.add(lis);
            }
        }
        if (rightpathsum != null && rightpathsum.size() != 0){
            for (List<Integer> lis : rightpathsum){
                lis.add(0, root.val);
                result.add(lis);
            }
        }
        return result;
    }
}
