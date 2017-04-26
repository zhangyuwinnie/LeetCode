import java.util.Stack;
public class LC98 {
	// stack 法in order traversal + 判断
    public boolean isValidBST(TreeNode root) {
        if (root == null){
            return true;
        } 
        TreeNode pre = null;
        Stack<TreeNode> s = new Stack<>();
        TreeNode curr = root;
        while (curr != null || !s.isEmpty()){
            while (curr != null){
                s.push(curr);
                curr = curr.left;
            }
            curr = s.pop();
            if(pre != null && pre.val >= curr.val){ //!!!
                return false;
            }
            pre = curr;
            curr = curr.right;
        }
        return true;
    }
}
