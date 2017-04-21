import java.util.HashMap;
import java.util.HashSet;
public class LC236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        HashMap<TreeNode,TreeNode> map = new HashMap<TreeNode, TreeNode>();
        map.put(root,null);
        helper(root, map);
        TreeNode ancestorp = p;
        TreeNode ancestorq = q;
	    // p parent的集合
	    HashSet<TreeNode> pset = new HashSet<TreeNode>();
	    pset.add(root);
	    while(ancestorp != root){
	        pset.add(ancestorp);
	        ancestorp = map.get(ancestorp);
	    }
	    // q parent
	    while(ancestorq != root){
	        if (pset.contains(ancestorq)){
	            return ancestorq;
	        }
	        else{
	            ancestorq = map.get(ancestorq);
	        }
	    }
	    return root;
	}
	public void helper(TreeNode root, HashMap<TreeNode, TreeNode> map){
	    if (root.left!= null){
	        map.put(root.left,root);
	        helper(root.left,map);
	    }
	    if (root.right != null){
	        map.put(root.right,root);
	        helper(root.right,map);
	    }
	}
}