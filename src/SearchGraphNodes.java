import java.util.Map;
import java.util.HashSet;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
public class SearchGraphNodes {
	 class UndirectedGraphNode {
		    int label;
		    List<UndirectedGraphNode> neighbors;
		    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
		 }
	/**
     * @param graph a list of Undirected graph node
     * @param values a hash mapping, <UndirectedGraphNode, (int)value>
     * @param node an Undirected graph node
     * @param target an integer
     * @return the a node
     */
    public UndirectedGraphNode searchNode(ArrayList<UndirectedGraphNode> graph,
                                          Map<UndirectedGraphNode, Integer> values,
                                          UndirectedGraphNode node,
                                          int target) {
        // special case
        if (node == null || graph == null){
            return null;
        }
        // bfs
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<UndirectedGraphNode>();
        
        queue.offer(node);
        set.add(node);
        
        while (!queue.isEmpty()){
            UndirectedGraphNode curr = queue.poll();
            if (values.get(curr) == target){
                return curr;
            }
            for (UndirectedGraphNode neighbor : curr.neighbors){
                if (!set.contains(neighbor)){
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }
        return null;
        
    }
}
