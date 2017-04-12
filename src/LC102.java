import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class LC102 {
	public List<List<Integer>> levelOrder(TreeNode root) {
		 List<List<Integer>> result = new ArrayList<List<Integer>>();
		 if (root == null) return result;
		 // TreeNode  curr = root;
		 Queue<TreeNode> q = new LinkedList<TreeNode>();
		 q.add(root);
		 while (!q.isEmpty()){
			 int size = q.size();
			 List<Integer> level = new ArrayList<Integer>();
			 for ( int i = 0; i<size; i++){
				 TreeNode curr = q.poll();
				 level.add(curr.val);
				 if (curr.left != null){
					 q.add(curr.left);
				 }
				 if (curr.right != null){
					 q.add(curr.right);
				 }
			 }
			 result.add(level);
		 }	
		 return result;
    }	
	public static void main (String[] args){
		LC102 test = new LC102();
		CvrtTree tree = new CvrtTree();
		int[] arr = {4,2,7,1,3,6,9};
		TreeNode root = tree.array2Tree(arr);
		List<List<Integer>> li = test.levelOrder(root);
		System.out.println(li);
	}
}
