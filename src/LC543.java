import java.util.Queue;
import java.util.LinkedList;
public class LC543 {
	// solution1: 2bfs not working， 主要因为TreeNode是单向的，第二次bfs的tree形不成
	public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;
        TreeNode last=new TreeNode(0); // 必须initialize，有一个地址之后，才能pass by reference
        int r1 = helper(root, last);
        TreeNode last2=new TreeNode(0);
        int r2 = helper(last, last2);
        return Math.max(r1,r2);
    }
    public int helper(TreeNode root, TreeNode last){
        int level = 0;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for (int i=0;i<size;i++){
                TreeNode curr = q.poll();
                if (curr.left != null){
                    q.add(curr.left);
                }
                if(curr.right != null){
                    q.add(curr.right);
                }
                last = new TreeNode(curr.val);               
            }
            level++;
        }
        return level;
    }
    
    // solution2: left+right,遍历
    private int max=0;
    public int diameterOfBinaryTree2(TreeNode root) {
    		if (root == null) return 0;//可以省略
    		maxDepth(root);
    		return max;
    }
    public int maxDepth(TreeNode root){
    		if (root == null) return 0;
    		int left = maxDepth(root.left);
    		int right = maxDepth(root.right);
    		max = Math.max(max, left+right); // depth不等于距离，但不算root，左右支depth之和就是过root的path的距离
    		return 1+Math.max(left, right);
    }
    
    public static void main ( String[] args){
		CvrtTree tree = new CvrtTree();
		int[] arr = {1,2,3,4,5};
		TreeNode root = tree.array2Tree(arr);
		LC543 test = new LC543();
		System.out.println(test.diameterOfBinaryTree2(root));
    }
}
