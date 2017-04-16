
public class LC111 {
	public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return helper(root);
    }
    public int helper(TreeNode root){
    		// null的处理和上面的分开，这里为了处理有单边null时，min并非是null的那边，而是非null的一边
        if (root == null) return Integer.MAX_VALUE;
        if (root.left == null & root.right == null) return 1;
        return 1+Math.min(helper(root.left),helper(root.right));
    }
    
    
    public static void main(String[] args){
    	CvrtTree tree = new CvrtTree();
		int[] arr = {1,1};
		TreeNode root = tree.array2Tree(arr);
		LC111 test =new LC111();
		System.out.println(test.minDepth(root));
    }
}
