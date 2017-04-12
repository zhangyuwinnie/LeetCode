import java.util.Arrays;

public class LC226 {
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
        		return null;
        				
        }
        if (root.left == null && root.right == null){
        		return root;
        }
        TreeNode tmp = root.left; // !!!先把左支存起来，不然下面改变了左支，再root.right = invertTree(root.left);就不对了
        root.left= invertTree(root.right);
        root.right = invertTree(tmp);
        return root;
    }
    public static void main (String[] args){
    		CvrtTree tree = new CvrtTree();
    		int[] arr = {4,2,7,1,3,6,9};
    		TreeNode root = tree.array2Tree(arr);
    		LC226 test = new LC226();
    		TreeNode reverse = test.invertTree(root);
    		int[] fan = tree.tree2Array(reverse);
    		System.out.println(Arrays.toString(fan));
    		
    		
    }
}
