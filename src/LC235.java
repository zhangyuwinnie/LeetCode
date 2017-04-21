
public class LC235 {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        int min = Math.min(p.val,q.val);
        int max = Math.max(p.val,q.val);
        while (curr.val >max || curr.val<min){
            if (curr.val >max) curr = curr.left;
            if (curr.val<min) curr = curr.right;
        }
        return curr;
    }
}
