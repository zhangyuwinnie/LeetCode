import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
public class LC501 {
	// preorder + hashmap, 为进一步简化，可将max设为class private variable
	public int[] findMode(TreeNode root) {
	    if (root == null) return new int[0];
	    HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
	    helper(root, map);
	    int max = 0;
	    for (Integer i : map.keySet()){
	    		if (map.get(i) > max){
	    			max = map.get(i);
	    		}
	    }
	    List<Integer> list = new ArrayList<Integer>();  
	    for (Integer i : map.keySet()){
	    		if (map.get(i) == max){
	    			list.add(i);
	    		}
	    }
    		int[] result = new int[list.size()];
    		for (int i1 = 0; i1<list.size();i1++){
    			result[i1] = list.get(i1);
    		}
    		return result;
    }

	public void helper(TreeNode root, HashMap<Integer,Integer> map){
		if (map.containsKey(root.val)){
			map.put(root.val,map.get(root.val)+1);
		}
		else{
			map.put(root.val,1);
		}
		if (root.left != null) helper(root.left, map);
		if (root.right != null) helper(root.right, map);
	}

}
