import java.util.ArrayList;
import java.util.List;
public class LC257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if (root == null) return result;
        // String curr= String.valueOf(root.val);
        List<List<Integer>> arr = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        helper(root, arr, curr);
        for (int i = 0; i < arr.size(); i++){
            String item = String.valueOf(root.val);
            List<Integer> trans = arr.get(i);
            for (int j = 0; j<trans.size();j++){
                if (j != 0){
                   item = item + "->" + String.valueOf(trans.get(j));
                }
            }
            result.add(item);
        }
        return result;
    }
    
    public void helper(TreeNode root, List<List<Integer>> result,  List<Integer> curr){
        
        curr.add(root.val);
        if (root.left == null && root.right == null){
            result.add(curr);
            return;
        }
        if (root.left != null){
            List<Integer> tmp = new ArrayList<Integer>(curr);
            helper(root.left, result, tmp);
        }
        if (root.right != null){
            List<Integer> tmp = new ArrayList<Integer>(curr);
            helper(root.right, result, tmp);
        }  
    }
    public static void main ( String[] args){
    		CvrtTree tree = new CvrtTree();
		int[] arr = {4,2,7,1,3,6,9};
		TreeNode root = tree.array2Tree(arr);
		LC257 test = new LC257();
		System.out.println(test.binaryTreePaths(root));
    }
}
