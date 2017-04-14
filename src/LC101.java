import java.util.Stack;
public class LC101 {
		// solution1 : recursive
	    public boolean isSymmetric(TreeNode root) {
	        if (root == null) return true;
	        return helper(root.left, root.right);
	    }
	    public boolean helper(TreeNode r1, TreeNode r2){
	        //if (r1 == null && r2 == null) return true;
	        //if (r1 == null || r2 == null) return false;
	        //if (r1.left == null && r1.right == null){
	        //    if (r2.left == null && r2.right == null){
	        //        return r1.val == r2.val;
	        //    }
	        //    return false;
	        //} 以上这些可以用下面的一句话概括
	    	    if (r1 == null || r2 == null){
	    	    		return r1 == r2;
	    	    }
	    	    
	        //if (r2.left == null && r2.right == null){
	        //  if (r1.left == null && r1.right == null){
	        //      return r1.val == r2.val;
	        //  }
	        //  return false;
	        //} 以上这些可以不用
	    	    
	    	    // 关键在于r1.val == r2.val
	        return r1.val == r2.val && helper(r1.left, r2.right) && helper(r1.right, r2.left);
	    }
	    
	    // solution 2 : iterative
	    public boolean isSymmetric2(TreeNode root){
	    		if (root == null) return true;
	    		Stack<TreeNode> s = new Stack<TreeNode>();
	    		s.push(root.left);
	    		s.push(root.right);
	    		//1.r1,r2必须同时==null或!=null
	    		//2.r1.r2 val 相同
	    		//3.r1.left = r2.right && r1.right == r2.left;
	    		//4.一种想法是不push null进入stack，这样就要设条件再push，如下
	    		//5.另一种是push null进stack，然后进行比较，如果都是null就continue
	    		/**
	    		 * 不push null进stack
	    		 */
	    		while(!s.isEmpty()){
	    			TreeNode r1 = s.pop();
	    			TreeNode r2 = s.pop();
	    			if (r1 == null || r2 == null ) return r1 == r2;
	    			if (r1.val != r2.val) return false;
	    			if (r1.left==null || r2.right == null){
	    			    if(r1.left != r2.right) return false;
	    			}
	    			else{
	    			    s.push(r1.left);
	    		    	s.push(r2.right);
	    			}
	    			if (r1.right==null || r2.left == null){
	    			    if( r1.right != r2.left) return false;
	    			}
	    			else{
	    			    s.push(r1.right);
	    		    	s.push(r2.left);
	    			}
	    		}
	    		/**
	    		 * push null 进stack
	    		 */
	    		while(!s.isEmpty()){
	    			TreeNode r1 = s.pop();
	    			TreeNode r2 = s.pop();
	    			if (r1== null && r2 == null) continue;
	    			if (r1 == null || r2 == null ) return false;
	    			if (r1.val != r2.val) return false;
	    			s.push(r1.left);
	    			s.push(r2.right);
	    			s.push(r1.right);
	    			s.push(r2.left);
	    		}
	    		
	    		
	    		
	    		return true;
	    		
	    }
}
