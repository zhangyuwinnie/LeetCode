import java.util.List;
import java.util.ArrayList;
import java.util.Stack;
public class LC94 {
	// iterative solution
    public List<Integer> inorderTraversal(TreeNode root) {
    		List<Integer> result = new ArrayList<>();
    		if (root == null) {
    			return result;
    		}
    		Stack<TreeNode> s = new Stack<>();
    		TreeNode curr = root;// 不用先push root
    		while (curr != null || !s.isEmpty()){
    			while (curr != null){
    				s.push(curr);
    				curr = curr.left;
    			}
    			curr = s.pop();
    			result.add(curr.val);
    			curr = curr.right;   				
    		}
    		return result;   		
    }
	
}
