import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Queue;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
public class LC133 {
	 class UndirectedGraphNode {
	    int label;
	    List<UndirectedGraphNode> neighbors;
	    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
	 }
	/**
     * @param node: A undirected graph node
     * @return: A undirected graph node
     */
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // special case
        if (node == null){
            return null;
        }
        // bfs get nodes
        ArrayList<UndirectedGraphNode> nodes = getNodes(node);
        // copy nodes, old -> new map
        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        for (UndirectedGraphNode n : nodes){
            map.put(n, new UndirectedGraphNode(n.label));
        }
        // copy neighbours
        for (UndirectedGraphNode n : nodes){
            UndirectedGraphNode newNode = map.get(n);
            for (UndirectedGraphNode neighbor : n.neighbors){
                UndirectedGraphNode newNeighbor = map.get(neighbor);  
                newNode.neighbors.add(newNeighbor);
            }
        }
        return map.get(node);
    }
    public ArrayList<UndirectedGraphNode> getNodes(UndirectedGraphNode node){
        //ArrayList<UndirectedGraphNode> nodes = new ArrayList<UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        Set<UndirectedGraphNode> set = new HashSet<>();
        queue.offer(node);
        set.add(node);
        while (!queue.isEmpty()){
            UndirectedGraphNode curr = queue.poll();
            for (UndirectedGraphNode neighbor : curr.neighbors){
                if (!set.contains(neighbor)){
                    queue.offer(neighbor);
                    set.add(neighbor);
                }
            }
        }
        return new ArrayList<UndirectedGraphNode>(set);
    }
}
