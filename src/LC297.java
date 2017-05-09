import java.util.ArrayList;

public class LC297 {
	/**
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // special case
    		if (root == null){
    			return "{}";
    		}
    	
    		// bfs -> arraylist
    		ArrayList<TreeNode> queue = new ArrayList<>();
    		queue.add(root);
    		
    		// loop for bfs
    		for (int i = 0; i < queue.size(); i++){
    			TreeNode node = queue.get(i);
    			// different from classic bfs, 第一次的null要放进去,第二次的不妨
    			if (node == null){
    			   continue;
    			}
    			queue.add(node.left);
    			queue.add(node.right);
    			
    		}
    		
    		while (queue.get(queue.size()-1) == null){
    			queue.remove(queue.size() -1);
    		}
    		
    		// convert to string
    		StringBuffer sb = new StringBuffer();
    		sb.append("{");
    		sb.append(queue.get(0).val);
    		for (int i = 1; i < queue.size(); i++){
    			if (queue.get(i) == null){
    				sb.append(",#");
    			} else {
    				sb.append(",");
    				sb.append(queue.get(i).val);
    			}
    		}
    		sb.append("}");
    		return sb.toString();	
    }
    
    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // special case
    		if (data.equals("{}")){
    			return null;
    		}
    		// parse data
    		String[] vals = data.substring(1, data.length() - 1).split(",");
    		// queue
    		ArrayList<TreeNode> queue = new ArrayList<>();
    		// root
    		TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
    		queue.add(root);
    		
    		int index = 0; // 跟踪当前要被加children的母节点
    		boolean isLeftChild = true; // 帮助母节点的跟踪，true，false一组，满一组index加1
    		
    		
    		for (int i = 1; i < vals.length; i++){ // 要从1开始了
    			// if "#", just skip, index, isLeftChild正常
    			if(!vals[i].equals("#")){
    			    //System.out.println(vals[i]);
    				TreeNode node = new TreeNode(Integer.parseInt(vals[i]));
    				queue.add(node);
    				if (isLeftChild){
    					queue.get(index).left = node;
    				} else {
    					queue.get(index).right = node;
    				}
    			}
    			if (!isLeftChild){
    				index++;
    			}
    			isLeftChild = !isLeftChild;
    		}
    		return root;
    }
}
