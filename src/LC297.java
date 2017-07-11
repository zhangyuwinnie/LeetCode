import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

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
        //bfs get list of nodes in level order traverse
        ArrayList<TreeNode> nodes = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        nodes.add(root);
        q.offer(root);
        while (!q.isEmpty()){
            TreeNode curt = q.poll();
            if (curt.left != null){
                q.offer(curt.left);
                nodes.add(curt.left); 
            } else {
                nodes.add(null);//!!!null也要放进去
            }
            if (curt.right != null){
                q.offer(curt.right);
                nodes.add(curt.right); 
            } else {
                nodes.add(null);
            }
        }
        // remove null at last
        while (nodes.get(nodes.size() - 1) == null){
            nodes.remove(nodes.size() - 1);
        }
        // convert list of nodes to string
        StringBuffer result = new StringBuffer();
        int size = nodes.size();
        result.append("{");
        for (int i = 0; i < size; i++){
            if (nodes.get(i) != null){
                result.append(nodes.get(i).val);
            } else {
                result.append("#");
            }
            if (i != size - 1){
                result.append(",");
            }
        }
        result.append("}");
        return result.toString();
        
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
        if (data == "{}"){
            return null;
        }
        // convert string to arrayList
        ArrayList<TreeNode> nodes = new ArrayList<>();
        String middle = data.substring(1, data.length() - 1);//!!!
        String[] values = middle.split(",");
        for (String value : values){
            if (!value.equals("#")){
                // System.out.println(value+" "+Integer.parseInt(value));
                nodes.add(new TreeNode(Integer.parseInt(value)));
            } else {
                nodes.add(null);
            }
        }
        // System.out.println(nodes.size());
        // loop list construct the tree
        int index = 0; // keep track of root
        for (int i = 1; i < nodes.size(); i++){//从1开始
            TreeNode root = nodes.get(index);
            if (i % 2 == 1){//叶子成对出现，用奇偶判断左右节点
                // System.out.println(root.val);
                root.left = nodes.get(i);
            } else {
                root.right = nodes.get(i);// 每轮完右节点，root指针前进一个
                index++;
                while (nodes.get(index) == null){//!!!Bug:root轮到null要跳过
                    index++;
                }
            }
        }
        return nodes.get(0);
    }
}
//NOte
//serialize: 结构化到string，用bfs，注意null的保留
//deserialize：string到结构，得到array of nodes，loop through it, 将后面的node慢慢挂到前面的root上构建成树，
//用一个指针跟踪root位置，用位置的奇偶性判断左右节点
