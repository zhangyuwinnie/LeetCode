import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class LC199 {
	// solution1: 借鉴LC102的想法
    public List<Integer> rightSideView(TreeNode root) {
    		List<Integer> finalresult = new ArrayList<Integer>();
    		List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) return finalresult;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while (!q.isEmpty()){
        		int size = q.size();
        		List<Integer> a = new ArrayList<Integer>();
        		for (int i = 0; i<size; i++){
        			TreeNode curr = q.poll();
        			a.add(curr.val);
        			if (curr.left!= null){
        				q.add(curr.left);
        			}
        			if (curr.right!= null){
        				q.add(curr.right);
        			}
        		}
        		result.add(a);
        }
        int len = result.size();
        for (int i = 0; i<len; i++){
        		int b = result.get(i).size();
        		finalresult.add( result.get(i).get(b-1));
        }
        return finalresult;
    }
    
    // solution2
    public List<Integer> rightSideView2(TreeNode root){
    		List<Integer> result = new ArrayList<Integer>();
    		if (root == null) return result;
    		helper(root, result, 0);
    		return result;
    }
    
    public void helper(TreeNode root, List<Integer> result, int depth){
    		if (root == null) return;
    		if (depth == result.size()){
    			result.add(root.val);
    		}
    		helper(root.right, result, depth+1);
    		helper(root.left, result, depth+1);
    		
    }
    
    public static void main(String[] args){
    		CvrtTree tree = new CvrtTree();
		int[] arr = {4,2,7,1,3,6,9};
		TreeNode root = tree.array2Tree(arr);
		LC199 test = new LC199();
		System.out.println(test.rightSideView2(root));
    }
}
