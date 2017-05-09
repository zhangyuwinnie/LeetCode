import java.util.ArrayList;
import java.util.List;
public class LC257 {
	//遍历法
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
    // 分治法
    // 定义： 返回以root为根的tree path
    public List<String> binaryTreePath2(TreeNode root){
    		List<String> result = new ArrayList<String>();
    		// 出口
    		if (root == null){
    			return result;
    		}
    		if (root.left == null && root.right == null){
    			result.add(String.valueOf(root.val));
    			return result;
    		}
    		// 拆解
    		// divide
    		List<String> leftpath = binaryTreePath2(root.left);
    		List<String> rightpath = binaryTreePath2(root.right);
    		// 合并
    		for (String path : leftpath){
    			result.add(root.val + "->" + path);
    		}
    		
    		for (String path : rightpath){
    			result.add(root.val + "->" + path);
    		}
    		return result;
    }

    //遍历法2
    public List<String> binaryTreePaths3(TreeNode root){
    		List<String> result = new ArrayList<>();
    		if (root == null){
    			return result;
    		}
    		String curr = "";
    		helper2(root, curr, result);
    		return result;
    }
    
    // 递归定义: 等到以curr开头并经过root的所有path，并将这些paths加入result中
    public void helper2(TreeNode root, String curr, List<String> result){
    		// 出口
    		if (root == null){
    			return;
    		}
    		// 先把root加入到curr中
    		if (curr == "" ){
    			curr = curr + String.valueOf(root.val); // curr = ->1
    		} else {
    			curr = curr + "->" + String.valueOf(root.val); // curr = ->1
    		}
    		if (root.left == null && root.right == null){
    			result.add(curr);
    		}
    		// 拆解
    		helper2(root.left, new String(curr), result);
    		helper2(root.right, new String(curr), result);
    }
    
    
    public static void main ( String[] args){
    		CvrtTree tree = new CvrtTree();
		int[] arr = {4,2,7,1,3,6,9};
		TreeNode root = tree.array2Tree(arr);
		LC257 test = new LC257();
		System.out.println(test.binaryTreePath2(root));
		System.out.println(test.binaryTreePaths3(root));
    }
}
