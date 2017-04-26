import java.util.ArrayList;
import java.util.List;
public class LC95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<TreeNode>(); //!!! side case,否则返回[[]],而不是[]
        return genTree(1,n);
        
    }
    
    public List<TreeNode> genTree(int start, int end){
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end){
            result.add(null); //!!! 必须加null不然好多项没有了，null在list里是[],不加null的话，什么都没有
            return result;
        }
        if (start == end){
            result.add(new TreeNode(start));
            return result;
        }

        for (int i = start; i <= end; i++){
            List<TreeNode> left = genTree(start, i-1);
            List<TreeNode> right = genTree(i+1, end);
            for (TreeNode leftnode : left){
                for (TreeNode rightnode : right){
                    TreeNode root = new TreeNode(i);
                    root.left = leftnode;
                    root.right = rightnode;
                    result.add(root);
                }
            }
        }
        return result;
    }

}
